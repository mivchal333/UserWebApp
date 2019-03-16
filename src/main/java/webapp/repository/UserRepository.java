package webapp.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import webapp.config.DbUtil;
import webapp.model.User;
import webapp.model.enimeration.Role;

import java.util.Objects;
import java.util.Optional;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class UserRepository {

    private static UserRepository instance = null;
    private MongoCollection<Document> users;

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    private UserRepository() {
        users = DbUtil.getConnection().getCollection("users");
    }

    public MongoCollection<Document> getUsers() {
        return users;
    }

    public Optional<User> getUserByLoginData(String login, String password) {

        Document userDoc = users.find(and(eq("login", login), eq("password", password))).first();
        if (!Objects.isNull(userDoc)) {
            User user = User.fromDocument(Objects.requireNonNull(userDoc));
            return Optional.ofNullable(user);
        }
        return Optional.empty();
    }

    public Optional<User> getUserByLogin(String login) {
        Document userDoc = users.find(Filters.eq("login", login)).first();
        if (!Objects.isNull(userDoc)) {
            Optional<User> userOptional = Optional.ofNullable(User.fromDocument(userDoc));
        }
        return Optional.empty();
    }

    public Role getUserRole(User user) {
        Document userDoc = users.find(eq("login", user.getLogin())).first();
        String roleString = userDoc.getString("role");
        return Role.valueOf(roleString);
    }

    public void save(User user) {
        if (!userExist(user.getLogin())) {
            users.insertOne(user.getUserAsDocument());
        }
    }

    public boolean userExist(String login) {
        return Objects.nonNull(users.find(eq("login", login)).first());
    }

}
