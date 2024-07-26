package org.example.repo;

import org.example.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
    @Override
    <S extends Category> S save(S s);
}
