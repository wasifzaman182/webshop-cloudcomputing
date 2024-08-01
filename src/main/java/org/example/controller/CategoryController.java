package org.example.controller;

import org.example.RequestAndResponse.CategoryRequest;
import org.example.entity.CategoryEntity;
import org.example.service.ICategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="category")
public class CategoryController {

    @Autowired
    ICategory category;
    @PostMapping(value = "/save")
    public CategoryEntity saveCategory(@RequestBody CategoryRequest request){
        System.out.println(request.getCategoryName());
        return category.save(request);

    }

}
