package org.example.controller;

import org.example.RequestAndResponse.InventoryRequest;
import org.example.entity.InventoryEntity;
import org.example.service.IServices.IInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/inventory")
@CrossOrigin(origins = "http://localhost:3000")
public class InventoryController {

    @Autowired
    IInventory inventory;

    @PostMapping(value = "/saveInventory")
    public InventoryEntity save(@RequestBody InventoryRequest request){
        return inventory.saveInventory(request);
    }

    @GetMapping(value = "/getInventory")
    public InventoryEntity getInventory(@RequestParam("id") int id){
        return inventory.getInventory(id);
    }

    @GetMapping(value = "/getAllInventory")
    public List<InventoryEntity> getAllInventory(@RequestBody InventoryRequest request){
        List<InventoryEntity> list = inventory.getAllInventory(request);

        return list;
    }
}
