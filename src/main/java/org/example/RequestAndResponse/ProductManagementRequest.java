package org.example.RequestAndResponse;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entity.CategoryEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductManagementRequest {

    private Integer productId;
    private Integer categoryId;
    private String name;
    private String description;
    private BigDecimal price;
    private String imageUrl;
}
