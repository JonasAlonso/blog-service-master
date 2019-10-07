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
public class Autor {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Long autorId;
	
	private String nombre;
	
	private LocalDate nacimiento;

}
