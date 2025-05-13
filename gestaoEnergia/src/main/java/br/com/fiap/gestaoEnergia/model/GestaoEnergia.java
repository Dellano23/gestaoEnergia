package br.com.fiap.gestaoEnergia.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_gestao_energia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GestaoEnergia {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_GESTAO"
    )
    @SequenceGenerator(
            name = "SEQ_GESTAO",
            sequenceName = "SEQ_GESTAO",
            allocationSize = 1
    )
    @Column(name = "id_consumo")
    private Long idConsumo;
    @Column(name = "data_leitura")
    private LocalDate dataLeitura;
    @Column(name = "consumo")
    private BigDecimal consumoKwh; //aqui é o consumo de energia em si
    //criar equipamento dps
}
