package sn.modelsis.springboot.fullstack.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import sn.modelsis.springboot.fullstack.backend.exceptions.NoDataFoundException;
import sn.modelsis.springboot.fullstack.backend.exceptions.TypeNotFoundException;
import sn.modelsis.springboot.fullstack.backend.model.Type;
import sn.modelsis.springboot.fullstack.backend.repository.TypeRepository;


@Slf4j
@Service
public class TypeService  {
	private final TypeRepository typeRepository;

	public TypeService(TypeRepository typeRepository) {
		this.typeRepository = typeRepository;
	}

	public List<Type> findAll(){
		List<Type> Types = typeRepository.findAll();
		if(Types.isEmpty()) throw new NoDataFoundException();
		else return Types;
	}

	public Type findById(int id) {
		return typeRepository.findById(id).orElseThrow(()->new TypeNotFoundException(id));
	}
	
	public Type findByName(String name) {
		Type type = typeRepository.findByName(name);
		if (type != null) {
		return type;}
		throw new TypeNotFoundException("Type not found with value: ", name );
	}
	
	public Type save (Type Type) {
		log.info("Type ajouté : {}", Type);
		return typeRepository.save(Type);
	}

	public Type update(Type Type) {
		Type TypeUpdate = this.findById(Type.getId());
		if (TypeUpdate!=null) {
			TypeUpdate.setName(Type.getName());
			log.info("Type Mis à jour: {}", TypeUpdate);
			return this.save(TypeUpdate);
		}
		return null;
	}
	
	public boolean delete (Integer id) {
		if(this.findById(id)!=null) { typeRepository.deleteById(id);return true;}
		else return false;
	}

}
