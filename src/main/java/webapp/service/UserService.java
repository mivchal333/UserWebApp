package webapp.service;

import webapp.model.User;
import webapp.model.enimeration.Role;
import webapp.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {

    private UserRepository userRepository;
    private static UserService instance = null;

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    private UserService() {
        this.userRepository = UserRepository.getInstance();
    }

    public Role getUserRole(User user) {
        return userRepository.getUserRole(user);

    }

    public Optional<User> loginUser(String login, String password) {
        return userRepository.getUserByLoginData(login, password);
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    public Optional<User> getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }
}
