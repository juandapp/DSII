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
@Table(name = "reclamo_directorestacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReclamoDirectorestacion.findAll", query = "SELECT r FROM ReclamoDirectorestacion r"),
    @NamedQuery(name = "ReclamoDirectorestacion.findByTicketReclamo", query = "SELECT r FROM ReclamoDirectorestacion r WHERE r.reclamoDirectorestacionPK.ticketReclamo = :ticketReclamo"),
    @NamedQuery(name = "ReclamoDirectorestacion.findByIdentificacionDirectorestacion", query = "SELECT r FROM ReclamoDirectorestacion r WHERE r.reclamoDirectorestacionPK.identificacionDirectorestacion = :identificacionDirectorestacion"),
    @NamedQuery(name = "ReclamoDirectorestacion.findByFechaSolucion", query = "SELECT r FROM ReclamoDirectorestacion r WHERE r.fechaSolucion = :fechaSolucion")})
public class ReclamoDirectorestacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReclamoDirectorestacionPK reclamoDirectorestacionPK;
    @Column(name = "fecha_solucion")
    @Temporal(TemporalType.DATE)
    private Date fechaSolucion;
    @JoinColumn(name = "ticket_reclamo", referencedColumnName = "ticket_reclamo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Reclamo reclamo;
    @JoinColumn(name = "identificacion_directorestacion", referencedColumnName = "identificacion_empleado", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empleado empleado;

    public ReclamoDirectorestacion() {
    }

    public ReclamoDirectorestacion(ReclamoDirectorestacionPK reclamoDirectorestacionPK) {
        this.reclamoDirectorestacionPK = reclamoDirectorestacionPK;
    }

    public ReclamoDirectorestacion(String ticketReclamo, String identificacionDirectorestacion) {
        this.reclamoDirectorestacionPK = new ReclamoDirectorestacionPK(ticketReclamo, identificacionDirectorestacion);
    }

    public ReclamoDirectorestacionPK getReclamoDirectorestacionPK() {
        return reclamoDirectorestacionPK;
    }

    public void setReclamoDirectorestacionPK(ReclamoDirectorestacionPK reclamoDirectorestacionPK) {
        this.reclamoDirectorestacionPK = reclamoDirectorestacionPK;
    }

    public Date getFechaSolucion() {
        return fechaSolucion;
    }

    public void setFechaSolucion(Date fechaSolucion) {
        this.fechaSolucion = fechaSolucion;
    }

    public Reclamo getReclamo() {
        return reclamo;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = reclamo;
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
        hash += (reclamoDirectorestacionPK != null ? reclamoDirectorestacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReclamoDirectorestacion)) {
            return false;
        }
        ReclamoDirectorestacion other = (ReclamoDirectorestacion) object;
        if ((this.reclamoDirectorestacionPK == null && other.reclamoDirectorestacionPK != null) || (this.reclamoDirectorestacionPK != null && !this.reclamoDirectorestacionPK.equals(other.reclamoDirectorestacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.ReclamoDirectorestacion[ reclamoDirectorestacionPK=" + reclamoDirectorestacionPK + " ]";
    }
    
}
