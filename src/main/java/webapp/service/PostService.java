package webapp.service;

import org.apache.commons.lang.StringUtils;
import webapp.model.Post;
import webapp.model.User;
import webapp.model.enimeration.Role;
import webapp.repository.PostRepository;
import webapp.util.ValidateResult;
import webapp.util.ValidateResultType;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

public class PostService {
    private static PostRepository postRepository;
    private static PostService instance = null;


    public List<Post> getPosts() {
        List<Post> posts = postRepository.getPosts();
        for (Post post : posts) {
            post.setUser(new User(1, "admin", "admin123", Role.ADMIN));
        }
        return posts;
    }

    public ValidateResult validatePost(String title, String content) {
        ValidateResult result = new ValidateResult("Post Added :)", ValidateResultType.SUCCESS);
        if (StringUtils.isEmpty(title)) {
            result.setValue("Title field empty!");
            result.setType(ValidateResultType.ERROR);
            return result;
        } else if (StringUtils.isEmpty(content)) {
            result.setValue("Content field empty!");
            result.setType(ValidateResultType.ERROR);
            return result;
        }
        return result;
    }


    public void addPost(String title, String content, HttpSession session) {
        User userObj = (User) session.getAttribute("userObj");
        Post post = new Post(title, content, new Date());
        post.setUser(userObj);
        post.setAuthor(userObj.getLogin());
        postRepository.addPost(post);
    }

    public static PostService getInstance() {
        if (instance == null) instance = new PostService();
        return instance;
    }

    private PostService() {
        postRepository = PostRepository.getInstance();
    }
}
