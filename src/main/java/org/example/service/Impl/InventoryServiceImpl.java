package org.example.service.Impl;

import org.example.RequestAndResponse.InventoryRequest;
import org.example.entity.InventoryEntity;
import org.example.entity.ProductManagementEntity;
import org.example.entity.SupplierEntity;
import org.example.repo.InventoryRepository;
import org.example.service.IServices.IInventory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements IInventory {

    private static final Logger logger = LoggerFactory.getLogger(InventoryServiceImpl.class);

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public InventoryEntity saveInventory(InventoryRequest request) {
        SupplierEntity supplier = SupplierEntity.builder().supplierId(request.getSupplierId()).build();
        ProductManagementEntity managementEntity = ProductManagementEntity.builder().productId(request.getProductId()).build();

        InventoryEntity inventory = InventoryEntity.builder().product(managementEntity).stockLevel(request.getStockLevel()).supplier(supplier).build();

        return inventoryRepository.save(inventory);
    }

    @Override
    public InventoryEntity getInventory(Integer id) {
        InventoryEntity inventory = inventoryRepository.getById(id);

        return inventory;
    }

    @Override
    public List<InventoryEntity> getAllInventory(InventoryRequest request) {
       List<InventoryEntity> list = inventoryRepository.findAll();

        return list;
    }
}
