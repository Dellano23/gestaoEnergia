package br.com.fiap.gestaoEnergia.service;

import br.com.fiap.gestaoEnergia.model.ConsumoEnergia;
import br.com.fiap.gestaoEnergia.repository.ConsumoEnergiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ConsumoEnergiaService {
    @Autowired
    private ConsumoEnergiaRepository consumoEnergiaRepository;

    public ConsumoEnergia gravar(ConsumoEnergia gestaoEnergia){
        return consumoEnergiaRepository.save(gestaoEnergia);

    }

    public ConsumoEnergia buscarPorId(Long id){
        //usa o optional pra n ter retorno de null pointer exception
        Optional<ConsumoEnergia> gestaoEnergia = consumoEnergiaRepository.findById(id);

        if (gestaoEnergia.isPresent()){
            return gestaoEnergia.get();
        } else {
            throw new RuntimeException("Não encontrado!");
        }
    }

    public List<ConsumoEnergia> listarTodasGestoes(){
        return consumoEnergiaRepository.findAll();
    }

    public void excluir(Long id){
        Optional<ConsumoEnergia> gestaoEnergia = consumoEnergiaRepository.findById(id);

        if (gestaoEnergia.isPresent()){
            consumoEnergiaRepository.delete(gestaoEnergia.get());
        } else {
            throw new RuntimeException("Não encontrado!");
        }

    }

    public List<ConsumoEnergia> buscarGestaoPorData(LocalDate dataInicial, LocalDate dataFinal){
        return consumoEnergiaRepository.findByDataLeituraBetween(dataInicial, dataFinal);
    }

    public ConsumoEnergia atualizar(ConsumoEnergia gestaoEnergia){
        Optional<ConsumoEnergia> gestaoEnergiaOptional = consumoEnergiaRepository.findById(gestaoEnergia.getIdConsumo());
        if (gestaoEnergiaOptional.isPresent()){
            return consumoEnergiaRepository.save(gestaoEnergia);
        } else{
            throw new RuntimeException("Não encontrado!");
        }
    }

    public List<ConsumoEnergia> listarTodosOrdenadosPorConsumo() {
        return consumoEnergiaRepository.findAllByOrderByConsumoKwhDesc();
    }

}
