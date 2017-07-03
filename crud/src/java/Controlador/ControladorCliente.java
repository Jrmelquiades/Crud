/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import negocio.Cliente;
import persistencia.fabricas.FabricaRepositorio;
import persistencia.interfaces.RepositorioCliente;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author LUCINALDO
 */
@ManagedBean
@SessionScoped
public class ControladorCliente {
    private Cliente alterando = null;
    private Cliente selected = null;
    private final RepositorioCliente repositorio = FabricaRepositorio.getFabrica().getRepositorioCliente();
    
    public ControladorCliente() {
    }
    
    public void remover() {
        remover(selected);
    }
    
    public String adicionar(Cliente c) {
        if(repositorio.existe(c.getId())) {
            repositorio.alterar(c);
        } else {
            repositorio.adicionar(c);
        }
        return "ApresentarCliente.xhtml";
    }
    
    public void remover(Cliente c) {
        repositorio.remover(c);
    }
    
    public void alterar(Cliente c) {
        repositorio.alterar(c);
    }
    
    public String alterar() {
        this.alterando = selected;
        return "CadastrarCliente.xhtml";
    }
    public Cliente recuperar(long id) {
        return repositorio.recuperar(id);
    }
    
    public List<Cliente> recuperarTodos() {
        return repositorio.recuperar();
    }
    
     public Cliente getSelected() {
        return selected;
    }

    public void setSelected(Cliente selected) {
        this.selected = selected;
    }
    
    public Cliente getAlterando() {
        return alterando;
    }

    public void setAlterando(Cliente alterando) {
        this.alterando = alterando;
    }
}
