/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juandapp
 */
@Entity
@Table(name = "reclamo_director")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReclamoDirector.findAll", query = "SELECT r FROM ReclamoDirector r"),
    @NamedQuery(name = "ReclamoDirector.findByTicketReclamo", query = "SELECT r FROM ReclamoDirector r WHERE r.reclamoDirectorPK.ticketReclamo = :ticketReclamo"),
    @NamedQuery(name = "ReclamoDirector.findByIdentificacionDirectorestacion", query = "SELECT r FROM ReclamoDirector r WHERE r.reclamoDirectorPK.identificacionDirectorestacion = :identificacionDirectorestacion")})
public class ReclamoDirector implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReclamoDirectorPK reclamoDirectorPK;

    public ReclamoDirector() {
    }

    public ReclamoDirector(ReclamoDirectorPK reclamoDirectorPK) {
        this.reclamoDirectorPK = reclamoDirectorPK;
    }

    public ReclamoDirector(String ticketReclamo, String identificacionDirectorestacion) {
        this.reclamoDirectorPK = new ReclamoDirectorPK(ticketReclamo, identificacionDirectorestacion);
    }

    public ReclamoDirectorPK getReclamoDirectorPK() {
        return reclamoDirectorPK;
    }

    public void setReclamoDirectorPK(ReclamoDirectorPK reclamoDirectorPK) {
        this.reclamoDirectorPK = reclamoDirectorPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reclamoDirectorPK != null ? reclamoDirectorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReclamoDirector)) {
            return false;
        }
        ReclamoDirector other = (ReclamoDirector) object;
        if ((this.reclamoDirectorPK == null && other.reclamoDirectorPK != null) || (this.reclamoDirectorPK != null && !this.reclamoDirectorPK.equals(other.reclamoDirectorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.ReclamoDirector[ reclamoDirectorPK=" + reclamoDirectorPK + " ]";
    }
    
}
