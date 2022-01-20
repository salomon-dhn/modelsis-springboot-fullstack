package sn.modelsis.springboot.fullstack.backend.model;


import java.util.List;


import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


import lombok.Data;

@Data
@Entity
@Table(name="type")
public class Type {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(name = "id_type", unique = true, nullable = false)
	private int id;
	
	@Basic
    @Column(name = "name", unique = true, nullable = false, length = 250)
	@NotEmpty(message="Type cannot be empty")
	private String name;
	
	@OneToMany(mappedBy = "type",  cascade = CascadeType.ALL)
    private List<Product> products ;

}
