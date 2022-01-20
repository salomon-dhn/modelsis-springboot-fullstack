package sn.modelsis.springboot.fullstack.backend.dto;

import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductGetDto {
	@JsonProperty("id")
	@ApiModelProperty(value = "The identifier's product", example = "256")
    private int id;
	
    @JsonProperty("name")
    @ApiModelProperty(value = "The product's name", example = "Apple", name = "Name", required = true)
	@NotEmpty(message = "Product's name cannot be empty")
    private String name;
    
    @JsonProperty("createdDate")
    @ApiModelProperty(value = "Date of creation", example = "10/10/2010", name = "Date", required = false)
    private LocalDate createdDate;
    
    @JsonProperty("type")
    @ApiModelProperty(value = "The name's type of product", example = "Smartphone", name = "Type", required = true)
	@NotEmpty(message = "Product's type cannot be empty")
    private String type;
}
