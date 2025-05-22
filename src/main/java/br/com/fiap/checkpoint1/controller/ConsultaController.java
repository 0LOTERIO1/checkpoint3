package br.com.fiap.checkpoint1.controller;

import br.com.fiap.checkpoint1.dto.ConsultaDTO;
import br.com.fiap.checkpoint1.model.Consulta;
import br.com.fiap.checkpoint1.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @PostMapping
    public ResponseEntity<ConsultaDTO> create(@RequestBody ConsultaDTO dto) {
        Consulta c = dtoToEntity(dto);
        return ResponseEntity.status(201).body(entityToDto(service.create(c)));
    }

    @GetMapping
    public ResponseEntity<List<ConsultaDTO>> findAll() {
        return ResponseEntity.ok(service.findAll().stream().map(this::entityToDto).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDTO> findById(@PathVariable Long id) {
        Consulta c = service.findById(id);
        return c != null ? ResponseEntity.ok(entityToDto(c)) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaDTO> update(@PathVariable Long id, @RequestBody ConsultaDTO dto) {
        Consulta c = service.update(id, dtoToEntity(dto));
        return c != null ? ResponseEntity.ok(entityToDto(c)) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    private Consulta dtoToEntity(ConsultaDTO dto) {
        Consulta c = new Consulta();
        c.setProfissionalId(dto.getProfissionalId());
        c.setPacienteId(dto.getPacienteId());
        c.setDataConsulta(dto.getDataConsulta());
        c.setStatusConsulta(dto.getStatusConsulta());
        c.setQuantidadeHoras(dto.getQuantidadeHoras());
        c.setValorConsulta(dto.getValorConsulta());
        return c;
    }

    private ConsultaDTO entityToDto(Consulta c) {
        ConsultaDTO dto = new ConsultaDTO();
        dto.setProfissionalId(c.getProfissionalId());
        dto.setPacienteId(c.getPacienteId());
        dto.setDataConsulta(c.getDataConsulta());
        dto.setStatusConsulta(c.getStatusConsulta());
        dto.setQuantidadeHoras(c.getQuantidadeHoras());
        dto.setValorConsulta(c.getValorConsulta());
        return dto;
    }
}
