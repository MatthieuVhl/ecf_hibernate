package org.example.services;


import org.example.entities.Adherent;
import org.example.interfaces.Repository;
import org.hibernate.query.Query;


import java.util.List;

public class AdherentService  extends  BaseService implements Repository<Adherent> {
    @Override
    public boolean create (Adherent o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update (Adherent o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete (Adherent o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public  Adherent findById (int id) {
        Adherent adherent = null;
        session = sessionFactory.openSession();
        adherent = (Adherent) session.get(Adherent.class,id);
        session.close();
        return adherent;
    }


    @Override
    public List<Adherent> findAll ( ) {
      List<Adherent> adherents = null;
      session = sessionFactory.openSession();
        Query<Adherent>adherentQuery = session.createQuery("from Adherent ");
        adherents = adherentQuery.list();
        session.close();
        return adherents;
    }


}
