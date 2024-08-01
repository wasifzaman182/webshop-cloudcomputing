package org.example.service;

import org.example.RequestAndResponse.CategoryRequest;
import org.example.entity.CategoryEntity;
import org.springframework.stereotype.Service;

import java.net.CacheRequest;

@Service
public interface ICategory {

    CategoryEntity save(CategoryRequest request);
}
