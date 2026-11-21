package it.aulab.blogmongo.models;

public class Comment {
    private String email;
    private String body;
    private String date;
    public Comment(String email, String body, String date) {
        this.email = email;
        this.body = body;
        this.date = date;
    }
    public Comment() {
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    

}
