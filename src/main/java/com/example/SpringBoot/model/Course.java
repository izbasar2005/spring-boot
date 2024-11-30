package com.example.SpringBoot.model;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Entity
@Table(name = "t_course")
@Getter
@Service
public class Course extends BaseModel{

    @Column(name = "name")
    private String name;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    @Column(name = "price")
    private int price;
}
