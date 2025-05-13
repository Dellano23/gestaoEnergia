package br.com.fiap.gestaoEnergia.controller;

import br.com.fiap.gestaoEnergia.model.GestaoEnergia;
import br.com.fiap.gestaoEnergia.service.GestaoEnergiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GestaoEnergiaController {

    @Autowired
    private GestaoEnergiaService service;

    @PostMapping("/gestao")
    @ResponseStatus(HttpStatus.CREATED)
    public GestaoEnergia gravar(@RequestBody GestaoEnergia gestaoEnergia) {
        return service.gravar(gestaoEnergia);
    }

    @GetMapping("/gestao")
    @ResponseStatus(HttpStatus.OK)
    public List<GestaoEnergia> listarTodasGestoes() {
        return service.listarTodasGestoes();
    }

    @DeleteMapping("/gestao/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        service.excluir(id);
    }

    @PutMapping("/gestao")
    @ResponseStatus(HttpStatus.OK)
    public GestaoEnergia atualizar(GestaoEnergia gestaoEnergia){
        return service.atualizar(gestaoEnergia);
    }

    @GetMapping("/gestao/{dataInicail}/{dataFinal}")
    public List<GestaoEnergia> listarPorData(
            @PathVariable LocalDate dataInical,
            @PathVariable LocalDate dataFinal
    ){
        return service.buscarGestaoPorData(dataInical,dataFinal);
    }
}
