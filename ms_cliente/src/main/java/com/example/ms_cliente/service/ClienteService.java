package com.example.ms_cliente.service;

import com.example.ms_cliente.dto.ClienteDto;
import com.example.ms_cliente.dto.DniResponse;
import com.example.ms_cliente.dto.RucResponse;
import com.example.ms_cliente.dto.ResponseDto;

public interface ClienteService {
    ResponseDto<ClienteDto> create(ClienteDto dto);
    ResponseDto<ClienteDto> getById(Long id);
    // ya no hay fetch automático: se reciben datos por teclado
}