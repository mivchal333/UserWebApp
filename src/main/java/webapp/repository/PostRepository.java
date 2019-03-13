package webapp.repository;

import webapp.model.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostRepository {
    private static PostRepository instance = null;
    private List<Post> posts;

    public static PostRepository getInstance() {
        if (instance == null) instance = new PostRepository();
        return instance;
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    private PostRepository() {
        posts = new ArrayList<>();
        posts.add(new Post("Java servlets", "Today we all are aware of the need of creating dynamic web pages i.e the ones which have the capability to change the site contents according to the time or are able to generate the contents according to the request received by the client. If you like coding in Java, then you will be happy to know that using Java", new Date()));
        posts.add(new Post("Wprowadzenie do Javy", "Czekoalda i banany super dfiasdiaiodnaofdo", new Date()));
        posts.add(new Post("Bardzo fany tytuł!", "Today we all are aware of the need of creating dynamic web pages i.e the ones which have the capability to change the site contents according to the time or are able to generate the contents according to the request received by the client. If you like coding in Java, then you will be happy to know that using Java", new Date()));

    }

    public List<Post> getPosts() {
        return posts;
    }
}
