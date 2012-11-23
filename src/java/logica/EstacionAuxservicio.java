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
@Table(name = "estacion_auxservicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstacionAuxservicio.findAll", query = "SELECT e FROM EstacionAuxservicio e"),
    @NamedQuery(name = "EstacionAuxservicio.findByIdentificacionAuxservicio", query = "SELECT e FROM EstacionAuxservicio e WHERE e.estacionAuxservicioPK.identificacionAuxservicio = :identificacionAuxservicio"),
    @NamedQuery(name = "EstacionAuxservicio.findByNombreEstacion", query = "SELECT e FROM EstacionAuxservicio e WHERE e.estacionAuxservicioPK.nombreEstacion = :nombreEstacion"),
    @NamedQuery(name = "EstacionAuxservicio.findByFecha", query = "SELECT e FROM EstacionAuxservicio e WHERE e.estacionAuxservicioPK.fecha = :fecha")})
public class EstacionAuxservicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstacionAuxservicioPK estacionAuxservicioPK;
    @JoinColumn(name = "nombre_estacion", referencedColumnName = "nombre_estacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estacion estacion;
    @JoinColumn(name = "identificacion_auxservicio", referencedColumnName = "identificacion_empleado", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empleado empleado;

    public EstacionAuxservicio() {
    }

    public EstacionAuxservicio(EstacionAuxservicioPK estacionAuxservicioPK) {
        this.estacionAuxservicioPK = estacionAuxservicioPK;
    }

    public EstacionAuxservicio(String identificacionAuxservicio, String nombreEstacion, Date fecha) {
        this.estacionAuxservicioPK = new EstacionAuxservicioPK(identificacionAuxservicio, nombreEstacion, fecha);
    }

    public EstacionAuxservicioPK getEstacionAuxservicioPK() {
        return estacionAuxservicioPK;
    }

    public void setEstacionAuxservicioPK(EstacionAuxservicioPK estacionAuxservicioPK) {
        this.estacionAuxservicioPK = estacionAuxservicioPK;
    }

    public Estacion getEstacion() {
        return estacion;
    }

    public void setEstacion(Estacion estacion) {
        this.estacion = estacion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estacionAuxservicioPK != null ? estacionAuxservicioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstacionAuxservicio)) {
            return false;
        }
        EstacionAuxservicio other = (EstacionAuxservicio) object;
        if ((this.estacionAuxservicioPK == null && other.estacionAuxservicioPK != null) || (this.estacionAuxservicioPK != null && !this.estacionAuxservicioPK.equals(other.estacionAuxservicioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.EstacionAuxservicio[ estacionAuxservicioPK=" + estacionAuxservicioPK + " ]";
    }
    
}
