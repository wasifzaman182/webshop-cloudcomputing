package org.example.RequestAndResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class CategoryRequest {
    @NotNull
    private String categoryName;
}
