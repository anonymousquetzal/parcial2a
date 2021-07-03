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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @code Aqui va estar encapsulado el template para un producto
 * @version 0.1
 * https://github.com/anonymousquetzal/parcial2a.git
 * https://github.com/anonymousquetzal/parcial2b.git
 * @author Julio Coco
 */
@Entity
@Table(name = "cliente")
@Data
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clienteid")
    private Integer id;
    
    @Column(name = "codigo")
    private String codigo;
    
    @Column(name = "nit")
    private String nit;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "direccion")
    private String direccion;
    
    private BigDecimal longitud;
    
    private BigDecimal latitud;
    
    @Column(name = "saldo")
    private BigDecimal saldo;
    
    @Column(name = "estado")
    private String estado;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Factura> facturaList;
    
    @ManyToMany()
    @JoinTable(
            name = "cliente_producto",
            joinColumns = @JoinColumn(name = "clienteid", referencedColumnName = "clienteid"),//clienetid
            inverseJoinColumns = @JoinColumn(name = "productoid", referencedColumnName = "productoid")//productID
    )
    private Set<Producto> productoSet;
        
}
