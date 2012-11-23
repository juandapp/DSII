/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import logica.ReclamoDirectorestacion;

/**
 *
 * @author juandapp
 */
@Stateless
public class ReclamoDirectorestacionFacade extends AbstractFacade<ReclamoDirectorestacion> {
    @PersistenceContext(unitName = "DSIIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReclamoDirectorestacionFacade() {
        super(ReclamoDirectorestacion.class);
    }
    
}
