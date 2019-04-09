package com.norbertcseh.cabackend.Entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;

    private String commentBody;

    private Date commentDate;

    private Comment() {
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
     * @return the post
     */
    public Post getPost() {
        return post;
    }

    /**
     * @param post the post to set
     */
    public void setPost(Post post) {
        this.post = post;
    }

    /**
     * @return the commentBody
     */
    public String getCommentBody() {
        return commentBody;
    }

    /**
     * @param commentBody the commentBody to set
     */
    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    /**
     * @return the commentDate
     */
    public Date getCommentDate() {
        return commentDate;
    }

    /**
     * @param commentDate the commentDate to set
     */
    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

}