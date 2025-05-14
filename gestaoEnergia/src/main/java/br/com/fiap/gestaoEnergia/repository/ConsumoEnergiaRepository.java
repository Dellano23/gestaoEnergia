package br.com.fiap.gestaoEnergia.repository;

import br.com.fiap.gestaoEnergia.model.ConsumoEnergia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ConsumoEnergiaRepository extends JpaRepository<ConsumoEnergia, Long> {

    public List<ConsumoEnergia> findByDataLeituraBetween(LocalDate dataInicial, LocalDate dataFinal);


    List<ConsumoEnergia> findAllByOrderByConsumoKwhDesc();


}
