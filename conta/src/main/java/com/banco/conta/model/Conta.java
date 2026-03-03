package com.banco.conta.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero")
    private int numero;
    @Column(name = "saldo")
    private double saldo;

    @JoinColumn(name = "usuario_id")
    @OneToOne
    private User user;

}
