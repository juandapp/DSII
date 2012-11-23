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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juandapp
 */
@Entity
@Table(name = "tarjeta_personalizada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarjetaPersonalizada.findAll", query = "SELECT t FROM TarjetaPersonalizada t"),
    @NamedQuery(name = "TarjetaPersonalizada.findByPinPersonalizada", query = "SELECT t FROM TarjetaPersonalizada t WHERE t.pinPersonalizada = :pinPersonalizada"),
    @NamedQuery(name = "TarjetaPersonalizada.findByFecha", query = "SELECT t FROM TarjetaPersonalizada t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "TarjetaPersonalizada.findByCosto", query = "SELECT t FROM TarjetaPersonalizada t WHERE t.costo = :costo")})
public class TarjetaPersonalizada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pin_personalizada")
    private String pinPersonalizada;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "costo")
    private Integer costo;
    @JoinColumn(name = "pin_personalizada", referencedColumnName = "pin_tarjeta", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Tarjeta tarjeta;
    @JoinColumn(name = "identificacion_pasajero", referencedColumnName = "identificacion_pasajero")
    @ManyToOne
    private Pasajero identificacionPasajero;
    @JoinColumn(name = "identificacion_auxservicio", referencedColumnName = "identificacion_empleado")
    @ManyToOne
    private Empleado identificacionAuxservicio;

    public TarjetaPersonalizada() {
    }

    public TarjetaPersonalizada(String pinPersonalizada) {
        this.pinPersonalizada = pinPersonalizada;
    }

    public String getPinPersonalizada() {
        return pinPersonalizada;
    }

    public void setPinPersonalizada(String pinPersonalizada) {
        this.pinPersonalizada = pinPersonalizada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Pasajero getIdentificacionPasajero() {
        return identificacionPasajero;
    }

    public void setIdentificacionPasajero(Pasajero identificacionPasajero) {
        this.identificacionPasajero = identificacionPasajero;
    }

    public Empleado getIdentificacionAuxservicio() {
        return identificacionAuxservicio;
    }

    public void setIdentificacionAuxservicio(Empleado identificacionAuxservicio) {
        this.identificacionAuxservicio = identificacionAuxservicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pinPersonalizada != null ? pinPersonalizada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarjetaPersonalizada)) {
            return false;
        }
        TarjetaPersonalizada other = (TarjetaPersonalizada) object;
        if ((this.pinPersonalizada == null && other.pinPersonalizada != null) || (this.pinPersonalizada != null && !this.pinPersonalizada.equals(other.pinPersonalizada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.TarjetaPersonalizada[ pinPersonalizada=" + pinPersonalizada + " ]";
    }
    
}
