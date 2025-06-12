package com.example.ms_cliente.service.impl;

import com.example.ms_cliente.dto.ClienteDto;
import com.example.ms_cliente.entity.Cliente;
import com.example.ms_cliente.repository.ClienteRepository;
import com.example.ms_cliente.service.ClienteService;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repo;
    private final ModelMapper mapper;

    public ClienteServiceImpl(ClienteRepository repo, ModelMapper  mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public ResponseDto<ClienteDto> create(ClienteDto dto) {
        Cliente ent = mapper.map(dto, Cliente.class);
        Cliente saved = repo.save(ent);
        return new ResponseDto<>(mapper.map(saved, ClienteDto.class), "Cliente creado");
    }

    @Override
    public ResponseDto<ClienteDto> getById(Long id) {
        Cliente ent = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        return new ResponseDto<>(mapper.map(ent, ClienteDto.class), "Cliente encontrado");
    }
}