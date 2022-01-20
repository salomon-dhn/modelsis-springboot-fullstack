package sn.modelsis.springboot.fullstack.backend.dto;


import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TypeGetDto {
	@JsonProperty("id")
	@ApiModelProperty(value = "The identifier's product", example = "2", required = true)
	@NotNull(message = "Identifiers product cannot be null")
	private int id;
	
	@JsonProperty("name")
	@ApiModelProperty(value = "The name of type", example = "Laptop", required = true)
	@NotNull(message = "Name of type cannot be null")
	private String name;

}
