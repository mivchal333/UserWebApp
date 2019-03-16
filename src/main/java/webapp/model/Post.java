package webapp.model;

import java.util.Date;

public class Post {

    private String author;
    private String title;
    private String content;
    private Date date;

    private User user;

    public Post(String author, String title, String content, Date date, User user) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.date = date;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
