package org.example.RequestAndResponse;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Builder
@Getter
@Setter
public class OrderRequest {

    private Integer id;
    private Integer customerId;
    private String orderDate;
    private String status;
    private String totalAmount;
    private Integer shippingAddressId;
    private Integer billingAddressId;
}
