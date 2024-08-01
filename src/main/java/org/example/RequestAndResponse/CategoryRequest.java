package org.example.RequestAndResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties
@Setter
@Getter
public class CategoryRequest {
    private Integer id;
    private String categoryName;
}
