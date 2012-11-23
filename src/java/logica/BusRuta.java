/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juandapp
 */
@Entity
@Table(name = "bus_ruta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BusRuta.findAll", query = "SELECT b FROM BusRuta b"),
    @NamedQuery(name = "BusRuta.findByNombreRuta", query = "SELECT b FROM BusRuta b WHERE b.busRutaPK.nombreRuta = :nombreRuta"),
    @NamedQuery(name = "BusRuta.findByNumerochasisBus", query = "SELECT b FROM BusRuta b WHERE b.busRutaPK.numerochasisBus = :numerochasisBus"),
    @NamedQuery(name = "BusRuta.findByFecha", query = "SELECT b FROM BusRuta b WHERE b.busRutaPK.fecha = :fecha")})
public class BusRuta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BusRutaPK busRutaPK;
    @JoinColumn(name = "nombre_ruta", referencedColumnName = "nombre_ruta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ruta ruta;
    @JoinColumn(name = "numerochasis_bus", referencedColumnName = "numerochasis_bus", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bus bus;

    public BusRuta() {
    }

    public BusRuta(BusRutaPK busRutaPK) {
        this.busRutaPK = busRutaPK;
    }

    public BusRuta(String nombreRuta, String numerochasisBus, Date fecha) {
        this.busRutaPK = new BusRutaPK(nombreRuta, numerochasisBus, fecha);
    }

    public BusRutaPK getBusRutaPK() {
        return busRutaPK;
    }

    public void setBusRutaPK(BusRutaPK busRutaPK) {
        this.busRutaPK = busRutaPK;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (busRutaPK != null ? busRutaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BusRuta)) {
            return false;
        }
        BusRuta other = (BusRuta) object;
        if ((this.busRutaPK == null && other.busRutaPK != null) || (this.busRutaPK != null && !this.busRutaPK.equals(other.busRutaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.BusRuta[ busRutaPK=" + busRutaPK + " ]";
    }
    
}
