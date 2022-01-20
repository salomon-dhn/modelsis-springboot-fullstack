package sn.modelsis.springboot.fullstack.backend.dto;

import javax.validation.constraints.NotEmpty;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductPostDto {

    @JsonProperty("name")
	@ApiModelProperty(value = "The product's name", example = "Apple", name = "Name", required = true)
	@NotEmpty(message = "Product's name cannot be empty")
    private String name;
    
	
    @JsonProperty("type")
	@ApiModelProperty(value = "The type of product", example = "Smartphone", name = "Type", required = true)
	@NotEmpty(message = "Product's type cannot be empty")
    private String type;
}
