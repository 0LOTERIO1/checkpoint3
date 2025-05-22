package br.com.fiap.checkpoint1.controller;

import br.com.fiap.checkpoint1.dto.PacienteDTO;
import br.com.fiap.checkpoint1.model.Paciente;
import br.com.fiap.checkpoint1.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping
    public ResponseEntity<PacienteDTO> create(@RequestBody PacienteDTO dto) {
        Paciente paciente = dtoToEntity(dto);
        return ResponseEntity.status(201).body(entityToDto(service.create(paciente)));
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> findAll() {
        return ResponseEntity.ok(service.findAll().stream().map(this::entityToDto).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> findById(@PathVariable Long id) {
        Paciente paciente = service.findById(id);
        return paciente != null ? ResponseEntity.ok(entityToDto(paciente)) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDTO> update(@PathVariable Long id, @RequestBody PacienteDTO dto) {
        Paciente paciente = service.update(id, dtoToEntity(dto));
        return paciente != null ? ResponseEntity.ok(entityToDto(paciente)) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    private Paciente dtoToEntity(PacienteDTO dto) {
        Paciente p = new Paciente();
        p.setNome(dto.getNome());
        p.setEndereco(dto.getEndereco());
        p.setBairro(dto.getBairro());
        p.setEmail(dto.getEmail());
        p.setTelefoneCompleto(dto.getTelefoneCompleto());
        return p;
    }

    private PacienteDTO entityToDto(Paciente p) {
        PacienteDTO dto = new PacienteDTO();
        dto.setNome(p.getNome());
        dto.setEndereco(p.getEndereco());
        dto.setBairro(p.getBairro());
        dto.setEmail(p.getEmail());
        dto.setTelefoneCompleto(p.getTelefoneCompleto());
        return dto;
    }
}
