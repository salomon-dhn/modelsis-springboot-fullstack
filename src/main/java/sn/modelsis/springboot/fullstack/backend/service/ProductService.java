package sn.modelsis.springboot.fullstack.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import sn.modelsis.springboot.fullstack.backend.exceptions.NoDataFoundException;
import sn.modelsis.springboot.fullstack.backend.exceptions.ProductNotFoundException;
import sn.modelsis.springboot.fullstack.backend.model.Product;
import sn.modelsis.springboot.fullstack.backend.repository.ProductRepository;

@Slf4j
@Service
public class ProductService {

	
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> findAll(){
		List<Product> products = productRepository.findAll();
		if(products.isEmpty()) throw new NoDataFoundException();
		else return products;
	}

	public Product findById(int id) {
		return productRepository.findById(id).orElseThrow(()->new ProductNotFoundException(id));
	}
	public Product save (Product product) {
		log.info("Produit ajouté : {}", product);
		return productRepository.save(product);
	}

	public Product update(Product product) {
		Product productUpdate = this.findById(product.getId());
		if (productUpdate!=null) {
			productUpdate.setName(product.getName());
			productUpdate.setType(product.getType());
			log.info("Produit Mis à jour: {}", productUpdate);
			return this.save(productUpdate);
		}
		return null;
	}
	
	public boolean delete (Integer id) {
		if(this.findById(id)!=null) { productRepository.deleteById(id);return true;}
		else return false;
	}
}
