package com.springBoot.cloud.clientes.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.cloud.clientes.app.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long>{

}
