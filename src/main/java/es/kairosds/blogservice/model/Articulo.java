package es.kairosds.blogservice.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Articulo implements Serializable{
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
		
	private String autor;
	
	private String contenido;
	
	@OneToMany(cascade = CascadeType.MERGE,
			fetch = FetchType.LAZY,
			mappedBy = "articulo")
	private List<Comentario> comentarios;

}
