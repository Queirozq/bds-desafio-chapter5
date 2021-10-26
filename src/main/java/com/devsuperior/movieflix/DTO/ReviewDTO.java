package com.devsuperior.movieflix.DTO;

import com.devsuperior.movieflix.entities.Review;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class ReviewDTO implements Serializable {

    private Long id;
    @NotBlank
    private String text;
    private String userName;
    private Long movieId;

    public ReviewDTO() {
    }

    public ReviewDTO(Long id, String text, String userName, Long movieId) {
        this.id = id;
        this.text = text;
        this.userName = userName;
        this.movieId = movieId;
    }

    public ReviewDTO(Review obj) {
        this.id = obj.getId();
        this.text = obj.getText();
        this.userName = obj.getUser().getName();
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

    public String getUserName() {
        return userName;
    }

    public void setUserId(String userName) {
        this.userName = userName;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
