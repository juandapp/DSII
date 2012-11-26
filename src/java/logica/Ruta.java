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
@Table(name = "ruta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ruta.findAll", query = "SELECT r FROM Ruta r"),
    @NamedQuery(name = "Ruta.findByNombreRuta", query = "SELECT r FROM Ruta r WHERE r.nombreRuta = :nombreRuta"),
    @NamedQuery(name = "Ruta.findByNombrerecorridoRuta", query = "SELECT r FROM Ruta r WHERE r.nombrerecorridoRuta = :nombrerecorridoRuta"),
    @NamedQuery(name = "Ruta.findByDescripcionRuta", query = "SELECT r FROM Ruta r WHERE r.descripcionRuta = :descripcionRuta")})
public class Ruta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_ruta")
    private String nombreRuta;
    @Size(max = 50)
    @Column(name = "nombrerecorrido_ruta")
    private String nombrerecorridoRuta;
    @Size(max = 50)
    @Column(name = "descripcion_ruta")
    private String descripcionRuta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ruta")
    private List<BusRuta> busRutaList;

    public Ruta() {
    }

    public Ruta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public String getNombrerecorridoRuta() {
        return nombrerecorridoRuta;
    }

    public void setNombrerecorridoRuta(String nombrerecorridoRuta) {
        this.nombrerecorridoRuta = nombrerecorridoRuta;
    }

    public String getDescripcionRuta() {
        return descripcionRuta;
    }

    public void setDescripcionRuta(String descripcionRuta) {
        this.descripcionRuta = descripcionRuta;
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
        hash += (nombreRuta != null ? nombreRuta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ruta)) {
            return false;
        }
        Ruta other = (Ruta) object;
        if ((this.nombreRuta == null && other.nombreRuta != null) || (this.nombreRuta != null && !this.nombreRuta.equals(other.nombreRuta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreRuta;
    }
    
}
