/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author CM
 */
public class UsuarioDaoImpl implements UsuarioDao{

    @Override
    public Usuario findByUsuario(Usuario usuario) {
        Usuario model=null;
        Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = sf.beginTransaction();
        String sql = "FROM Usuario WHERE usuario = '"+usuario.getUsuario()+"'";
        try {
            model = (Usuario) sf.createQuery(sql).uniqueResult();            
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
       
        return model;
    }

    @Override
    public Usuario login(Usuario usuario) {
        Usuario model = findByUsuario(usuario);
        if (model != null) {
            if (!usuario.getClave().equals(model.getClave())) {
                model = null;
            }
        }
        return model;
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> listado = null;
        Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = sf.beginTransaction();
        String sql = "FROM Usuario u left join fetch u.rol";
        try {
            listado =  sf.createQuery(sql).list();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        return listado;
    }

    @Override
    public boolean create(Usuario usuario) {
        boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            sesion.save(usuario);
            sesion.beginTransaction().commit();
            flag = true;
        } catch (Exception e) {
            flag = false;
            sesion.beginTransaction().rollback();
        }
        return flag;
    }

    @Override
    public boolean update(Usuario usuario) {
        boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            Usuario usuariodb = (Usuario) sesion.load(Usuario.class, usuario.getId());
            usuariodb.setEmail(usuario.getEmail());
            usuariodb.setUsuario(usuario.getUsuario());
            usuariodb.setRol(usuario.getRol());
            sesion.update(usuariodb);
            sesion.beginTransaction().commit();
            flag = true;
        } catch (Exception e) {
            flag = false;
            sesion.beginTransaction().rollback();
        }
        return flag;
    }

    @Override
    public boolean delete(Integer id) {
        boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            Usuario usuario = (Usuario) sesion.load(Usuario.class, id);
            sesion.delete(usuario);
            sesion.beginTransaction().commit();
            flag = true;
        } catch (Exception e) {
            flag = false;
            sesion.beginTransaction().rollback();
        }
        return flag;
    }
    
}
