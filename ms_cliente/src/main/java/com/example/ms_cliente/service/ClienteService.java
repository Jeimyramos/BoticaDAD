package com.botica.mscliente.service;

import com.botica.mscliente.dto.ClienteDto;

import java.util.List;

public interface ClienteService {
    List<ClienteDto> obtenerTodos();
    ClienteDto obtenerPorId(Long id);
    ClienteDto crearCliente(ClienteDto clienteDto);
    ClienteDto actualizarCliente(Long id, ClienteDto clienteDto);
    void eliminarCliente(Long id);
}