package es.kairosds.blogservice.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
public class Comentario implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String comentarista;
	
	private String contenido;
	
	private final LocalDate publicacion = LocalDate.now();
	

	@ManyToOne ( fetch = FetchType.LAZY,
	cascade = CascadeType.MERGE)
	@JoinColumn(name = "articulo_id", nullable = false)
	@JsonIgnore
	Articulo articulo;

}
