package sn.modelsis.springboot.fullstack.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.modelsis.springboot.fullstack.backend.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	Product findByName(String name);
	Optional<Product> findById(Integer id);
}
