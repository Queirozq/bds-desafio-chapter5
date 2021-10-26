package com.devsuperior.movieflix.resources;

import com.devsuperior.movieflix.DTO.MovieDTO;
import com.devsuperior.movieflix.DTO.MovieDTOWithoutReview;
import com.devsuperior.movieflix.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {

    @Autowired
    private MovieService service;


    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable Long id){
        MovieDTO obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<Page<MovieDTOWithoutReview>> findAllByGenre(@RequestParam(value = "genreId", defaultValue = "0")Long genreId,
                                                         Pageable pageable){
        Page<MovieDTOWithoutReview> movies = service.findAllByGenre(genreId, pageable);
        return ResponseEntity.ok().body(movies);
    }
}
