package org.example.service.IServices;

import org.example.RequestAndResponse.InventoryRequest;
import org.example.entity.InventoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IInventory {

    InventoryEntity saveInventory(InventoryRequest request);
    InventoryEntity getInventory(Integer id);
    List<InventoryEntity> getAllInventory(InventoryRequest request);

}
