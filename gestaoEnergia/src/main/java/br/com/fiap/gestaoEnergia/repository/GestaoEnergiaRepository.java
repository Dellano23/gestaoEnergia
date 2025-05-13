package br.com.fiap.gestaoEnergia.repository;

import br.com.fiap.gestaoEnergia.model.GestaoEnergia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface GestaoEnergiaRepository extends JpaRepository<GestaoEnergia, Long> {

    public List<GestaoEnergia> findByDataLeituraBetween(LocalDate dataInicial, LocalDate dataFinal);


}
