package service;

import entities.Vol;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class VolService {

    // Ajouter un vol
    public void ajouter(Vol vol) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(vol);
        tx.commit();
        session.close();
    }

    // Modifier un vol
    public void modifier(Vol vol) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(vol);
        tx.commit();
        session.close();
    }

    // Supprimer un vol
    public void supprimer(Vol vol) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(vol);
        tx.commit();
        session.close();
    }

    // Lister tous les vols
    public List<Vol> listerTous() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Vol> vols = session.createQuery("FROM Vol").list();
        session.close();
        return vols;
    }

    // Rechercher par destination ou type
    public List<Vol> rechercher(String motCle) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Vol> vols = session.createQuery(
            "FROM Vol WHERE destination LIKE :mc OR typeVol LIKE :mc")
            .setParameter("mc", motCle + "%")
            .list();
        session.close();
        return vols;
    }
}