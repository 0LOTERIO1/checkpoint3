package br.com.fiap.checkpoint1.service;

import br.com.fiap.checkpoint1.model.Paciente;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {
    private List<Paciente> pacientes = new ArrayList<>();
    private Long idCounter = 1L;

    public Paciente create(Paciente p) {
        p.setId(idCounter++);
        p.setCreatedAt(LocalDateTime.now());
        p.setUpdatedAt(LocalDateTime.now());
        pacientes.add(p);
        return p;
    }

    public List<Paciente> findAll() {
        return pacientes;
    }

    public Paciente findById(Long id) {
        return pacientes.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public Paciente update(Long id, Paciente p) {
        Paciente existing = findById(id);
        if (existing != null) {
            existing.setNome(p.getNome());
            existing.setEndereco(p.getEndereco());
            existing.setBairro(p.getBairro());
            existing.setEmail(p.getEmail());
            existing.setTelefoneCompleto(p.getTelefoneCompleto());
            existing.setUpdatedAt(LocalDateTime.now());
        }
        return existing;
    }

    public boolean delete(Long id) {
        return pacientes.removeIf(p -> p.getId().equals(id));
    }
}
