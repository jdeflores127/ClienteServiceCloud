package com.springBoot.cloud.clientes.app.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="tbl_cliente")
@Table
@Data @NoArgsConstructor @AllArgsConstructor @Builder(toBuilder = true)
@ToString
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	private Long idCliente;
	@Size(min = 1,max = 20, message = "el nombre debe contener entre 1 y 20 caracteres")
	private String nombre;
	private String apellidos;
	@Temporal(TemporalType.TIMESTAMP)
	@Past(message = "no se puede tener una fecha de registro mayor a la fecha de hoy")
	private Date fechaRegistro;
	@Transient
	private List<Producto> listaProductos;
	
}
