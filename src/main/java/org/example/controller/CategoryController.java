package org.example.controller;

import org.example.RequestAndResponse.CategoryRequest;
import org.example.entity.CategoryEntity;
import org.example.service.ICategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="category")
public class CategoryController {

    @Autowired
    ICategory category;
    @PostMapping(value = "/save")
    public CategoryEntity saveCategory(@RequestBody CategoryRequest request){
        //System.out.println(request.getCategoryName());
        return category.save(request);

    }

    @PostMapping(value = "/update")
    public CategoryEntity updateCategory(@RequestBody CategoryRequest request){
        return  category.update(request);
    }

    @DeleteMapping(value = "/delete")
    public void deleteCategory(@RequestBody CategoryRequest request){
        category.deleteCategory(request);
    }

    @GetMapping(value = "/findAll")
    public List<CategoryEntity> findAllCategory(){
        List<CategoryEntity> response = category.findAllCategory();
        return response;
    }
}
