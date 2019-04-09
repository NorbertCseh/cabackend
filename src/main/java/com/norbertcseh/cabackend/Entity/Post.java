package com.norbertcseh.cabackend.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private User user;

    private String postBody;

    private Date postDate;

    @OneToMany(mappedBy = "post")
    private List<Comment> comment;

    private Post() {
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the postBody
     */
    public String getPostBody() {
        return postBody;
    }

    /**
     * @param postBody the postBody to set
     */
    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    /**
     * @return the postDate
     */
    public Date getPostDate() {
        return postDate;
    }

    /**
     * @param postDate the postDate to set
     */
    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    /**
     * @return the comment
     */
    public List<Comment> getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

}