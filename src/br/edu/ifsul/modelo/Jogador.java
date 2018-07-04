package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author eric_
 */
@Entity
@Table(name = "jogador")
public class Jogador implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_jogador", sequenceName = "seq_jogador_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_jogador", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O nickname não pode ser nulo")
    @NotBlank(message = "O nickname não pode ser em branco")
    @Length(max = 20, message = "O nickname não pode ter mais que {max} caracteres")
    @Column(name = "nick", length = 20, nullable = false)    
    private String nick;
    @Email(message = "O email deve ser válido")
    @NotNull(message = "O email não pode ser nulo")
    @NotBlank(message = "O email não pode ser em branco")
    @Length(max = 50, message = "O email não pode ter mais que {max} caracteres")
    @Column(name = "email", length = 50, nullable = false)    
    private String email;
    @CPF(message = "O CPF deve ser válido")
    @NotNull(message = "O CPF não pode ser nulo")
    @NotBlank(message = "O CPF não pode ser em branco")
    @Length(max = 14, message = "O CPF não pode ter mais que {max} caracteres")
    @Column(name = "cpf", length = 14, nullable = false)
    private String cpf;
    @NotNull(message = "A password não pode ser nulo")
    @NotBlank(message = "A password não pode ser em branco")
    @Length(max = 20, message = "A password não pode ter mais que {max} caracteres")    
    @Column(name = "password", length = 20, nullable = false) 
    private String password;
    @ManyToMany
    @JoinTable(name = "permissoes",
            joinColumns
            = @JoinColumn(name = "jogador", referencedColumnName = "nick", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "permissao", referencedColumnName = "nome", nullable = false),
            uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_permissoes",
                        columnNames = {"jogador", "permissao"})})
    private List<Permissao> permissoes = new ArrayList<>();  
    @ManyToMany
    @JoinTable(name = "deck",
            joinColumns
            = @JoinColumn(name = "jogador", referencedColumnName = "nick", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "carta", referencedColumnName = "nome", nullable = false),
            uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_deck",
                        columnNames = {"jogador", "carta"})})
    private List<Carta> deck = new ArrayList<>();  

    public Jogador(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Jogador other = (Jogador) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Carta> getDeck() {
        return deck;
    }

    public void setDeck(List<Carta> deck) {
        this.deck = deck;
    }
    
    
}
