package webapp.repository;

import com.google.common.collect.Lists;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;
import webapp.config.DbUtil;
import webapp.model.Post;
import webapp.model.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PostRepository {
    private static PostRepository instance = null;
    private MongoCollection<Document> posts;

    public static PostRepository getInstance() {
        if (instance == null) instance = new PostRepository();
        return instance;
    }

    public void addPost(String title, String content, User user) {
        Post post = new Post(user.getLogin(), title, content, user);
        Document postAsDocument = post.getPostAsDocument();
        posts.insertOne(postAsDocument);
    }

    private PostRepository() {
        posts = DbUtil.getConnection().getCollection("posts");
    }


    public void deletePost(String id) {
        posts.findOneAndDelete(Filters.eq("_id", new ObjectId(id)));
    }

    public Optional<Post> getPost(String id) {
        Document postDoc = posts.find(Filters.eq("_id", new ObjectId(id))).first();
        if (postDoc != null) {
            Post post = Post.getFromDocument(postDoc);
            return Optional.of(post);
        }
        return Optional.empty();
    }

    public Optional<User> getUser(String id) {
        System.out.println("get user post retpo Id: " + id);
        Optional<Post> post = getPost(id);
        if (post.isPresent()) {
            User user = post.get().getUser();
            return Optional.ofNullable(user);
        }
        return Optional.empty();
    }

    public List<Post> getPosts() {

        FindIterable<Document> documents = posts.find();
        return Lists.newArrayList(documents).stream().map(Post::getFromDocument).collect(Collectors.toList());
    }
}
