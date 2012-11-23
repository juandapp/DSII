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
public class EstacionDirectorestacionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "identificacion_directorestacion")
    private String identificacionDirectorestacion;
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

    public EstacionDirectorestacionPK() {
    }

    public EstacionDirectorestacionPK(String identificacionDirectorestacion, String nombreEstacion, Date fecha) {
        this.identificacionDirectorestacion = identificacionDirectorestacion;
        this.nombreEstacion = nombreEstacion;
        this.fecha = fecha;
    }

    public String getIdentificacionDirectorestacion() {
        return identificacionDirectorestacion;
    }

    public void setIdentificacionDirectorestacion(String identificacionDirectorestacion) {
        this.identificacionDirectorestacion = identificacionDirectorestacion;
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
        hash += (identificacionDirectorestacion != null ? identificacionDirectorestacion.hashCode() : 0);
        hash += (nombreEstacion != null ? nombreEstacion.hashCode() : 0);
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstacionDirectorestacionPK)) {
            return false;
        }
        EstacionDirectorestacionPK other = (EstacionDirectorestacionPK) object;
        if ((this.identificacionDirectorestacion == null && other.identificacionDirectorestacion != null) || (this.identificacionDirectorestacion != null && !this.identificacionDirectorestacion.equals(other.identificacionDirectorestacion))) {
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
        return "logica.EstacionDirectorestacionPK[ identificacionDirectorestacion=" + identificacionDirectorestacion + ", nombreEstacion=" + nombreEstacion + ", fecha=" + fecha + " ]";
    }
    
}
