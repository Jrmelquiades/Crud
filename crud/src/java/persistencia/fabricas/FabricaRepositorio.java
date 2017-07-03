/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.fabricas;


import negocio.Cliente;
import persistencia.interfaces.Repositorio;
import persistencia.interfaces.RepositorioCliente;



/**
 * Use para conseguir repositórios. Caso queira alterar de Memoria para BD ou outra coisa, mude dentro do método getInstance.
 * @author lucas
 */
public abstract class FabricaRepositorio {
    
    private static FabricaRepositorio fabrica = null;
    protected FabricaRepositorio(){}
    
    // os objetos =D
    
    private RepositorioCliente clientes = null;
    
    /**
     * Isso vai lhe dar uma Fábrica de Repositórios.
     * @return uma fábrica de repositórios.
     */
    public static FabricaRepositorio getFabrica() {
        if(fabrica == null) fabrica = new FabricaRepositorioBD(); //m mude aqui!
        return fabrica;
    }
    
    //  Métodos públicos
    /**
     * Retorna o repositório de prova
     * @return o repositório de prova
     */
    
    public final RepositorioCliente getRepositorioCliente() {
        if(clientes == null)
            clientes = newRepositorioCliente();
        return clientes;
    }
    
    // Métodos abstratos (protegidos)
    /**
     * Retorna um repositório para provas novo
     * @return repositório de provas
     */
    
    protected abstract RepositorioCliente newRepositorioCliente();
    
    /**
     * Retorna um repositório para a classe desejada.
     * @param c a classe desejada
     * @return  o repositório para a classe
     */
    public Repositorio getRepositorio(Class c) {
        if(c==null){
            return null;
        } else if(c.equals(Cliente.class)){
            return this.getRepositorioCliente();
        }else{
            return null; 
        }
    }
}