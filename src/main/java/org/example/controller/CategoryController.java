package org.example.controller;

import org.example.RequestAndResponse.CategoryRequest;
import org.example.entity.CategoryEntity;
import org.example.service.ICategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name="category")
public class CategoryController {

    @Autowired
    ICategory category;
    @PostMapping(name = "/save")
    public CategoryEntity saveCategory(CategoryRequest request){
        return category.save(request);

    }

}
