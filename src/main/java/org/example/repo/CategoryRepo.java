package org.example.repo;

import org.example.entity.CategoryEntity;
import org.example.entity.ProductManagementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity,Integer> {


}
