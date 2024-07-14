package org.example.entity;

import javax.persistence.*;
import java.util.Set;

    @Entity
    public class Category {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long categoryID;

        @Column(nullable = false)
        private String categoryName;

        // Getters and setters
        public Long getCategoryID() {
            return categoryID;
        }

        public void setCategoryID(Long categoryID) {
            this.categoryID = categoryID;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }
    }
    
