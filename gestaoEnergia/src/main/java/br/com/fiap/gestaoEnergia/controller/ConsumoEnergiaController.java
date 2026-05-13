package br.com.fiap.gestaoEnergia.controller;

import br.com.fiap.gestaoEnergia.model.ConsumoEnergia;
import br.com.fiap.gestaoEnergia.service.ConsumoEnergiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ConsumoEnergiaController {

    @Autowired
    private ConsumoEnergiaService service;

    @PostMapping("/api/gestao")
    @ResponseStatus(HttpStatus.CREATED)
    public ConsumoEnergia gravar(@RequestBody ConsumoEnergia gestaoEnergia) {
        return service.gravar(gestaoEnergia);
    }

    @GetMapping("/api/gestao")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsumoEnergia> listarTodasGestoes() {
        return service.listarTodasGestoes();
    }

    @DeleteMapping("/api/gestao/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        service.excluir(id);
    }

    @PutMapping("/api/gestao")
    @ResponseStatus(HttpStatus.OK)
    public ConsumoEnergia atualizar(@RequestBody ConsumoEnergia gestaoEnergia){
        return service.atualizar(gestaoEnergia);
    }

    @GetMapping("/api/gestao/{dataInicial}/{dataFinal}")
    public List<ConsumoEnergia> listarPorData(
            @PathVariable LocalDate dataInicial,
            @PathVariable LocalDate dataFinal
    ){
        return service.buscarGestaoPorData(dataInicial,dataFinal);
    }

    @GetMapping("/api/gestao/maiorConsumo")
    public List<ConsumoEnergia> listarMaioresConsumos() {
        return service.listarTodosOrdenadosPorConsumo();

    }
}
