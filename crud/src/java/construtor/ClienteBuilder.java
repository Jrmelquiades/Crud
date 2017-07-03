/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package construtor;

import controlador.ControladorCliente;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import negocio.Cliente;

/**
 *
 * @author LUCINALDO
 */
@ManagedBean
@RequestScoped
public class ClienteBuilder {
    private long id;
    private String nome;
    private String email;
    private String nascimento;
    private String celular;
    private String pais;
    private String cep;
    private String endereco;
    FacesContext faces = FacesContext.getCurrentInstance();
    private ControladorCliente controlador = (ControladorCliente) faces.getApplication().evaluateExpressionGet(faces, "#{controladorCliente}", ControladorCliente.class);
    private boolean alterando = false;
    
    public ClienteBuilder() {
        Cliente c = controlador.getAlterando();
        if(c!=null) {
            this.id = c.getId();
            this.nome = c.getNome();
            this.email = c.getEmail();
            this.nascimento = c.getNascimento();
            this.celular = c.getCelular();
            this.pais = c.getPais();
            this.cep = c.getCep();
            this.endereco = c.getEndereco();
            this.alterando = true;
        }
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getNascimento() {
        return nascimento;
    }

    public String getCelular() {
        return celular;
    }

    public String getPais() {
        return pais;
    }

    public String getCep() {
        return cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public Cliente construir() {
        return new Cliente(id,nome,email,celular,nascimento,pais,cep,endereco);
    }
}
