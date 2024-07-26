package org.example.entity;

import javax.persistence.*;
import java.util.Set;
//TODO: continue from entity
    @Entity
    public class Category {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer categoryID;

        @Column(nullable = false)
        private String categoryName;

        // Getters and setters
        public Integer getCategoryID() {
            return categoryID;
        }

        public void setCategoryID(Integer categoryID) {
            this.categoryID = categoryID;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }
    }

