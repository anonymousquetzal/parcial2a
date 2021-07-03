/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endpoint;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import servicio.ProductoServicio;

/**
 *
 * @author Leticia Boch
 */
@Path("/factura-detalle")
public class FacturaDetalle {
    
    @Inject
    private ProductoServicio productoService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findFacturaDetalle() {
        
        var facturaDetalleList = this.productoService.buscarFacturaDetalle();
        return Response.ok(facturaDetalleList).build();
        
    }
    
}
