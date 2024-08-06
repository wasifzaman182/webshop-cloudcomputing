package org.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "`order`")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    @JsonBackReference
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
    @JsonBackReference
    private AddressEntity shippingAddress;

    @ManyToOne
    @JoinColumn(name = "billing_address_id", referencedColumnName = "AddressID")
    @JsonBackReference
    private AddressEntity billingAddress;
}
