/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juandapp
 */
@Entity
@Table(name = "tarjeta_generica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarjetaGenerica.findAll", query = "SELECT t FROM TarjetaGenerica t"),
    @NamedQuery(name = "TarjetaGenerica.findByPinGenerica", query = "SELECT t FROM TarjetaGenerica t WHERE t.pinGenerica = :pinGenerica")})
public class TarjetaGenerica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pin_generica")
    private String pinGenerica;
    @JoinColumn(name = "pin_generica", referencedColumnName = "pin_tarjeta", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Tarjeta tarjeta;

    public TarjetaGenerica() {
    }

    public TarjetaGenerica(String pinGenerica) {
        this.pinGenerica = pinGenerica;
    }

    public String getPinGenerica() {
        return pinGenerica;
    }

    public void setPinGenerica(String pinGenerica) {
        this.pinGenerica = pinGenerica;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pinGenerica != null ? pinGenerica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarjetaGenerica)) {
            return false;
        }
        TarjetaGenerica other = (TarjetaGenerica) object;
        if ((this.pinGenerica == null && other.pinGenerica != null) || (this.pinGenerica != null && !this.pinGenerica.equals(other.pinGenerica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pinGenerica;
    }
    
}
