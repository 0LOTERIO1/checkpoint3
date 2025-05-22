package br.com.fiap.checkpoint1.controller;

import br.com.fiap.checkpoint1.dto.ProfissionalDTO;
import br.com.fiap.checkpoint1.model.Profissional;
import br.com.fiap.checkpoint1.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalService service;

    @PostMapping
    public ResponseEntity<ProfissionalDTO> create(@RequestBody ProfissionalDTO dto) {
        Profissional p = dtoToEntity(dto);
        return ResponseEntity.status(201).body(entityToDto(service.create(p)));
    }

    @GetMapping
    public ResponseEntity<List<ProfissionalDTO>> findAll() {
        return ResponseEntity.ok(service.findAll().stream().map(this::entityToDto).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalDTO> findById(@PathVariable Long id) {
        Profissional p = service.findById(id);
        return p != null ? ResponseEntity.ok(entityToDto(p)) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfissionalDTO> update(@PathVariable Long id, @RequestBody ProfissionalDTO dto) {
        Profissional p = service.update(id, dtoToEntity(dto));
        return p != null ? ResponseEntity.ok(entityToDto(p)) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    private Profissional dtoToEntity(ProfissionalDTO dto) {
        Profissional p = new Profissional();
        p.setNome(dto.getNome());
        p.setEspecialidade(dto.getEspecialidade());
        p.setValorHora(dto.getValorHora());
        return p;
    }

    private ProfissionalDTO entityToDto(Profissional p) {
        ProfissionalDTO dto = new ProfissionalDTO();
        dto.setNome(p.getNome());
        dto.setEspecialidade(p.getEspecialidade());
        dto.setValorHora(p.getValorHora());
        return dto;
    }
}
