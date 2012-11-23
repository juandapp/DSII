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
public class ConductorBusPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "identificacion_conductor")
    private String identificacionConductor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "numerochasis_bus")
    private String numerochasisBus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public ConductorBusPK() {
    }

    public ConductorBusPK(String identificacionConductor, String numerochasisBus, Date fecha) {
        this.identificacionConductor = identificacionConductor;
        this.numerochasisBus = numerochasisBus;
        this.fecha = fecha;
    }

    public String getIdentificacionConductor() {
        return identificacionConductor;
    }

    public void setIdentificacionConductor(String identificacionConductor) {
        this.identificacionConductor = identificacionConductor;
    }

    public String getNumerochasisBus() {
        return numerochasisBus;
    }

    public void setNumerochasisBus(String numerochasisBus) {
        this.numerochasisBus = numerochasisBus;
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
        hash += (identificacionConductor != null ? identificacionConductor.hashCode() : 0);
        hash += (numerochasisBus != null ? numerochasisBus.hashCode() : 0);
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConductorBusPK)) {
            return false;
        }
        ConductorBusPK other = (ConductorBusPK) object;
        if ((this.identificacionConductor == null && other.identificacionConductor != null) || (this.identificacionConductor != null && !this.identificacionConductor.equals(other.identificacionConductor))) {
            return false;
        }
        if ((this.numerochasisBus == null && other.numerochasisBus != null) || (this.numerochasisBus != null && !this.numerochasisBus.equals(other.numerochasisBus))) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.ConductorBusPK[ identificacionConductor=" + identificacionConductor + ", numerochasisBus=" + numerochasisBus + ", fecha=" + fecha + " ]";
    }
    
}
