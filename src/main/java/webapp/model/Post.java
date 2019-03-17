package webapp.model;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Post {
    private String id;
    private String author;
    private String title;
    private String content;


    private User user;

    public Post(String id, String author, String title, String content, User user) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public Post(String author, String title, String content, User user) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static Post getFromDocument(Document doc) {
        ObjectId id = doc.getObjectId("_id");
        String author = doc.getString("author");
        String title = doc.getString("title");
        String content = doc.getString("content");
        Document userDoc = (Document) doc.get("user");
        User user = User.fromDocument(userDoc);
        return new Post(id.toString(), author, title, content, user);
    }

    public Document getPostAsDocument() {
        return new Document("author", author)
                .append("title", title)
                .append("content", content)
                .append("user", user.getUserAsDocument());
    }


}