package webapp.service;

import org.apache.commons.lang.StringUtils;
import webapp.model.Post;
import webapp.model.User;
import webapp.repository.PostRepository;
import webapp.util.ValidateResult;
import webapp.util.ValidateResultType;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public class PostService {
    private static PostRepository postRepository;
    private static PostService instance = null;


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
        postRepository.addPost(title, content, userObj);
    }

    public static PostService getInstance() {
        if (instance == null) instance = new PostService();
        return instance;
    }

    private PostService() {
        postRepository = PostRepository.getInstance();
    }

    public void deletePost(String id) {
        postRepository.deletePost(id);
    }

    public Optional<Post> getPost(String title) {
        return postRepository.getPost(title);
    }

    public Optional<User> getUser(String postId) {
        return postRepository.getUser(postId);
    }

    public List<Post> getPosts() {
        return postRepository.getPosts();
    }
}
