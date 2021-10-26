package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.DTO.MovieDTO;
import com.devsuperior.movieflix.DTO.MovieDTOWithoutReview;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;


    @Transactional(readOnly = true)
    public MovieDTO findById(Long id){
        Optional<Movie> obj = repository.findById(id);
        Movie movie = obj.orElseThrow(() -> new ResourceNotFoundException("Id não existe"));
        return new MovieDTO(movie, movie.getReviews());
    }

    @Transactional(readOnly = true)
    public Page<MovieDTOWithoutReview> findAllByGenre(Long genreId, Pageable pageable){
        Page<Movie> movies = repository.findAllByGenreOrderByTitleDesc(genreId, pageable);
        return movies.map(x -> new MovieDTOWithoutReview(x));
    }
}
