package com.norbertcseh.cabackend.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.Profile;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Size(min = 3, message = "Name should have at least 3 characters!")
    private String fullName;

    @NotNull
    private String email;

    @NotNull
    @Size(min = 8, message = "Password is to short!")
    private String password;

    private Date registerDate;

    @NotNull
    private String handle;

    // Current job/school
    private String status;

    @Past
    private Date birthday;

    private String[] skills;

    // Social sites
    private String facebook;
    private String twitter;
    private String instagram;
    private String linkedin;
    private String youtube;

    // Avatar link Gravatar wannabe
    private String avatar;

    @OneToMany(mappedBy = "user")
    private List<Experience> experience;

    @OneToMany(mappedBy = "user")
    private List<Education> education;

    protected User() {

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
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the registerDate
     */
    public Date getRegisterDate() {
        return registerDate;
    }

    /**
     * @param registerDate the registerDate to set
     */
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * @return the avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar the avatar to set
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the skills
     */
    public String[] getSkills() {
        return skills;
    }

    /**
     * @param skills the skills to set
     */
    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    /**
     * @return the facebook
     */
    public String getFacebook() {
        return facebook;
    }

    /**
     * @param facebook the facebook to set
     */
    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    /**
     * @return the twitter
     */
    public String getTwitter() {
        return twitter;
    }

    /**
     * @param twitter the twitter to set
     */
    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    /**
     * @return the instagram
     */
    public String getInstagram() {
        return instagram;
    }

    /**
     * @param instagram the instagram to set
     */
    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    /**
     * @return the linkedin
     */
    public String getLinkedin() {
        return linkedin;
    }

    /**
     * @param linkedin the linkedin to set
     */
    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    /**
     * @return the youtube
     */
    public String getYoutube() {
        return youtube;
    }

    /**
     * @param youtube the youtube to set
     */
    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    /**
     * @return the experience
     */
    public List<Experience> getExperience() {
        return experience;
    }

    /**
     * @param experience the experience to set
     */
    public void setExperience(List<Experience> experience) {
        this.experience = experience;
    }

    /**
     * @return the education
     */
    public List<Education> getEducation() {
        return education;
    }

    /**
     * @param education the education to set
     */
    public void setEducation(List<Education> education) {
        this.education = education;
    }

    /**
     * @return the handle
     */
    public String getHandle() {
        return handle;
    }

    /**
     * @param handle the handle to set
     */
    public void setHandle(String handle) {
        this.handle = handle;
    }

}