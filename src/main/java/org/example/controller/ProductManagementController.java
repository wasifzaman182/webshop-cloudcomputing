package org.example.controller;

import org.example.RequestAndResponse.ProductManagementRequest;
import org.example.entity.ProductManagementEntity;
import org.example.service.IServices.IProductManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
@CrossOrigin(origins = "http://localhost:3000")
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
    public ProductManagementEntity getProduct(@RequestParam("id") int productId){
        ProductManagementEntity entity = productManagement.getProduct(productId);

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

    @PutMapping(value = "/updateProduct")
    public ProductManagementEntity updateProduct(ProductManagementRequest request){
        ProductManagementEntity entity = productManagement.updateProduct(request);

        return entity;
    }

    @GetMapping(value = "/getProductsByCategory")
    public List<ProductManagementEntity> getProductsByCategory(@RequestParam("id") int categoryId) {
        return productManagement.getProductsByCategoryId(categoryId);
    }
}
