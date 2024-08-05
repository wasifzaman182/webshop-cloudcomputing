package org.example.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@Builder
@Entity
@Table(name = "order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    private CustomerEntity customer;

    @Column(name = "order_date", nullable = false)
    private Timestamp orderDate;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "total_amount", precision = 10, scale = 2)
    private BigDecimal totalAmount;

    //@ManyToOne
    //@JoinColumn(name = "payment_method_id", referencedColumnName = "PaymentMethodID")
    //private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "shipping_address_id", referencedColumnName = "AddressID")
    private AddressEntity shippingAddress;

    @ManyToOne
    @JoinColumn(name = "billing_address_id", referencedColumnName = "AddressID")
    private AddressEntity billingAddress;
}
