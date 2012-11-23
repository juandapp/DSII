/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author juandapp
 */
@Embeddable
public class EstacionAuxservicioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "identificacion_auxservicio")
    private String identificacionAuxservicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_estacion")
    private String nombreEstacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public EstacionAuxservicioPK() {
    }

    public EstacionAuxservicioPK(String identificacionAuxservicio, String nombreEstacion, Date fecha) {
        this.identificacionAuxservicio = identificacionAuxservicio;
        this.nombreEstacion = nombreEstacion;
        this.fecha = fecha;
    }

    public String getIdentificacionAuxservicio() {
        return identificacionAuxservicio;
    }

    public void setIdentificacionAuxservicio(String identificacionAuxservicio) {
        this.identificacionAuxservicio = identificacionAuxservicio;
    }

    public String getNombreEstacion() {
        return nombreEstacion;
    }

    public void setNombreEstacion(String nombreEstacion) {
        this.nombreEstacion = nombreEstacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificacionAuxservicio != null ? identificacionAuxservicio.hashCode() : 0);
        hash += (nombreEstacion != null ? nombreEstacion.hashCode() : 0);
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstacionAuxservicioPK)) {
            return false;
        }
        EstacionAuxservicioPK other = (EstacionAuxservicioPK) object;
        if ((this.identificacionAuxservicio == null && other.identificacionAuxservicio != null) || (this.identificacionAuxservicio != null && !this.identificacionAuxservicio.equals(other.identificacionAuxservicio))) {
            return false;
        }
        if ((this.nombreEstacion == null && other.nombreEstacion != null) || (this.nombreEstacion != null && !this.nombreEstacion.equals(other.nombreEstacion))) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.EstacionAuxservicioPK[ identificacionAuxservicio=" + identificacionAuxservicio + ", nombreEstacion=" + nombreEstacion + ", fecha=" + fecha + " ]";
    }
    
}
