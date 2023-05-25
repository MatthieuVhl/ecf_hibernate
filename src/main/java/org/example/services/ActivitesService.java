package org.example.services;

import org.example.entities.Activites;
import org.example.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class ActivitesService  extends BaseService implements Repository<Activites> {

    @Override
    public boolean create (Activites o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        return true;
    }



    @Override
    public boolean update (Activites o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete (Activites o) {
        return false;
    }

    @Override
    public Activites findById (int id) {
        Activites activites = null;
        session = sessionFactory.openSession();
        activites = (Activites) session.get(Activites.class,id);
        session.close();
        return activites;
    }

    @Override
    public List<Activites> findAll ( ) {

        List<Activites> activites = null;
        session = sessionFactory.openSession();
        Query<Activites> activitesQuery = session.createQuery("from Activites ");
        activites = activitesQuery.list();
        session.close();
        return activites;
    }
}
