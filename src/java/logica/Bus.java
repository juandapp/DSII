/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juandapp
 */
@Entity
@Table(name = "bus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bus.findAll", query = "SELECT b FROM Bus b"),
    @NamedQuery(name = "Bus.findByNumerochasisBus", query = "SELECT b FROM Bus b WHERE b.numerochasisBus = :numerochasisBus"),
    @NamedQuery(name = "Bus.findByPlacaBus", query = "SELECT b FROM Bus b WHERE b.placaBus = :placaBus"),
    @NamedQuery(name = "Bus.findByNumeropasajerosBus", query = "SELECT b FROM Bus b WHERE b.numeropasajerosBus = :numeropasajerosBus"),
    @NamedQuery(name = "Bus.findByTipoBus", query = "SELECT b FROM Bus b WHERE b.tipoBus = :tipoBus")})
public class Bus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "numerochasis_bus")
    private String numerochasisBus;
    @Size(max = 50)
    @Column(name = "placa_bus")
    private String placaBus;
    @Size(max = 50)
    @Column(name = "numeropasajeros_bus")
    private String numeropasajerosBus;
    @Size(max = 50)
    @Column(name = "tipo_bus")
    private String tipoBus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bus")
    private List<ConductorBus> conductorBusList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bus")
    private List<BusRuta> busRutaList;

    public Bus() {
    }

    public Bus(String numerochasisBus) {
        this.numerochasisBus = numerochasisBus;
    }

    public String getNumerochasisBus() {
        return numerochasisBus;
    }

    public void setNumerochasisBus(String numerochasisBus) {
        this.numerochasisBus = numerochasisBus;
    }

    public String getPlacaBus() {
        return placaBus;
    }

    public void setPlacaBus(String placaBus) {
        this.placaBus = placaBus;
    }

    public String getNumeropasajerosBus() {
        return numeropasajerosBus;
    }

    public void setNumeropasajerosBus(String numeropasajerosBus) {
        this.numeropasajerosBus = numeropasajerosBus;
    }

    public String getTipoBus() {
        return tipoBus;
    }

    public void setTipoBus(String tipoBus) {
        this.tipoBus = tipoBus;
    }

    @XmlTransient
    public List<ConductorBus> getConductorBusList() {
        return conductorBusList;
    }

    public void setConductorBusList(List<ConductorBus> conductorBusList) {
        this.conductorBusList = conductorBusList;
    }

    @XmlTransient
    public List<BusRuta> getBusRutaList() {
        return busRutaList;
    }

    public void setBusRutaList(List<BusRuta> busRutaList) {
        this.busRutaList = busRutaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerochasisBus != null ? numerochasisBus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bus)) {
            return false;
        }
        Bus other = (Bus) object;
        if ((this.numerochasisBus == null && other.numerochasisBus != null) || (this.numerochasisBus != null && !this.numerochasisBus.equals(other.numerochasisBus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.Bus[ numerochasisBus=" + numerochasisBus + " ]";
    }
    
}
