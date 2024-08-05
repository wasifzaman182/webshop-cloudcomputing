package org.example.service.IServices;

import org.example.RequestAndResponse.ProductManagementRequest;
import org.example.entity.ProductManagementEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductManagement {


    ProductManagementEntity saveProduct(ProductManagementRequest productManagement);
    ProductManagementEntity getProduct(Integer id);
    List<ProductManagementEntity> getAllProudct();
    ProductManagementEntity updateProduct(ProductManagementRequest productManagementRequest);
    void deleteProduct(Integer id);


}
