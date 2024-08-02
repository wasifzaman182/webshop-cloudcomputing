package org.example.repo;

import org.example.entity.ProductManagementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductManagementRepo extends JpaRepository<ProductManagementEntity,Integer> {
}
