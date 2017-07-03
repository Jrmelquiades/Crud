/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.fabricas;

import persistencia.implementacoes.RepositorioClienteBD;
import persistencia.interfaces.RepositorioCliente;

/**
 *
 * @author lucas
 */
class FabricaRepositorioBD extends FabricaRepositorio {
    
    protected FabricaRepositorioBD() {
        
    }
    @Override
    protected RepositorioCliente newRepositorioCliente() {
        return new RepositorioClienteBD();
    }
}
