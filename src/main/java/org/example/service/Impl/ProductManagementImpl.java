package org.example.service.Impl;

import org.example.RequestAndResponse.ProductManagementRequest;
import org.example.entity.CategoryEntity;
import org.example.entity.ProductManagementEntity;
import org.example.repo.ProductManagementRepo;
import org.example.service.IServices.IProductManagement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductManagementImpl implements IProductManagement {

    private static final Logger logger = LoggerFactory.getLogger(ProductManagementImpl.class);

    @Autowired
    private ProductManagementRepo productManagementRepo;

    @Override
    public ProductManagementEntity saveProduct(ProductManagementRequest productManagement) {
        if (productManagement != null){
            CategoryEntity category = CategoryEntity.builder().categoryID(productManagement.getCategoryId()).build();

            ProductManagementEntity entity = ProductManagementEntity.builder().name(productManagement.getName())
                                  .price(productManagement.getPrice()).description(productManagement.getDescription())
                    .imageUrl(productManagement.getImageUrl()).category(category).build();

            productManagementRepo.save(entity);
            return entity;

        }
        return null;
    }

    @Override
    public ProductManagementEntity getProduct(Integer id) {
        if (id !=null){
            ProductManagementEntity entity = productManagementRepo.getById(id);
            return entity;
        }
        return null;
    }

    @Override
    public List<ProductManagementEntity> getAllProudct() {
        List<ProductManagementEntity> entities = productManagementRepo.findAll();
        return entities;
    }

    @Override
    public ProductManagementEntity updateProduct(ProductManagementRequest productManagementRequest) {
        Optional<ProductManagementEntity> e = productManagementRepo.findById(productManagementRequest.getProductId());

        if (e != null){
            CategoryEntity category = CategoryEntity.builder().categoryID(productManagementRequest.getCategoryId()).build();

            ProductManagementEntity entity = ProductManagementEntity.builder().name(productManagementRequest.getName())
                    .price(productManagementRequest.getPrice()).description(productManagementRequest.getDescription())
                    .imageUrl(productManagementRequest.getImageUrl()).category(category).productId(productManagementRequest.getProductId()).build();

            productManagementRepo.save(entity);
        }
        return null;
    }

    @Override
    public void deleteProduct(Integer id) {
        if (id !=null){
            productManagementRepo.deleteById(id);
        }
    }

    @Override
    public List<ProductManagementEntity> getProductsByCategoryId(int categoryId) {
        return productManagementRepo.findByCategory_CategoryID(categoryId);
    }


}
