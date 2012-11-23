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
@Table(name = "estacion_directorestacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstacionDirectorestacion.findAll", query = "SELECT e FROM EstacionDirectorestacion e"),
    @NamedQuery(name = "EstacionDirectorestacion.findByIdentificacionDirectorestacion", query = "SELECT e FROM EstacionDirectorestacion e WHERE e.estacionDirectorestacionPK.identificacionDirectorestacion = :identificacionDirectorestacion"),
    @NamedQuery(name = "EstacionDirectorestacion.findByNombreEstacion", query = "SELECT e FROM EstacionDirectorestacion e WHERE e.estacionDirectorestacionPK.nombreEstacion = :nombreEstacion"),
    @NamedQuery(name = "EstacionDirectorestacion.findByFecha", query = "SELECT e FROM EstacionDirectorestacion e WHERE e.estacionDirectorestacionPK.fecha = :fecha")})
public class EstacionDirectorestacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstacionDirectorestacionPK estacionDirectorestacionPK;
    @JoinColumn(name = "nombre_estacion", referencedColumnName = "nombre_estacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estacion estacion;
    @JoinColumn(name = "identificacion_directorestacion", referencedColumnName = "identificacion_empleado", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empleado empleado;

    public EstacionDirectorestacion() {
    }

    public EstacionDirectorestacion(EstacionDirectorestacionPK estacionDirectorestacionPK) {
        this.estacionDirectorestacionPK = estacionDirectorestacionPK;
    }

    public EstacionDirectorestacion(String identificacionDirectorestacion, String nombreEstacion, Date fecha) {
        this.estacionDirectorestacionPK = new EstacionDirectorestacionPK(identificacionDirectorestacion, nombreEstacion, fecha);
    }

    public EstacionDirectorestacionPK getEstacionDirectorestacionPK() {
        return estacionDirectorestacionPK;
    }

    public void setEstacionDirectorestacionPK(EstacionDirectorestacionPK estacionDirectorestacionPK) {
        this.estacionDirectorestacionPK = estacionDirectorestacionPK;
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
        hash += (estacionDirectorestacionPK != null ? estacionDirectorestacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstacionDirectorestacion)) {
            return false;
        }
        EstacionDirectorestacion other = (EstacionDirectorestacion) object;
        if ((this.estacionDirectorestacionPK == null && other.estacionDirectorestacionPK != null) || (this.estacionDirectorestacionPK != null && !this.estacionDirectorestacionPK.equals(other.estacionDirectorestacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.EstacionDirectorestacion[ estacionDirectorestacionPK=" + estacionDirectorestacionPK + " ]";
    }
    
}
