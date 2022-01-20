package sn.modelsis.springboot.fullstack.backend.web;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;
import sn.modelsis.springboot.fullstack.backend.dto.ProductGetDto;
import sn.modelsis.springboot.fullstack.backend.dto.ProductPostDto;
import sn.modelsis.springboot.fullstack.backend.dto.ProductPutDto;
import sn.modelsis.springboot.fullstack.backend.dto.TypeGetDto;
import sn.modelsis.springboot.fullstack.backend.dto.TypePostDto;
import sn.modelsis.springboot.fullstack.backend.mapper.ProductMapper;
import sn.modelsis.springboot.fullstack.backend.mapper.TypeMapper;
import sn.modelsis.springboot.fullstack.backend.service.ProductService;
import sn.modelsis.springboot.fullstack.backend.service.TypeService;

import static java.util.stream.Collectors.toList;

@RestController
//@RequestMapping("/auth")
public class Controller {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private TypeService typeService;

	public final ProductMapper mapperProduct =  ProductMapper.INSTANCE;
	public final TypeMapper mapperType =  TypeMapper.INSTANCE;
	
	
	@GetMapping("/")
	public String base ( ) {
		return "Bienvenue à l'API de la base de données Modelsis!";	
	}
	
	@ApiOperation(value="Retourne tous les produits")
	@GetMapping(value = "/products")
	private List<ProductGetDto> getProducts(){
		return productService.findAll().stream().map(mapperProduct::toProductGetDto).collect(toList());
	}
	
	@ApiOperation(value="Retourne tous les types de produit")
	@GetMapping(value = "/productsType")
	private List<TypeGetDto> getTypes(){
		return typeService.findAll().stream().map(mapperType::typeToTypeGetDto).collect(toList());
	}

	@ApiOperation(value="Retourne un produit par son id")
	@GetMapping(value="/products/{id}")
	private ProductGetDto getProductById(@PathVariable int id) {
		return mapperProduct.toProductGetDto(productService.findById(id));
	}

	@ApiOperation(value="Enregistre un nouveau produit")
	@PostMapping(value="/products")
	private ResponseEntity<ProductPostDto> newProduct(@Valid @RequestBody ProductPostDto newProduct) {
		newProduct.setType(String.valueOf(typeService.findByName(newProduct.getType()).getId()));
		ProductGetDto product = mapperProduct.toProductGetDto(productService.save(mapperProduct.fromProductDto(newProduct)));
		if(product==null) return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/")
				.buildAndExpand(newProduct)
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@ApiOperation(value="Enregistre un nouveau type")
	@PostMapping(value="/productsType")
	private ResponseEntity<TypePostDto> newType(@Valid @RequestBody TypePostDto newType) {
		TypeGetDto product = mapperType.typeToTypeGetDto(typeService.save(mapperType.typePostDtoToType(newType)));
		if(product==null) return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/")
				.buildAndExpand(newType)
				.toUri();
		return ResponseEntity.created(location).build();
	}


	@ApiOperation(value="Met Ã  jour un produit")
	@PutMapping(path = "/products")
	private ResponseEntity<ProductGetDto> updateProduct(@Valid @RequestBody ProductPutDto productUpdate) {
		if((productService.update(mapperProduct.updateFromProductDto(productUpdate)) != null)) {
			return ResponseEntity.status(HttpStatus.RESET_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build() ;
	}
 
	@ApiOperation(value="Supprime un produit par un id")
	@DeleteMapping(path = "/products/{id}")
	private ResponseEntity<ProductGetDto> deleteEmployee(@PathVariable("id") int productId) {
		if(!productService.delete(productId))return ResponseEntity.notFound().build(); 
		else return ResponseEntity.noContent().build();
	}
}
