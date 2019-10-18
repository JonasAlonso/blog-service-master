package es.kairosds.blogservice.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Comentario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8126224675389688601L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String comentarista;
	
	private String contenido;
	
	private final LocalDateTime publicacion = LocalDateTime.now();
	

	@ManyToOne ( fetch = FetchType.LAZY,
	cascade = CascadeType.MERGE)
	@JoinColumn(name = "articulo_id", nullable = false)
	@JsonIgnore
	Articulo articulo;

}
