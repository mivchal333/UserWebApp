package webapp.repository;

import webapp.model.Post;
import webapp.model.User;
import webapp.service.UserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        posts = new ArrayList<>();
        userService = UserService.getInstance();
        posts.add(new Post(userService.getUserByLogin("admin").get().getLogin(),
                "Java",
                "Today we all are aware of i.e the ones which have the capability to " +
                        "change the site contents according to the time or are able to generate the contents according to the request" +
                        " received by the client. If you like coding in Java, then you will be happy to know that using Java",
                new Date(),
                userService.getUserByLogin("admin").get()));

        posts.add(new Post((userService.getUserByLogin("admin").get().getLogin()),
                "Wprowadzenie",
                "Czekoalda i banany super i banany super i banany super i banany super i banany super i banany super i banany super ",
                new Date(),
                userService.getUserByLogin("user").get()));
        posts.add(new Post(userService.getUserByLogin("admin").get().getLogin(),
                "Bardzo!",
                "Today we all are aware of the need of creating dynamic web pages i.e the ones which have the capability" +
                        " to change the site contents according to the time or are able to generate the contents according " +
                        " to know that using Java",
                new Date(),
                userService.getUserByLogin("admin").get()));
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
}
