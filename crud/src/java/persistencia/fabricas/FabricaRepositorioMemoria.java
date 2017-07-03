/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.fabricas;

import persistencia.implementacoes.RepositorioClienteMemoria;
import persistencia.interfaces.RepositorioCliente;

/**
 *
 * @author lucas
 */
class FabricaRepositorioMemoria extends FabricaRepositorio {

    protected FabricaRepositorioMemoria() {
        
    }
    
    @Override
    protected RepositorioCliente newRepositorioCliente() {
        return new RepositorioClienteMemoria();
    }
}
