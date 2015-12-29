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
@WebService(serviceName = "MercaSuperWS")
public class MercaSuperWS {

    /**
     * Web service operation
     * @param codigo
     * @return 
     */
//    @WebMethod(operationName = "ConsultarProducto")
//    public String ConsultarProducto(@WebParam(name = "codigo") int codigo) {
//        ProductoDAO productoDAO = new ProductoDAO();
//        return productoDAO.consultarProducto(codigo);
//    }
    
    @WebMethod(operationName = "ConsultarProducto")
    public List<Productos> ConsultarProducto(@WebParam(name = "codigo") int codigo) {
        ProductoDAO productoDAO = new ProductoDAO();
        ArrayList arr2;
        arr2=(ArrayList)productoDAO.consultarProducto(codigo);
        return arr2;
    }
}
