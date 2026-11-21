package it.aulab.blogmongo.models;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts") 
public class Post {
@Id 
private String id;
private String title;
private String body;
private String publishDate;
private Integer views;
private List<String> tags;
private Author author;
private List<Comment> comments;
public List<Comment> getComments() {
    return comments;
}
public void setComments(List<Comment> comments) {
    this.comments = comments;
}
public Post( String title, String body, String publishDate, Author author) {
    
    this.title = title;
    this.body = body;
    this.publishDate = publishDate;
    this.author = author;
}
public Post (){

}
public String getId() {
    return id;
}
public void setId(String id) {
    this.id = id;
}
public String getTitle() {
    return title;
}
public void setTitle(String title) {
    this.title = title;
}
public String getBody() {
    return body;
}
public void setBody(String body) {
    this.body = body;
}
public String getPublishDate() {
    return publishDate;
}
public void setPublishDate(String publishDate) {
    this.publishDate = publishDate;
}
public Integer getViews() {
    return views;
}
public void setViews(Integer views) {
    this.views = views;
}
public List<String> getTags() {
    return tags;
}
public void setTags(List<String> tags) {
    this.tags = tags;
}
public Author getAuthor() {
    return author;
}
public void setAuthor(Author author) {
    this.author = author;
}
}
