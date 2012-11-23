/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author juandapp
 */
@Embeddable
public class ReclamoDirectorPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ticket_reclamo")
    private String ticketReclamo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "identificacion_directorestacion")
    private String identificacionDirectorestacion;

    public ReclamoDirectorPK() {
    }

    public ReclamoDirectorPK(String ticketReclamo, String identificacionDirectorestacion) {
        this.ticketReclamo = ticketReclamo;
        this.identificacionDirectorestacion = identificacionDirectorestacion;
    }

    public String getTicketReclamo() {
        return ticketReclamo;
    }

    public void setTicketReclamo(String ticketReclamo) {
        this.ticketReclamo = ticketReclamo;
    }

    public String getIdentificacionDirectorestacion() {
        return identificacionDirectorestacion;
    }

    public void setIdentificacionDirectorestacion(String identificacionDirectorestacion) {
        this.identificacionDirectorestacion = identificacionDirectorestacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketReclamo != null ? ticketReclamo.hashCode() : 0);
        hash += (identificacionDirectorestacion != null ? identificacionDirectorestacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReclamoDirectorPK)) {
            return false;
        }
        ReclamoDirectorPK other = (ReclamoDirectorPK) object;
        if ((this.ticketReclamo == null && other.ticketReclamo != null) || (this.ticketReclamo != null && !this.ticketReclamo.equals(other.ticketReclamo))) {
            return false;
        }
        if ((this.identificacionDirectorestacion == null && other.identificacionDirectorestacion != null) || (this.identificacionDirectorestacion != null && !this.identificacionDirectorestacion.equals(other.identificacionDirectorestacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.ReclamoDirectorPK[ ticketReclamo=" + ticketReclamo + ", identificacionDirectorestacion=" + identificacionDirectorestacion + " ]";
    }
    
}
