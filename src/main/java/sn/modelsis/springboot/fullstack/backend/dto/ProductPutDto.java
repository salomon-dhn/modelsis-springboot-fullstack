package sn.modelsis.springboot.fullstack.backend.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProductPutDto {
	@JsonProperty("id")
	@ApiModelProperty(value = "The identifier's product", example = "256", required = true)
	@NotNull(message = "Identifiers product cannot be null")
    private int id;
	
	@NotEmpty
    @JsonProperty("name")
	@ApiModelProperty(value = "The product's name", example = "Apple", name = "Name", required = true)
    private String name;
    
	@NotEmpty
    @JsonProperty("type")
	@ApiModelProperty(value = "The type of product", example = "Smartphone", name = "Type", required = true)
	@NotEmpty(message = "Product's type cannot be empty")
    private int type;

}
