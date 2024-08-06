package org.example.controller;

import org.example.RequestAndResponse.SupplierRequest;
import org.example.entity.SupplierEntity;
import org.example.service.IServices.ISupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private ISupplier supplierService;

    @GetMapping("/getAllSuppliers")
    public List<SupplierEntity> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/getSupplier")
    public ResponseEntity<SupplierEntity> getSupplierById(@RequestBody SupplierRequest request) {
        Optional<SupplierEntity> supplier = supplierService.getSupplierById(request.getSupplierId());
        if (supplier.isPresent()) {
            return ResponseEntity.ok(supplier.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/saveSupplier")
    public SupplierEntity createSupplier(@RequestBody SupplierRequest supplier) {
        return supplierService.createSupplier(supplier);
    }

    @PutMapping("/updateSupplier")
    public ResponseEntity<SupplierEntity> updateSupplier(@RequestBody SupplierRequest request) {
        return ResponseEntity.ok(supplierService.updateSupplier(request));
    }

    @DeleteMapping("/deleteSupplier")
    public ResponseEntity<Void> deleteSupplier(@RequestBody SupplierRequest request) {
        supplierService.deleteSupplier(request.getSupplierId());
        return ResponseEntity.noContent().build();
    }
}
