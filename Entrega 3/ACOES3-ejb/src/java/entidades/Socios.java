/*
 * Sistemas de Información para Intenet
 * Grupo G
 * Universidad de Málaga
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

/**
 *
 * @author Jesús
 */
@Entity
public class Socios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private String estado;
    private String direccion;
    private String poblacion;
    private int codPostal;
    private String provincia;
    private String telefono;
    private String correo;
    private String sector;
    private String certificado;
    @Temporal(TemporalType.TIMESTAMP)    
    private Date FechaAlta;
    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaBaja;
    private String observaciones;
    @OneToOne(cascade = CascadeType.REMOVE)
    private Usuario usuario;
    @ManyToMany
    @JoinTable(name="CUOTA_SOCIOS", joinColumns = @JoinColumn(name = "SOCIO_FK"), inverseJoinColumns = 
            @JoinColumn(name = "CUOTA_FK"))
    private List<Cuota> cuota;
    @OneToMany(mappedBy="numSocio", cascade = CascadeType.REMOVE)
    private List<Apadrinamiento> apadr;
    
    public Socios (String nombre,String apellido,Long id,String estado,String direccion,String poblacion,int codPostal,
             String provincia, String telefono,String correo,String sector,String certificado, Date FechaAlta, Date FechaBaja,
            String observaciones,Usuario usuario){
            
            this.nombre = nombre;
            this.apellido = apellido;
            this.id = id;
            this.estado = estado;
            this.direccion = direccion;
            this.poblacion = poblacion;
            this.codPostal = codPostal;
            this.provincia = provincia;
            this.telefono = telefono;
            this.correo = correo;
            this.sector = sector;
            this.certificado = certificado;
            this.FechaAlta = FechaAlta;
            this.FechaBaja = FechaBaja;
            this.observaciones = observaciones;
            this.usuario = usuario;
    }

    public Socios() {
    }

    
    public Socios(String nombre, long id){
        this.nombre=nombre;
        this.id=id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Apadrinamiento> getApadr() {
        return apadr;
    }

    public void setApadr(List<Apadrinamiento> apadr) {
        this.apadr = apadr;
    }

    public List<Cuota> getCuota() {
        return cuota;
    }

    public void setCuota(List<Cuota> cuota) {
        this.cuota = cuota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Date getFechaAlta() {
        return FechaAlta;
    }

    public void setFechaAlta(Date FechaAlta) {
        this.FechaAlta = FechaAlta;
    }

    public Date getFechaBaja() {
        return FechaBaja;
    }

    public void setFechaBaja(Date FechaBaja) {
        this.FechaBaja = FechaBaja;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Socios)) {
            return false;
        }
        Socios other = (Socios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre+ " " + apellido;
    }
    
    //OBTENER APADRINAMIENTOS DE 1 UNICO SOCIO
    public List<Apadrinamiento> getApadbyID(){
        List <Apadrinamiento> aux = new ArrayList<>();
        for(int i=0; i<apadr.size();i++){
            if(id==apadr.get(i).getNumSocio().id){
                aux.add(apadr.get(i));
            }
        }
        return aux;
        
    }
    
    public List<Envio> getEnviosDeSocio(List<Apadrinamiento> l){
        
        List <Envio> e = new ArrayList<>();
        
        for(int i=0; i<l.size(); i++){
            if(!(l.get(i).getCodEnvio().isEmpty())){
                for(int j=0; j<l.get(i).getCodEnvio().size();j++){
                    e.add(l.get(i).getCodEnvio().get(j));
                }
            }
        }
        return e;
    }
    
}
