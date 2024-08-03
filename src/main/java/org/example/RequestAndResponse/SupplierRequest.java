package org.example.RequestAndResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierRequest {

    private Integer supplierId;
    private String supplierName;
    private String contactEmail;
    private String contactPhone;
}
