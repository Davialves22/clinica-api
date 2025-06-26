package br.com.clinica.service;

import br.com.clinica.model.Medico;
import br.com.clinica.repository.MedicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico save(Medico medico) {
        return medicoRepository.save(medico);
    }

    public List<Medico> listarTodos() {
        return medicoRepository.findAll();
    }

    public Medico obterPorID(Long id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médico não encontrado com id: " + id));
    }

    public void update(Long id, Medico medicoAtualizado) {
        Medico medicoExistente = obterPorID(id);
        medicoExistente.setNome(medicoAtualizado.getNome());
        medicoExistente.setCrm(medicoAtualizado.getCrm());
        medicoExistente.setDataInscricao(medicoAtualizado.getDataInscricao());
        medicoExistente.setUsuario(medicoAtualizado.getUsuario());
        medicoExistente.setEspecialidades(medicoAtualizado.getEspecialidades());
        medicoRepository.save(medicoExistente);
    }

    public void delete(Long id) {
        medicoRepository.deleteById(id);
    }
}