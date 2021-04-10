package com.springBoot.cloud.clientes.app.restEndpoints;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.springBoot.cloud.clientes.app.entities.Cliente;
import com.springBoot.cloud.clientes.app.services.ClienteServices;
import com.springBoot.cloud.clientes.app.utils.Utilidades;

@RestController
@RequestMapping("/ClientesServices")
public class ClienteRestController {
	
	@Autowired 
	private ClienteServices ClienteServices;
	
	@GetMapping("/Clientes")
	public List<Cliente> obtenerListaPersonas(){
		return ClienteServices.obtenerListaClientes();	
	}
	
	@GetMapping("/Clientes/{idCliente}")
	public Cliente obtenerPersona(@PathVariable("idCliente") Long idPersona) throws Exception {
		return ClienteServices.obtenerCliente(idPersona);
	}
	
	@PostMapping("/Clientes")
	public String registraCliente(@Valid @RequestBody Cliente Cliente, BindingResult result){
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Utilidades.getFormatoErrorBindingResult(result)); 
		}
		ClienteServices.registrarCliente(Cliente);
		return "Cliente registrado con exito";
	}
}
