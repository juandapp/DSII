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
@Table(name = "recarga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recarga.findAll", query = "SELECT r FROM Recarga r"),
    @NamedQuery(name = "Recarga.findByPinTarjeta", query = "SELECT r FROM Recarga r WHERE r.recargaPK.pinTarjeta = :pinTarjeta"),
    @NamedQuery(name = "Recarga.findByIdentificacionAuxservicio", query = "SELECT r FROM Recarga r WHERE r.recargaPK.identificacionAuxservicio = :identificacionAuxservicio"),
    @NamedQuery(name = "Recarga.findByFecha", query = "SELECT r FROM Recarga r WHERE r.recargaPK.fecha = :fecha"),
    @NamedQuery(name = "Recarga.findByHora", query = "SELECT r FROM Recarga r WHERE r.recargaPK.hora = :hora"),
    @NamedQuery(name = "Recarga.findByValorrecarga", query = "SELECT r FROM Recarga r WHERE r.valorrecarga = :valorrecarga")})
public class Recarga implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecargaPK recargaPK;
    @Column(name = "valorrecarga")
    private Integer valorrecarga;
    @JoinColumn(name = "pin_tarjeta", referencedColumnName = "pin_tarjeta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tarjeta tarjeta;
    @JoinColumn(name = "identificacion_auxservicio", referencedColumnName = "identificacion_empleado", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empleado empleado;

    public Recarga() {
    }

    public Recarga(RecargaPK recargaPK) {
        this.recargaPK = recargaPK;
    }

    public Recarga(String pinTarjeta, String identificacionAuxservicio, Date fecha, Date hora) {
        this.recargaPK = new RecargaPK(pinTarjeta, identificacionAuxservicio, fecha, hora);
    }

    public RecargaPK getRecargaPK() {
        return recargaPK;
    }

    public void setRecargaPK(RecargaPK recargaPK) {
        this.recargaPK = recargaPK;
    }

    public Integer getValorrecarga() {
        return valorrecarga;
    }

    public void setValorrecarga(Integer valorrecarga) {
        this.valorrecarga = valorrecarga;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
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
        hash += (recargaPK != null ? recargaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recarga)) {
            return false;
        }
        Recarga other = (Recarga) object;
        if ((this.recargaPK == null && other.recargaPK != null) || (this.recargaPK != null && !this.recargaPK.equals(other.recargaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.Recarga[ recargaPK=" + recargaPK + " ]";
    }
    
}
