/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.enterprise.context.RequestScoped;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.ZonedDateTime;
import model.Cliente;
import model.Factura;
import model.FacturaDetalle;
import model.Producto;

/**
 *
 * @author Julio Coco
 */
@RequestScoped
public class ProductoServicio implements Serializable {

    public static List<Cliente> paisDatasource = new ArrayList<>();

    List<Cliente> clientesList;
    Cliente cliente;

    List<Factura> facturaList;
    Factura factura;

    List<Producto> productoList;
    Producto producto;

    List<FacturaDetalle> facturaDetalleList;
    FacturaDetalle facturaDetalle;

    public List<Cliente> buscarCliente() {
        //http://localhost:8080/parcial2/v1/clientes
        clientesList = new ArrayList<>();
        cliente = new Cliente();
        cliente.setCodigo("codigo1");
        cliente.setNit("73435708");
        cliente.setNombre("Julio Coco");
        cliente.setDireccion("123 Calle");
        cliente.setLongitud(new BigDecimal("50.00"));
        cliente.setLatitud(new BigDecimal("50.00"));
        cliente.setEstado("Activo");
        cliente.setSaldo(new BigDecimal("100.00"));

        clientesList.add(cliente);

        return clientesList;

    }

    public List<Factura> buscarFactura() {
        facturaList = new ArrayList<>();
        factura = new Factura();
        factura.setNumeroSerie("serie01");
        factura.setEmitidoEl(ZonedDateTime.now(Clock.systemUTC()));
        factura.setClienteID("cliente01");
        factura.setDescripcion("Descripcion vacia");

        facturaList.add(factura);

        return facturaList;

    }

    public List<Producto> buscarProducto() {
        productoList = new ArrayList<>();
        producto = new Producto();
        producto.setCodigo("Codigo01");
        producto.setNombre("Netbeans");
        producto.setVolumen(BigDecimal.ZERO);
        producto.setPeso(BigDecimal.ZERO);
        producto.setAlto(BigDecimal.ZERO);
        producto.setAncho(BigDecimal.ZERO);
        producto.setProfundidad(BigDecimal.ZERO);
        producto.setPrecioBase(BigDecimal.ZERO);
        producto.setPrecioCosto(BigDecimal.ZERO);
        producto.setEstado("Disponible");
        productoList.add(producto);

        return productoList;

    }

    public List<FacturaDetalle> buscarFacturaDetalle() {
        facturaDetalleList = new ArrayList<>();
        facturaDetalle = new FacturaDetalle();
        facturaDetalle.setProductId(001);
        facturaDetalle.setCantidad(new BigDecimal("100"));
        facturaDetalle.setCantidad(new BigDecimal("50"));
        facturaDetalle.setPrecioVenta(BigDecimal.ZERO);
        facturaDetalle.setDescripcion("Descripcin vacia");

        facturaDetalleList.add(facturaDetalle);

        return facturaDetalleList;

    }

    public List<Cliente> buscarProductos() {
        return paisDatasource;
    }

    public void agregarProducto(Cliente producto) {
        producto.setId(paisDatasource.size() + 1);
        paisDatasource.add(producto);
    }

}
