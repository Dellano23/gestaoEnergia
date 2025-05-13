package br.com.fiap.gestaoEnergia.service;

import br.com.fiap.gestaoEnergia.model.GestaoEnergia;
import br.com.fiap.gestaoEnergia.repository.GestaoEnergiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class GestaoEnergiaService {
    @Autowired
    private GestaoEnergiaRepository gestaoEnergiaRepository;

    public GestaoEnergia gravar(GestaoEnergia gestaoEnergia){
        return gestaoEnergiaRepository.save(gestaoEnergia);

    }

    public GestaoEnergia buscarPorId(Long id){
        //usa o optional pra n ter retorno de null pointer exception
        Optional<GestaoEnergia> gestaoEnergia = gestaoEnergiaRepository.findById(id);

        if (gestaoEnergia.isPresent()){
            return gestaoEnergia.get();
        } else {
            throw new RuntimeException("Não encontrado!");
        }
    }

    public List<GestaoEnergia> listarTodasGestoes(){
        return gestaoEnergiaRepository.findAll();
    }

    public void excluir(Long id){
        Optional<GestaoEnergia> gestaoEnergia = gestaoEnergiaRepository.findById(id);

        if (gestaoEnergia.isPresent()){
            gestaoEnergiaRepository.delete(gestaoEnergia.get());
        } else {
            throw new RuntimeException("Não encontrado!");
        }

    }

    public List<GestaoEnergia> buscarGestaoPorData(LocalDate dataInicial, LocalDate dataFinal){
        return gestaoEnergiaRepository.findByDataLeituraBetween(dataInicial, dataFinal);
    }

    public GestaoEnergia atualizar(GestaoEnergia gestaoEnergia){
        Optional<GestaoEnergia> gestaoEnergiaOptional = gestaoEnergiaRepository.findById(gestaoEnergia.getIdConsumo());
        if (gestaoEnergiaOptional.isPresent()){
            return gestaoEnergiaRepository.save(gestaoEnergia);
        } else{
            throw new RuntimeException("Não encontrado!");
        }
    }
}
