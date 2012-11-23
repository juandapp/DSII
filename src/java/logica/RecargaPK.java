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
public class RecargaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pin_tarjeta")
    private String pinTarjeta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "identificacion_auxservicio")
    private String identificacionAuxservicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;

    public RecargaPK() {
    }

    public RecargaPK(String pinTarjeta, String identificacionAuxservicio, Date fecha, Date hora) {
        this.pinTarjeta = pinTarjeta;
        this.identificacionAuxservicio = identificacionAuxservicio;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getPinTarjeta() {
        return pinTarjeta;
    }

    public void setPinTarjeta(String pinTarjeta) {
        this.pinTarjeta = pinTarjeta;
    }

    public String getIdentificacionAuxservicio() {
        return identificacionAuxservicio;
    }

    public void setIdentificacionAuxservicio(String identificacionAuxservicio) {
        this.identificacionAuxservicio = identificacionAuxservicio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pinTarjeta != null ? pinTarjeta.hashCode() : 0);
        hash += (identificacionAuxservicio != null ? identificacionAuxservicio.hashCode() : 0);
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (hora != null ? hora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecargaPK)) {
            return false;
        }
        RecargaPK other = (RecargaPK) object;
        if ((this.pinTarjeta == null && other.pinTarjeta != null) || (this.pinTarjeta != null && !this.pinTarjeta.equals(other.pinTarjeta))) {
            return false;
        }
        if ((this.identificacionAuxservicio == null && other.identificacionAuxservicio != null) || (this.identificacionAuxservicio != null && !this.identificacionAuxservicio.equals(other.identificacionAuxservicio))) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if ((this.hora == null && other.hora != null) || (this.hora != null && !this.hora.equals(other.hora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.RecargaPK[ pinTarjeta=" + pinTarjeta + ", identificacionAuxservicio=" + identificacionAuxservicio + ", fecha=" + fecha + ", hora=" + hora + " ]";
    }
    
}
