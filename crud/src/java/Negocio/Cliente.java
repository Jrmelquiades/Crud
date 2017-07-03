/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import persistencia.interfaces.Persistivel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author LUCINALDO
 */
@Entity
@Table
public class Cliente implements Persistivel<Cliente>{
    
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String nome;
    @Column
    private String email;
    @Column
    private String nascimento;
    @Column
    private String celular;
    @Column
    private String pais;
    @Column
    private String cep;
    @Column
    private String endereco;

    public Cliente(String nome, String email, String nascimento, String celular, String pais, String cep, String endereco) {
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
        this.celular = celular;
        this.pais = pais;
        this.cep = cep;
        this.endereco = endereco;
    }

    public Cliente(long id, String nome, String email, String nascimento, String celular, String pais, String cep, String endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
        this.celular = celular;
        this.pais = pais;
        this.cep = cep;
        this.endereco = endereco;
    }

    public Cliente() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nasciento) {
        this.nascimento = nasciento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    @Override
    public void alterar(Cliente c) {
        this.setEmail(c.getEmail());
        this.setNome(c.getNome());
        this.setEndereco(c.getEndereco());
        this.setNascimento(c.getNascimento());
        this.setCep(c.getCep());
        this.setCelular(c.getCelular());
        this.setPais(c.getPais());
    }

    @Override
    public Cliente copiar() {
        return new Cliente (email,nome,endereco,nascimento,cep,celular,pais);
    }
}
