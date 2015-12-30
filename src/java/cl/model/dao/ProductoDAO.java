package cl.model.dao;

/**
 *
 * @author clopez
 */
import cl.model.pojos.Productos;
import java.util.ArrayList;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import java.util.List;

public class ProductoDAO {

    public List<Productos> consultarProducto(int codigo) {
        Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = sf.beginTransaction();
        ArrayList arr = new ArrayList();
        arr = (ArrayList) sf.createQuery("from Productos where codigo=" + codigo).list();
        t.commit();
        return arr;
    }
    
//    public String consultarProducto2(int codigo) {
//        Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
//        Transaction t = sf.beginTransaction();
//        ArrayList arr = new ArrayList();
//        String txt = sf.createQuery("from Productos where codigo=" + codigo).list();
//        //arr = (ArrayList) sf.createQuery("from Productos where codigo=" + codigo).list();
//        t.commit();
//        return arr.get(0).toS;
//    }
}
