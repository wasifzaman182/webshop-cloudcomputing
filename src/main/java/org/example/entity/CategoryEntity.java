package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

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

        @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private Set<ProductEntity> products;

    }

