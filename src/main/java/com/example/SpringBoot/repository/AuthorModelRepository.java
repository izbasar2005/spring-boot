package com.example.SpringBoot.repository;

import com.example.SpringBoot.model.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorModelRepository extends JpaRepository<AuthorModel, Long> {

}
