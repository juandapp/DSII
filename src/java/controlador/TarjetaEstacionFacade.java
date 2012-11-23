/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import logica.TarjetaEstacion;

/**
 *
 * @author juandapp
 */
@Stateless
public class TarjetaEstacionFacade extends AbstractFacade<TarjetaEstacion> {
    @PersistenceContext(unitName = "DSIIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TarjetaEstacionFacade() {
        super(TarjetaEstacion.class);
    }
    
}
