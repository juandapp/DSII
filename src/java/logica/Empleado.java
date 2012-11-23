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
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByIdentificacionEmpleado", query = "SELECT e FROM Empleado e WHERE e.identificacionEmpleado = :identificacionEmpleado"),
    @NamedQuery(name = "Empleado.findByNombreEmpleado", query = "SELECT e FROM Empleado e WHERE e.nombreEmpleado = :nombreEmpleado"),
    @NamedQuery(name = "Empleado.findByDireccionEmpleado", query = "SELECT e FROM Empleado e WHERE e.direccionEmpleado = :direccionEmpleado"),
    @NamedQuery(name = "Empleado.findByTelefonoEmpleado", query = "SELECT e FROM Empleado e WHERE e.telefonoEmpleado = :telefonoEmpleado"),
    @NamedQuery(name = "Empleado.findByEmailEmpleado", query = "SELECT e FROM Empleado e WHERE e.emailEmpleado = :emailEmpleado"),
    @NamedQuery(name = "Empleado.findByTipoEmpleado", query = "SELECT e FROM Empleado e WHERE e.tipoEmpleado = :tipoEmpleado"),
    @NamedQuery(name = "Empleado.findByPasswordEmpleado", query = "SELECT e FROM Empleado e WHERE e.passwordEmpleado = :passwordEmpleado")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "identificacion_empleado")
    private String identificacionEmpleado;
    @Size(max = 50)
    @Column(name = "nombre_empleado")
    private String nombreEmpleado;
    @Size(max = 50)
    @Column(name = "direccion_empleado")
    private String direccionEmpleado;
    @Size(max = 50)
    @Column(name = "telefono_empleado")
    private String telefonoEmpleado;
    @Size(max = 50)
    @Column(name = "email_empleado")
    private String emailEmpleado;
    @Size(max = 50)
    @Column(name = "tipo_empleado")
    private String tipoEmpleado;
    @Size(max = 50)
    @Column(name = "password_empleado")
    private String passwordEmpleado;
    @OneToMany(mappedBy = "identificacionAuxservicio")
    private List<TarjetaPersonalizada> tarjetaPersonalizadaList;
    @OneToMany(mappedBy = "identificacionAuxservicio")
    private List<Reclamo> reclamoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<ConductorBus> conductorBusList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<ReclamoDirectorestacion> reclamoDirectorestacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<Recarga> recargaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<EstacionDirectorestacion> estacionDirectorestacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<EstacionAuxservicio> estacionAuxservicioList;

    public Empleado() {
    }

    public Empleado(String identificacionEmpleado) {
        this.identificacionEmpleado = identificacionEmpleado;
    }

    public String getIdentificacionEmpleado() {
        return identificacionEmpleado;
    }

    public void setIdentificacionEmpleado(String identificacionEmpleado) {
        this.identificacionEmpleado = identificacionEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getDireccionEmpleado() {
        return direccionEmpleado;
    }

    public void setDireccionEmpleado(String direccionEmpleado) {
        this.direccionEmpleado = direccionEmpleado;
    }

    public String getTelefonoEmpleado() {
        return telefonoEmpleado;
    }

    public void setTelefonoEmpleado(String telefonoEmpleado) {
        this.telefonoEmpleado = telefonoEmpleado;
    }

    public String getEmailEmpleado() {
        return emailEmpleado;
    }

    public void setEmailEmpleado(String emailEmpleado) {
        this.emailEmpleado = emailEmpleado;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public String getPasswordEmpleado() {
        return passwordEmpleado;
    }

    public void setPasswordEmpleado(String passwordEmpleado) {
        this.passwordEmpleado = passwordEmpleado;
    }

    @XmlTransient
    public List<TarjetaPersonalizada> getTarjetaPersonalizadaList() {
        return tarjetaPersonalizadaList;
    }

    public void setTarjetaPersonalizadaList(List<TarjetaPersonalizada> tarjetaPersonalizadaList) {
        this.tarjetaPersonalizadaList = tarjetaPersonalizadaList;
    }

    @XmlTransient
    public List<Reclamo> getReclamoList() {
        return reclamoList;
    }

    public void setReclamoList(List<Reclamo> reclamoList) {
        this.reclamoList = reclamoList;
    }

    @XmlTransient
    public List<ConductorBus> getConductorBusList() {
        return conductorBusList;
    }

    public void setConductorBusList(List<ConductorBus> conductorBusList) {
        this.conductorBusList = conductorBusList;
    }

    @XmlTransient
    public List<ReclamoDirectorestacion> getReclamoDirectorestacionList() {
        return reclamoDirectorestacionList;
    }

    public void setReclamoDirectorestacionList(List<ReclamoDirectorestacion> reclamoDirectorestacionList) {
        this.reclamoDirectorestacionList = reclamoDirectorestacionList;
    }

    @XmlTransient
    public List<Recarga> getRecargaList() {
        return recargaList;
    }

    public void setRecargaList(List<Recarga> recargaList) {
        this.recargaList = recargaList;
    }

    @XmlTransient
    public List<EstacionDirectorestacion> getEstacionDirectorestacionList() {
        return estacionDirectorestacionList;
    }

    public void setEstacionDirectorestacionList(List<EstacionDirectorestacion> estacionDirectorestacionList) {
        this.estacionDirectorestacionList = estacionDirectorestacionList;
    }

    @XmlTransient
    public List<EstacionAuxservicio> getEstacionAuxservicioList() {
        return estacionAuxservicioList;
    }

    public void setEstacionAuxservicioList(List<EstacionAuxservicio> estacionAuxservicioList) {
        this.estacionAuxservicioList = estacionAuxservicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificacionEmpleado != null ? identificacionEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.identificacionEmpleado == null && other.identificacionEmpleado != null) || (this.identificacionEmpleado != null && !this.identificacionEmpleado.equals(other.identificacionEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.Empleado[ identificacionEmpleado=" + identificacionEmpleado + " ]";
    }
    
}
