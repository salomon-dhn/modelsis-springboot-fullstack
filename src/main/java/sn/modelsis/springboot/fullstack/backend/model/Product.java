package sn.modelsis.springboot.fullstack.backend.model;

import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(name = "id", unique = true, nullable = false)
	private int id;

	@Basic
    @Column(name = "name", unique = true, nullable = false, length = 250)
	@NotEmpty(message="Name cannot be empty")
    private String name;
	
	@Basic
    @Column(name = "createdDate", nullable = false)
    private LocalDate createdDate;
	
	
	@NotNull(message="Type cannot be empty")
	@ManyToOne
	@JoinColumn(name="id_type", nullable = false)
    private Type type;
	
	public Product() {
		LocalDate date = LocalDate.now();
		this.createdDate = date;
	}
	
	
	
}
