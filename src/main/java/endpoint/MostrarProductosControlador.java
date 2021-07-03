/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endpoint;

import java.io.Serializable;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import model.Cliente;
import servicio.ProductoServicio;

/**
 *
 * @author Julio Coco
 */
@Named
@ViewScoped
public class MostrarProductosControlador implements Serializable {
    @Inject 
    private ProductoServicio paisServicio;
    
    private List<Cliente> productoList;

        
    @PostConstruct
    public void init() {
        this.productoList = this.paisServicio.buscarProductos();
    }

    public List<Cliente> getProductoList() {
        return productoList;
    }
    
    
}
