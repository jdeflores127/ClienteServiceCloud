package com.springBoot.cloud.clientes.app.services;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springBoot.cloud.clientes.app.entities.Cliente;
import com.springBoot.cloud.clientes.app.entities.Producto;
import com.springBoot.cloud.clientes.app.repositories.ClienteRepository;

@Service
public class ClienteServices {
	@Autowired 
	private ClienteRepository ClienteRepository;
	
	@Autowired
	private RestTemplate obtenerProductosService;
	
	public List<Cliente> obtenerListaClientes(){
		List<Cliente> listaClientes = ClienteRepository.findAll();
		return listaClientes;
	}
	
	public Cliente obtenerCliente(Long idCliente) throws Exception {
		Optional<Cliente> clienteDB = ClienteRepository.findById(idCliente);
		if(clienteDB.isPresent()) {
			//Se obtienen los productos del cliente desde un origen remoto
			List<Producto> listaProductos=Arrays.asList(obtenerProductosService.getForObject("http://producto-service/productosServices/productos", Producto[].class));
			clienteDB.get().setListaProductos(listaProductos);
			System.out.println("El cliente con sus objetos son: "+clienteDB.get().toString());
			return clienteDB.get();
		}
		else
			throw new Exception("Persona no encontrada en base de datos"); 
	}
	
	public void registrarCliente(Cliente Cliente) {
		try {
			Cliente = Cliente.toBuilder()
			.idCliente(0L)
			.fechaRegistro(new Date())
			.build();
			
			ClienteRepository.save(Cliente);
		}catch(IllegalArgumentException e) {
			throw new RuntimeException("la entidad no puede ser nula");
		}catch(Exception e) {
			throw new RuntimeException("Error desconocido al insertar el registro: "+e.getMessage());
		}
	}
}
