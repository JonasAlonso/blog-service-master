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
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comentario implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long comentarioId;
	
	private String comentarista;
	
	private String contenido;
	
	private final LocalDate publicacion = LocalDate.now();
	
	@JsonIgnore
	@ManyToOne ( fetch = FetchType.LAZY,
	cascade = CascadeType.ALL)
	@JoinColumn(name = "postId", nullable = false)
	private Post post;

}
