/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author eric_
 */
@Entity
@Table(name = "carta")
public class Carta implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_carta", sequenceName = "seq_carta_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_carta", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 30, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 30, nullable = false)
    private String nome;
    @NotNull(message = "A descrição não pode ser nula")
    @NotBlank(message = "A descrição não pode ser em branca")
    @Length(max = 150, message = "A descrição não pode ter mais que {max} caracteres")
    @Column(name = "descricao", length = 150, nullable = false)
    private String descricao;
    @NotNull(message = "O jogo não pode ser nulo")
    @NotBlank(message = "O jogo não pode ser em branco")
    @Length(max = 30, message = "O jogo não pode ter mais que {max} caracteres")
    @Column(name = "jogo", length = 30, nullable = false)
    private String jogo;
    @NotNull(message = "A raridade da carta não pode ser nula")
    @NotBlank(message = "A raridade da carta não pode ser em branca")
    @Length(max = 20, message = "A raridade da carta não pode ter mais que {max} caracteres")
    @Column(name = "raridade", length = 20, nullable = false)
    private String raridade;
    
    public Carta(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getJogo() {
        return jogo;
    }

    public void setJogo(String jogo) {
        this.jogo = jogo;
    }

    public String getRaridade() {
        return raridade;
    }

    public void setRaridade(String raridade) {
        this.raridade = raridade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
