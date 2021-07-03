/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *
 * @author Leticia Boch
 */
@Entity
@Table(name = "producto")
@Data
@EqualsAndHashCode(of = "productoid")
@ToString(of = "productoid")
public class Producto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productoid")
    private Integer productoid;
    
    @Column(name = "codigo")
    private String codigo;
    
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "volumen")
    private BigDecimal volumen;
    
    @Column(name = "peso")
    private BigDecimal peso;
    
    @Column(name = "alto")
    private BigDecimal alto;
    
    @Column(name = "ancho")
    private BigDecimal ancho;
    
    @Column(name = "profundidad")
    private BigDecimal profundidad;
    
    @Column(name = "preciobase")
    private BigDecimal precioBase;
    
    @Column(name = "preciocosto")
    private BigDecimal precioCosto;
    
    @Column(name = "estado")
    private String estado;
    
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FacturaDetalle> facturaDetalleList;
    
    @ManyToMany(mappedBy = "productoSet")
    private Set<Cliente> clienteSet;
    
}
