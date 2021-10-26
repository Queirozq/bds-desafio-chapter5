package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.DTO.ReviewDTO;
import com.devsuperior.movieflix.DTO.ReviewInsertDTO;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private AuthService authService;


    @Transactional
    public ReviewInsertDTO insert(ReviewInsertDTO obj){
       Review review = new Review();
       fromDTO(review, obj);
       review = repository.save(review);
       return new ReviewInsertDTO(review);
    }

    private void fromDTO(Review review, ReviewInsertDTO obj) {
        review.setText(obj.getText());
        review.setUser(authService.authenticated());
        review.setMovie(movieRepository.getOne(obj.getMovieId()));
    }
}
