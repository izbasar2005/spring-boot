package com.example.SpringBoot.service;

import com.example.SpringBoot.model.AuthorModel;
import com.example.SpringBoot.repository.AuthorModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorModelRepository authorModelRepository;

    public List<AuthorModel> getAuthors() {
        return authorModelRepository.findAll();
    }
}
