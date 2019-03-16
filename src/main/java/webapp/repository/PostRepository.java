package webapp.repository;

import webapp.model.Post;
import webapp.model.User;
import webapp.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PostRepository {
    private static PostRepository instance = null;
    private List<Post> posts;
    private UserService userService;

    public static PostRepository getInstance() {
        if (instance == null) instance = new PostRepository();
        return instance;
    }

    public void addPost(String title, String content, User user) {
        Post post = new Post(user.getLogin(), title, content, new Date(), user);
        posts.add(post);
    }

    private PostRepository() {
        userService = UserService.getInstance();
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void deletePost(String title) {
        for (Post post : posts) {
            if (post.getTitle().equals(title)) {
                posts.remove(post);
                return;
            }
        }
    }

    public Optional<Post> getPost(String title) {

        for (Post post : posts) {
            if (post.getTitle().equals(title)) {
                return Optional.of(post);
            }
        }
        return Optional.empty();
    }

    public User getUser(String title){
        for (Post post : posts) {
            if (post.getTitle().equals(title)) {
                return post.getUser();
            }
        }
        return new User();
    }
}
