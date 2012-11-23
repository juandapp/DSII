/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juandapp
 */
@Entity
@Table(name = "conductor_bus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConductorBus.findAll", query = "SELECT c FROM ConductorBus c"),
    @NamedQuery(name = "ConductorBus.findByIdentificacionConductor", query = "SELECT c FROM ConductorBus c WHERE c.conductorBusPK.identificacionConductor = :identificacionConductor"),
    @NamedQuery(name = "ConductorBus.findByNumerochasisBus", query = "SELECT c FROM ConductorBus c WHERE c.conductorBusPK.numerochasisBus = :numerochasisBus"),
    @NamedQuery(name = "ConductorBus.findByFecha", query = "SELECT c FROM ConductorBus c WHERE c.conductorBusPK.fecha = :fecha"),
    @NamedQuery(name = "ConductorBus.findByHorario", query = "SELECT c FROM ConductorBus c WHERE c.horario = :horario")})
public class ConductorBus implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConductorBusPK conductorBusPK;
    @Size(max = 50)
    @Column(name = "horario")
    private String horario;
    @JoinColumn(name = "identificacion_conductor", referencedColumnName = "identificacion_empleado", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empleado empleado;
    @JoinColumn(name = "numerochasis_bus", referencedColumnName = "numerochasis_bus", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bus bus;

    public ConductorBus() {
    }

    public ConductorBus(ConductorBusPK conductorBusPK) {
        this.conductorBusPK = conductorBusPK;
    }

    public ConductorBus(String identificacionConductor, String numerochasisBus, Date fecha) {
        this.conductorBusPK = new ConductorBusPK(identificacionConductor, numerochasisBus, fecha);
    }

    public ConductorBusPK getConductorBusPK() {
        return conductorBusPK;
    }

    public void setConductorBusPK(ConductorBusPK conductorBusPK) {
        this.conductorBusPK = conductorBusPK;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
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
        hash += (conductorBusPK != null ? conductorBusPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConductorBus)) {
            return false;
        }
        ConductorBus other = (ConductorBus) object;
        if ((this.conductorBusPK == null && other.conductorBusPK != null) || (this.conductorBusPK != null && !this.conductorBusPK.equals(other.conductorBusPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.ConductorBus[ conductorBusPK=" + conductorBusPK + " ]";
    }
    
}
