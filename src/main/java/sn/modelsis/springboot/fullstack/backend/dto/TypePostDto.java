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
public class TypePostDto {
	
	@JsonProperty("type")
	@ApiModelProperty(value = "The name of type", example = "Smartphone", required = true)
	@NotNull(message = "Name of type cannot be null")
	private String name;
}
