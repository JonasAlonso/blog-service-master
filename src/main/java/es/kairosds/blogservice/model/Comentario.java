package es.kairosds.blogservice.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Long comentarioId;
	
	private String comentarista;
	
	private String contenido;
	
	private LocalDate publicacion;

}
