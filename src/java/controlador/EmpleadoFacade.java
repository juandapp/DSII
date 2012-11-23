/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import logica.Empleado;

/**
 *
 * @author juandapp
 */
@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleado> {
    @PersistenceContext(unitName = "DSIIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadoFacade() {
        super(Empleado.class);
    }
    
}
