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
@Table(name = "tarjeta_estacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarjetaEstacion.findAll", query = "SELECT t FROM TarjetaEstacion t"),
    @NamedQuery(name = "TarjetaEstacion.findByPinTarjeta", query = "SELECT t FROM TarjetaEstacion t WHERE t.tarjetaEstacionPK.pinTarjeta = :pinTarjeta"),
    @NamedQuery(name = "TarjetaEstacion.findByNombreEstacion", query = "SELECT t FROM TarjetaEstacion t WHERE t.tarjetaEstacionPK.nombreEstacion = :nombreEstacion"),
    @NamedQuery(name = "TarjetaEstacion.findByFecha", query = "SELECT t FROM TarjetaEstacion t WHERE t.tarjetaEstacionPK.fecha = :fecha"),
    @NamedQuery(name = "TarjetaEstacion.findByHora", query = "SELECT t FROM TarjetaEstacion t WHERE t.tarjetaEstacionPK.hora = :hora")})
public class TarjetaEstacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TarjetaEstacionPK tarjetaEstacionPK;
    @JoinColumn(name = "pin_tarjeta", referencedColumnName = "pin_tarjeta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tarjeta tarjeta;
    @JoinColumn(name = "nombre_estacion", referencedColumnName = "nombre_estacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estacion estacion;

    public TarjetaEstacion() {
    }

    public TarjetaEstacion(TarjetaEstacionPK tarjetaEstacionPK) {
        this.tarjetaEstacionPK = tarjetaEstacionPK;
    }

    public TarjetaEstacion(String pinTarjeta, String nombreEstacion, Date fecha, Date hora) {
        this.tarjetaEstacionPK = new TarjetaEstacionPK(pinTarjeta, nombreEstacion, fecha, hora);
    }

    public TarjetaEstacionPK getTarjetaEstacionPK() {
        return tarjetaEstacionPK;
    }

    public void setTarjetaEstacionPK(TarjetaEstacionPK tarjetaEstacionPK) {
        this.tarjetaEstacionPK = tarjetaEstacionPK;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Estacion getEstacion() {
        return estacion;
    }

    public void setEstacion(Estacion estacion) {
        this.estacion = estacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tarjetaEstacionPK != null ? tarjetaEstacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarjetaEstacion)) {
            return false;
        }
        TarjetaEstacion other = (TarjetaEstacion) object;
        if ((this.tarjetaEstacionPK == null && other.tarjetaEstacionPK != null) || (this.tarjetaEstacionPK != null && !this.tarjetaEstacionPK.equals(other.tarjetaEstacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.TarjetaEstacion[ tarjetaEstacionPK=" + tarjetaEstacionPK + " ]";
    }
    
}
