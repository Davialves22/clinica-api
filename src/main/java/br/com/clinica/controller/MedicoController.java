package br.com.clinica.controller;

import br.com.clinica.model.Medico;
import br.com.clinica.service.MedicoService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medico/v1")
@CrossOrigin
@Tag(name = "Médicos", description = "Endpoints para gerenciamento de médicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Medico> save(@RequestBody Medico medico) {
        Medico medicoSalvo = medicoService.save(medico);
        return new ResponseEntity<>(medicoSalvo, HttpStatus.CREATED);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Medico> listarTodos() {
        return medicoService.listarTodos();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Medico> obterPorID(@PathVariable Long id) {
        Medico medico = medicoService.obterPorID(id);
        return ResponseEntity.ok(medico);
    }

    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Medico medico) {
        medicoService.update(id, medico);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        medicoService.delete(id);
        return ResponseEntity.ok().build();
    }
}