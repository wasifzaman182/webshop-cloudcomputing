package org.example.repo;

import org.example.entity.ProductManagementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductManagementRepo extends JpaRepository<ProductManagementEntity,Integer> {
    List<ProductManagementEntity> findByCategory_CategoryID(int categoryId);
}
