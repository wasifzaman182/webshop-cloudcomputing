package org.example.RequestAndResponse;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class OrderItemRequest {

    private Integer id;
    private Integer orderId;
    private Integer productId;
    private Integer quantity;
    private String price;
}
