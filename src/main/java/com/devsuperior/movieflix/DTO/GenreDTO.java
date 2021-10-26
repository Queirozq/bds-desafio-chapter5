package com.devsuperior.movieflix.DTO;

import com.devsuperior.movieflix.entities.Genre;

import java.io.Serializable;

public class GenreDTO implements Serializable {

    private Long id;
    private String name;

    public GenreDTO() {
    }

    public GenreDTO(Genre obj) {
        this.id = obj.getId();
        this.name = obj.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
