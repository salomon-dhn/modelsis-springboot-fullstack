package sn.modelsis.springboot.fullstack.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import sn.modelsis.springboot.fullstack.backend.dto.ProductGetDto;
import sn.modelsis.springboot.fullstack.backend.dto.ProductPostDto;
import sn.modelsis.springboot.fullstack.backend.dto.ProductPutDto;
import sn.modelsis.springboot.fullstack.backend.model.Product;

@Mapper (componentModel="spring")
public interface ProductMapper {

	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	
	@Mapping(target="createdDate", dateFormat ="dd/MM/yyyy")
	@Mapping(target="type", source="type.name")
	ProductGetDto toProductGetDto(Product product);
	
	@Mapping(target="createdDate", ignore=true)
	@Mapping(target="id", ignore=true)
	@Mapping(target="type.id", source="productPostDto.type")
	Product fromProductDto(ProductPostDto productPostDto);
	
	@Mapping(target="createdDate", ignore=true)
	@Mapping(target="type.id", source="productPutDto.type")
	Product updateFromProductDto(ProductPutDto productPutDto);
}
