package webapp.model;

import org.bson.Document;
import org.bson.types.ObjectId;
import webapp.model.enimeration.Role;

import java.util.Objects;

public class User {
    private String id;
    private String login;
    private String password;
    private Role role;

    public User(String id, String login, String password, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

    public Document getUserAsDocument() {
        Document doc = new Document("login", login)
                .append("password", password)
                .append("role", role.name());
        if (Objects.isNull(id)) {
            doc.append("_id", new ObjectId(id));
        }
        return doc;
    }

    public static User fromDocument(Document doc) {
        ObjectId id = doc.getObjectId("_id");
        String login = doc.getString("login");
        String password = doc.getString("password");
        Role role = Role.valueOf(doc.getString("role"));
        User user = new User(login, password, role);

        if (Objects.nonNull(id)) {
            user.setId(id.toString());
        }
        return user;
    }
}
