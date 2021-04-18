package com.springBoot.cloud.clientes.app.ExternalApiRest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springBoot.cloud.clientes.app.entities.Producto;

@LoadBalancerClient(name = "producto-service", value = "producto-service")
@FeignClient("producto-service")
public interface ProductosExternalRest {
	
	@GetMapping("/productos")
	public List<Producto> obtenerListaProductos();
	
	@GetMapping("/productos/{idProducto}")
	public Producto obtenerPersona(@PathVariable("idProducto") Long idPersona);
	
}
