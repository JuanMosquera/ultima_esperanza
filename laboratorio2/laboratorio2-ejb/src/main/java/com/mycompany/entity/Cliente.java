/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marioh.ramirez
 */
@Entity
@Table(name = "CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByNumTarjeta", query = "SELECT c FROM Cliente c WHERE c.numTarjeta = :numTarjeta")
    , @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cliente.findByCorreo", query = "SELECT c FROM Cliente c WHERE c.correo = :correo")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Num_Tarjeta")
    private Integer numTarjeta;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Correo")
    private String correo;

    public Cliente() {
    }

    public Cliente(Integer numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public Cliente(Integer numTarjeta, String nombre, String correo) {
        this.numTarjeta = numTarjeta;
        this.nombre = nombre;
        this.correo = correo;
    }

    public Integer getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(Integer numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numTarjeta != null ? numTarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.numTarjeta == null && other.numTarjeta != null) || (this.numTarjeta != null && !this.numTarjeta.equals(other.numTarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.Cliente[ numTarjeta=" + numTarjeta + " ]";
    }
    
}
