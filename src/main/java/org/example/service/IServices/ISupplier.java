package org.example.service.IServices;

import org.example.RequestAndResponse.SupplierRequest;
import org.example.entity.SupplierEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ISupplier {
    SupplierEntity createSupplier(SupplierRequest supplier);
    List<SupplierEntity> getAllSuppliers();
    Optional<SupplierEntity> getSupplierById(Integer supplierId);
    SupplierEntity updateSupplier(SupplierRequest supplier);
    void deleteSupplier(Integer supplierId);
}
