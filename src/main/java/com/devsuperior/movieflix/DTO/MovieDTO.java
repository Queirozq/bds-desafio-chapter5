package com.devsuperior.movieflix.DTO;


import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MovieDTO implements Serializable {


    private Long id;
    private String title;
    private String subTitle;
    private Integer year;
    private String imgUrl;
    private String synopsis;

    private GenreDTO genre;

    List<ReviewDTO> reviews = new ArrayList<>();

    public MovieDTO() {
    }

    public MovieDTO(Movie obj) {
        this.id = obj.getId();
        this.title = obj.getTitle();
        this.subTitle = obj.getSubTitle();
        this.year = obj.getYear();
        this.imgUrl = obj.getImgUrl();
        this.synopsis = obj.getSynopsis();
        this.genre = new GenreDTO(obj.getGenre());
    }

    public MovieDTO(Movie obj, List<Review> reviews){
        this(obj);
        reviews.forEach(x-> this.reviews.add(new ReviewDTO(x)));
    }

    public Long getId() {
        return id;
    }

    public GenreDTO getGenre() {
        return genre;
    }

    public void setGenre(GenreDTO genre) {
        this.genre = genre;
    }

    public List<ReviewDTO> getReviews() {
        return reviews;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
