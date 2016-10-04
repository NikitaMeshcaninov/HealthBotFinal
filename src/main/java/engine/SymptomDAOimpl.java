package main.java.engine;



import main.java.entities.Symptom;
import main.java.utils.HibernateUtil;
import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikita on 27.07.2016.
 */
public class SymptomDAOimpl implements SymptomDAO {
    @Override
    public void addSymptom(Symptom symptom) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(symptom);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    @Override
    public void delSymptom(Symptom symptom) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(symptom);
            session.getTransaction().commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Symptom getSymptomById(Long id) throws SQLException {
        Session session = null;
        Symptom symptom = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            symptom = (Symptom) session.load(Symptom.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return symptom;
    }

    @Override
    public List getAllSymptoms() throws SQLException {
        Session session = null;
        List<Symptom> symptoms = new ArrayList<Symptom>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            symptoms = session.createCriteria(Symptom.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return symptoms;
    }

    @Override
    public void upDateSymptom(Symptom symptom) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(symptom);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Symptom getSymptomByName(String name) throws SQLException {
        Session session = null;
        Symptom t = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            t = (Symptom) session.createQuery("FROM Symptom " +
                    "WHERE symptomName ='" + name + "'").uniqueResult();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return t;
    }
}
