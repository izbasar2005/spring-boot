package com.example.SpringBoot.repository;

import com.example.SpringBoot.model.GenreModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreModelRepository extends JpaRepository<GenreModel, Long> {

}
