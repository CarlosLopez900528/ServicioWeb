/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.services.ws;

import cl.model.dao.ProductoDAO;
import cl.model.pojos.Productos;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author clopez
 */
@WebService(serviceName = "WebServiceSEGUNDO")
public class WebServiceSEGUNDO {

   @WebMethod(operationName = "ConsultarProducto")
    public List<Productos> ConsultarProducto(@WebParam(name = "codigo") int codigo) {
        ProductoDAO productoDAO = new ProductoDAO();
        ArrayList arr2;
        arr2=(ArrayList)productoDAO.consultarProducto(codigo);
        return arr2;
    }

}
