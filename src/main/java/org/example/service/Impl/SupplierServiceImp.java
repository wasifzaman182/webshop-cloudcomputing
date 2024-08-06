package org.example.service.Impl;

import org.example.RequestAndResponse.SupplierRequest;
import org.example.entity.SupplierEntity;
import org.example.repo.SupplierRepository;
import org.example.service.IServices.ISupplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImp implements ISupplier {
    private static final Logger logger = LoggerFactory.getLogger(SupplierServiceImp.class);


    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public SupplierEntity createSupplier(SupplierRequest supplier) {
         SupplierEntity entity = SupplierEntity.builder().contactPhone(supplier.getContactPhone()).supplierName(supplier.getSupplierName())
                 .contactEmail(supplier.getContactEmail()).build();
        supplierRepository.save(entity);
        return entity;
    }

    @Override
    public List<SupplierEntity> getAllSuppliers() {
        List<SupplierEntity> entities = supplierRepository.findAll();
        return entities;
    }

    @Override
    public Optional<SupplierEntity> getSupplierById(Integer supplierId) {
        return supplierRepository.findById(supplierId);
    }

    @Override
    public SupplierEntity updateSupplier(SupplierRequest supplier) {
        SupplierEntity supplierEntity = supplierRepository.findById(supplier.getSupplierId()).orElseThrow(() -> new RuntimeException("Supplier not found"));
        supplierEntity.setSupplierName(supplier.getSupplierName());
        supplierEntity.setContactEmail(supplier.getContactEmail());
        supplierEntity.setContactPhone(supplier.getContactPhone());
        return supplierRepository.save(supplierEntity);
    }

    @Override
    public void deleteSupplier(Integer supplierId) {
        SupplierEntity supplier = supplierRepository.findById(supplierId).orElseThrow(() -> new RuntimeException("Supplier not found"));
        supplierRepository.delete(supplier);
    }
}
