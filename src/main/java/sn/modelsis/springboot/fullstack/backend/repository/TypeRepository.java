package sn.modelsis.springboot.fullstack.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import sn.modelsis.springboot.fullstack.backend.model.Type;
@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
	Type findByName(String name);
	Optional<Type> findById(Integer id);

}
