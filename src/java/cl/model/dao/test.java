/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.model.dao;

import cl.model.pojos.Productos;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author clopez
 */
public class test {

    public static void main(String[] juan) {
        try {
            Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction t = sf.beginTransaction();
            //Session session = sf.openSession();
            Productos pro = (Productos) sf.load(Productos.class, "114452");
            if (pro != null) {
                System.out.println("Nombre producto " + pro.getNombre());
            } else {
                System.out.println("No");
            }
            t.commit();
        } catch (Exception ex) {
            System.out.println("Error : " + ex.toString());
        }

    }
}
