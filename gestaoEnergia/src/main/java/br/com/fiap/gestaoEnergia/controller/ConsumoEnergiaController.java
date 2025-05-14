package br.com.fiap.gestaoEnergia.controller;

import br.com.fiap.gestaoEnergia.model.ConsumoEnergia;
import br.com.fiap.gestaoEnergia.service.ConsumoEnergiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ConsumoEnergiaController {

    @Autowired
    private ConsumoEnergiaService service;

    @PostMapping("/gestao")
    @ResponseStatus(HttpStatus.CREATED)
    public ConsumoEnergia gravar(@RequestBody ConsumoEnergia gestaoEnergia) {
        return service.gravar(gestaoEnergia);
    }

    @GetMapping("/gestao")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsumoEnergia> listarTodasGestoes() {
        return service.listarTodasGestoes();
    }

    @DeleteMapping("/gestao/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        service.excluir(id);
    }

    @PutMapping("/gestao")
    @ResponseStatus(HttpStatus.OK)
    public ConsumoEnergia atualizar(@RequestBody ConsumoEnergia gestaoEnergia){
        return service.atualizar(gestaoEnergia);
    }

    @GetMapping("/gestao/{dataInicail}/{dataFinal}")
    public List<ConsumoEnergia> listarPorData(
            @PathVariable LocalDate dataInical,
            @PathVariable LocalDate dataFinal
    ){
        return service.buscarGestaoPorData(dataInical,dataFinal);
    }

    @GetMapping("/gestao/maiorConsumo")
    public List<ConsumoEnergia> listarMaioresConsumos() {
        return service.listarTodosOrdenadosPorConsumo();

    }
}
