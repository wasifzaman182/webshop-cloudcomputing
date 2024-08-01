package org.example.service;

import org.example.RequestAndResponse.CategoryRequest;
import org.example.entity.CategoryEntity;
import org.example.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImp implements ICategory{

    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public CategoryEntity save(CategoryRequest request) {
        CategoryEntity c = CategoryEntity.builder().categoryName(request.getCategoryName()).categoryID(request.getId()).build();
        categoryRepo.save(c);

        return c;
    }
}
