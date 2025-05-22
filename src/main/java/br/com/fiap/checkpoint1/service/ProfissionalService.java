package br.com.fiap.checkpoint1.service;

import br.com.fiap.checkpoint1.model.Profissional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfissionalService {
    private List<Profissional> profissionais = new ArrayList<>();
    private Long idCounter = 1L;

    public Profissional create(Profissional p) {
        p.setId(idCounter++);
        p.setCreatedAt(LocalDateTime.now());
        p.setUpdatedAt(LocalDateTime.now());
        profissionais.add(p);
        return p;
    }

    public List<Profissional> findAll() {
        return profissionais;
    }

    public Profissional findById(Long id) {
        return profissionais.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public Profissional update(Long id, Profissional p) {
        Profissional existing = findById(id);
        if (existing != null) {
            existing.setNome(p.getNome());
            existing.setEspecialidade(p.getEspecialidade());
            existing.setValorHora(p.getValorHora());
            existing.setUpdatedAt(LocalDateTime.now());
        }
        return existing;
    }

    public boolean delete(Long id) {
        return profissionais.removeIf(p -> p.getId().equals(id));
    }
}
