/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.mycompany.entity.Cliente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marioh.ramirez
 */
@Local
public interface ClienteManagerLocal {

    List <Cliente> getAllCliente();

    Cliente update(Cliente cliente);
    
}
