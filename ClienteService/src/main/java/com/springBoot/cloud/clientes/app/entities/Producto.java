package com.springBoot.cloud.clientes.app.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//definiciones JPA
//Definiciones de lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@ToString
public class Producto {

	private Long idProducto;

	@NotEmpty(message = "Nombre no puede ir vacio")
	private String nombre;

	@Positive(message = "el precio no puede ser menor a 0")
	private double precio;

	@Size(min = 1, max = 200, message = "la descripción debe contener entre 1 y 200 caracteres")
	private String descripcion;

	@Positive(message = "las existencias deben ser igual o mayores a 0")
	private int existencias;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecharegistro;

	// Atributo que indica en que puerto del balanceo de carga se procesó
	@Transient
	private int puerto_balanceo;

}
