package webapp;

import java.util.Arrays;
import java.util.List;

/*
* Simple mock for training
* */
public class UserRepository {
    private static List<User> users = Arrays.asList(
            new User("admin@admin.com", "admin123", Role.ADMIN),
            new User("user@user.com", "user123", Role.USER));

    public static boolean existUser(User user) {
        return users.contains(user);
    }

    public static boolean checkPassword(User user) {
        User userMock = users.get(users.indexOf(user));
        String correctPass = userMock.getPassword();
        return correctPass.equals(user.getPassword());
    }
    public static Role getUserRole(User user){
        User userMock = users.get(users.indexOf(user));
        return userMock.getRole();

    }
}
