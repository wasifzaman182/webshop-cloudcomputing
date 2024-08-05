package org.example.service.Impl;

import org.example.RequestAndResponse.CategoryRequest;
import org.example.entity.CategoryEntity;
import org.example.repo.CategoryRepo;
import org.example.service.IServices.ICategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements ICategory {

    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public CategoryEntity save(CategoryRequest request) {
        CategoryEntity c = CategoryEntity.builder().categoryName(request.getCategoryName()).build();
        categoryRepo.save(c);

        return c;
    }

    @Override
    public CategoryEntity update(CategoryRequest request) {
       Optional<CategoryEntity> c = categoryRepo.findById(request.getId());

        if (c == null){

            return null;
        }
         CategoryEntity updateCategory = CategoryEntity.builder().categoryName(request.getCategoryName()).categoryID(request.getId()).build();
        categoryRepo.save(updateCategory);
        return updateCategory;
    }

    @Override
    public void deleteCategory(CategoryRequest request) {
        categoryRepo.deleteById(request.getId());
    }

    @Override
    public List<CategoryEntity> findAllCategory() {
        List<CategoryEntity> allCategory = categoryRepo.findAll();
        return allCategory;
    }
}
