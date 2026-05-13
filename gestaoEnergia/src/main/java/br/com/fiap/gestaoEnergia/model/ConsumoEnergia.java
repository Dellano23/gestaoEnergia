package br.com.fiap.gestaoEnergia.model;

import com.fasterxml.jackson.annotation.JsonProperty; // Import necessário
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
public class ConsumoEnergia {

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
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // Define o ID como apenas leitura
    private Long idConsumo;

    @Column(name = "data_leitura")
    private LocalDate dataLeitura;

    @Column(name = "consumo")
    private BigDecimal consumoKwh;

    private String equipamento;
}