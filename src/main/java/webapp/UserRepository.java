package webapp;

import java.util.ArrayList;
import java.util.List;

/*
 * Simple mock for training
 * */
public class UserRepository {
    private List<User> users;
    private static UserRepository instance;

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public  boolean existUser(User user) {
        return users.contains(user);
    }

    public  boolean checkPassword(User user) {
        User userMock = users.get(users.indexOf(user));
        String correctPass = userMock.getPassword();
        return correctPass.equals(user.getPassword());
    }

    public  Role getUserRole(User user) {
        User userMock = users.get(users.indexOf(user));
        return userMock.getRole();

    }

    public UserRepository() {
        users = new ArrayList<>();
        users.add(new User("admin@admin.com", "admin123", Role.ADMIN));
        users.add(new User("user@user.com", "user123", Role.USER));
    }
}
