package sn.modelsis.springboot.fullstack.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import sn.modelsis.springboot.fullstack.backend.dto.TypeGetDto;
import sn.modelsis.springboot.fullstack.backend.dto.TypePostDto;
import sn.modelsis.springboot.fullstack.backend.model.Type;

@Mapper (componentModel="spring")
public interface TypeMapper {

	TypeMapper INSTANCE = Mappers.getMapper(TypeMapper.class);
	
	TypeGetDto typeToTypeGetDto(Type type);
	
	@Mappings({
		@Mapping(target="id", ignore = true),
		@Mapping(target="products", ignore = true)
	})
	Type typePostDtoToType(TypePostDto dto);
}
