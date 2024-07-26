package org.example.service;

import org.example.entity.Category;
import org.example.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImp implements ICategory{

    CategoryRepo categoryRepo;

    @Override
    public void save(Category c) {
        categoryRepo.save(c);
    }
}
