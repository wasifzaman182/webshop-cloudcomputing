package org.example.RequestAndResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class CategoryRequest {
    private String categoryName;
    private Integer id;
}
