package org.example.controller;

import org.example.RequestAndResponse.ProductManagementRequest;
import org.example.entity.ProductManagementEntity;
import org.example.service.IProductManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductManagementController {

    @Autowired
    IProductManagement productManagement;

    @PostMapping(value = "/saveProduct")
    public ProductManagementEntity saveProduct(@RequestBody ProductManagementRequest request){
       ProductManagementEntity entity = productManagement.saveProduct(request);
        return entity;

    }

    //getting wrong response
    @GetMapping(value = "/getProduct")
    public ProductManagementEntity getProduct(@RequestBody ProductManagementRequest request){
        int id = request.getProductId();
        ProductManagementEntity entity = productManagement.getProduct(id);

        return entity;
    }

    //same issue as getProduct
    @GetMapping(value = "/getAll")
    public List<ProductManagementEntity> getAllProduct(){
        List<ProductManagementEntity> entities = productManagement.getAllProudct();
        return entities;
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(ProductManagementRequest request){
        productManagement.deleteProduct(request.getProductId());
    }

    @PostMapping(value = "/updateProduct")
    public ProductManagementEntity updateProduct(ProductManagementRequest request){
        ProductManagementEntity entity = productManagement.updateProduct(request);

        return entity;
    }
}
