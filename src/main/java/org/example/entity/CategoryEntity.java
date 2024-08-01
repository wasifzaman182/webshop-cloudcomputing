package org.example.entity;

import lombok.*;

import javax.persistence.*;
    @Entity
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Table(name = "category")
    public class CategoryEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer categoryID;

        @Column(nullable = false)
        private String categoryName;


    }

