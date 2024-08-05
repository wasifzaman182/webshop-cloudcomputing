package org.example.RequestAndResponse;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class InventoryRequest {

    private Integer id;
    private Integer productId;
    private Integer supplierId;
    private Integer stockLevel;
}
