package com.devsuperior.movieflix.DTO;

import com.devsuperior.movieflix.entities.Review;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class ReviewInsertDTO implements Serializable {

    private Long id;
    @NotBlank
    private String text;
    private UserDTO user;
    private Long movieId;

    public ReviewInsertDTO() {
    }

    public ReviewInsertDTO(Review obj) {
        this.id = obj.getId();
        this.text = obj.getText();
        this.user = new UserDTO(obj.getUser());
        this.movieId = obj.getMovie().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
