/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import logica.ConductorBus;

/**
 *
 * @author juandapp
 */
@Stateless
public class ConductorBusFacade extends AbstractFacade<ConductorBus> {
    @PersistenceContext(unitName = "DSIIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConductorBusFacade() {
        super(ConductorBus.class);
    }
    
}
