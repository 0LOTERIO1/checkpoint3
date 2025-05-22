package br.com.fiap.checkpoint1.service;

import br.com.fiap.checkpoint1.model.Consulta;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaService {
    private List<Consulta> consultas = new ArrayList<>();
    private Long idCounter = 1L;

    public Consulta create(Consulta c) {
        c.setId(idCounter++);
        c.setCreatedAt(LocalDateTime.now());
        c.setUpdatedAt(LocalDateTime.now());
        consultas.add(c);
        return c;
    }

    public List<Consulta> findAll() {
        return consultas;
    }

    public Consulta findById(Long id) {
        return consultas.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public Consulta update(Long id, Consulta c) {
        Consulta existing = findById(id);
        if (existing != null) {
            existing.setDataConsulta(c.getDataConsulta());
            existing.setStatusConsulta(c.getStatusConsulta());
            existing.setQuantidadeHoras(c.getQuantidadeHoras());
            existing.setValorConsulta(c.getValorConsulta());
            existing.setUpdatedAt(LocalDateTime.now());
        }
        return existing;
    }

    public boolean delete(Long id) {
        return consultas.removeIf(c -> c.getId().equals(id));
    }
}
