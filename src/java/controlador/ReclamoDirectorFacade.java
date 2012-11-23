/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import logica.ReclamoDirector;

/**
 *
 * @author juandapp
 */
@Stateless
public class ReclamoDirectorFacade extends AbstractFacade<ReclamoDirector> {
    @PersistenceContext(unitName = "DSIIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReclamoDirectorFacade() {
        super(ReclamoDirector.class);
    }
    
}
