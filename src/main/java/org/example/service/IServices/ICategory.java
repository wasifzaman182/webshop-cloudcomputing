package org.example.service.IServices;

import org.example.RequestAndResponse.CategoryRequest;
import org.example.entity.CategoryEntity;
import org.springframework.stereotype.Service;

import java.net.CacheRequest;
import java.util.List;

@Service
public interface ICategory {

    CategoryEntity save(CategoryRequest request);
    CategoryEntity update(CategoryRequest request);
    void deleteCategory(CategoryRequest request);
    List<CategoryEntity> findAllCategory();
}
