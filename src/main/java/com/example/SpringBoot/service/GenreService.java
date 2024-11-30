package com.example.SpringBoot.service;

import com.example.SpringBoot.model.GenreModel;
import com.example.SpringBoot.repository.GenreModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreModelRepository genreModelRepository;

    public List<GenreModel> getGenres() {
        return genreModelRepository.findAll();
    }

    public GenreModel getGenre(Long id) {
        return genreModelRepository.findById(id).orElse(null);
    }


}
