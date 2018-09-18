/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marioh.ramirez
 */
@Entity
@Table(name = "TRANSACCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaccion.findAll", query = "SELECT t FROM Transaccion t")
    , @NamedQuery(name = "Transaccion.findById", query = "SELECT t FROM Transaccion t WHERE t.id = :id")
    , @NamedQuery(name = "Transaccion.findByNumTarjeta", query = "SELECT t FROM Transaccion t WHERE t.numTarjeta = :numTarjeta")
    , @NamedQuery(name = "Transaccion.findByCvv", query = "SELECT t FROM Transaccion t WHERE t.cvv = :cvv")
    , @NamedQuery(name = "Transaccion.findByFechaVencimiento", query = "SELECT t FROM Transaccion t WHERE t.fechaVencimiento = :fechaVencimiento")
    , @NamedQuery(name = "Transaccion.findByValorTransaccion", query = "SELECT t FROM Transaccion t WHERE t.valorTransaccion = :valorTransaccion")})
public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
//    @Column(name = "Num_Tarjeta")
//    private Integer numTarjeta;
    @Column(name = "CVV")
    private Integer cvv;
    @Column(name = "Fecha_Vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Column(name = "Valor_Transaccion")
    private Integer valorTransaccion;
    @JoinColumn(name = "CLIENTE", referencedColumnName = "CLIENTE")
    @ManyToOne(optional = false)
    private Cliente numTarjeta;

    public Transaccion() {
    }

    public Transaccion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getNumTarjeta(){return this.numTarjeta.getNumTarjeta();}
    public void setNumTarjeta(Integer code){this.numTarjeta=new Cliente(code);}
//
//    public Integer getNumTarjeta() {
//        return numTarjeta;
//    }
//
//    public void setNumTarjeta(Integer numTarjeta) {
//        this.numTarjeta = numTarjeta;
//    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getValorTransaccion() {
        return valorTransaccion;
    }

    public void setValorTransaccion(Integer valorTransaccion) {
        this.valorTransaccion = valorTransaccion;
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
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.Transaccion[ id=" + id + " ]";
    }
    
}
