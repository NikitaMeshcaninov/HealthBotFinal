package engine;


import entities.Conection;
import entities.Disease;
import entities.Symptom;
import entities.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import utils.HibernateUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HealthEngine {

    public void addDisease() throws SQLException {
        HibernateUtil.init();
        Disease disease = new Disease();

        System.out.println("введите название болезни");
        Scanner sc1 = new Scanner(System.in);
        disease.setDiseaseName(sc1.next());

        System.out.println("введите синонимы болезни");
        Scanner sc2 = new Scanner(System.in);
        disease.setDiseaseNameSynonyms(sc2.next());

        System.out.println("Введите тип специалиста");
        Scanner sc3 = new Scanner(System.in);
        disease.setSpecialistType(sc3.next());

        DiseaseDAOimpl diseaseDAOimpl = new DiseaseDAOimpl();
        diseaseDAOimpl.addDisease(disease);
        String id = Long.toString(disease.getDiseaseID());
        System.out.println("ID новой болезни : " + id);

    }

    public void delDiseaseById() {
        HibernateUtil.init();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        System.out.println("Введите тип ID болезни которую хотите удалить");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        session.createQuery("DELETE FROM Disease where diseaseID = " + id).executeUpdate();
        session.getTransaction().commit();
    }

    public void addSymptom() throws SQLException {
        HibernateUtil.init();
        Symptom symptom = new Symptom();
        System.out.println("Введите название симптома");
        Scanner sc1 = new Scanner(System.in);
        symptom.setSymptomName(sc1.next());
        System.out.println("введите синонимы симптомов");
        Scanner sc2 = new Scanner(System.in);
        symptom.setSymptomSynonyms(sc2.next());
        SymptomDAOimpl symptomDAOimpl = new SymptomDAOimpl();
        symptomDAOimpl.addSymptom(symptom);
        String id = Long.toString(symptom.getSymptomId());
        System.out.println("id нового симптома: " + id);
    }

    public void delSymptomById() {
        HibernateUtil.init();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        System.out.println("Введите номер удаляемого симптома");
        Scanner sc = new Scanner(System.in);
        session.createQuery("DELETE FROM Symptom where symptomId = " + sc.next()).executeUpdate();
        session.getTransaction().commit();
    }

    public void addConection() throws SQLException {
        Symptom symptom = null;
        HibernateUtil.init();
        Conection conection = new Conection();
        System.out.println("Введите id болезни которую хотите связать");
        Scanner sc1 = new Scanner(System.in);
        Integer i1 = new Integer(sc1.next());
        conection.setDiseaseid(i1);
        SymptomDAOimpl symptomDAOimpl = new SymptomDAOimpl();
        System.out.println("введте название болезни, которую хотите сязать");
        Scanner sc2 = new Scanner(System.in);
        symptom = symptomDAOimpl.getSymptomByName(sc2.next());
        conection.setSymptomid((int) symptom.getSymptomId());
        ConectionDAOimpl conectionDAOimpl = new ConectionDAOimpl();
        conectionDAOimpl.addConection(conection);
    }

    public List<Disease> findUserDisease(ArrayList<String> symptomNameList) {
        Session session = null;
        List t = null;
        String symptomName = null;

        if (!symptomNameList.get(0).equals(""))
            symptomName = "'" + symptomNameList.get(0) + "'";


        for (int i = 1; symptomNameList.size() > i; i++) {
            if (!symptomNameList.get(i).equals("")){
            symptomName = symptomName + " OR symptom.symptomName = '" + symptomNameList.get(i) + "'";}
        }
        System.out.println(symptomName.toString());
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            t = session.createSQLQuery("SELECT disease.diseaseID, " +
                    "disease.diseaseName,disease.d" +
                    "iseaseNameSynonyms," +
                    "disease.specialistType " +
                    "from Symptom " +
                    "INNER JOIN conection " +
                    "ON symptom.symptomid = conection.symptomid " +
                    "INNER JOIN disease ON conection.diseaseid = disease.diseaseID " +
                    "WHERE symptom.symptomName =" + symptomName)
                    .setResultTransformer(Transformers.aliasToBean(Disease.class))
                    .list();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return t;
    }

    public static String md5Apache(String st) {
        String md5Hex = DigestUtils.md5Hex(st);

        return md5Hex;
    }

    public void addUser() throws SQLException {
        HibernateUtil.init();
        User user = new User();
        System.out.println("Введите email");
        Scanner sc1 = new Scanner(System.in);
        user.setEmail(sc1.next());
        System.out.println("Введите пароль");
        Scanner sc2 = new Scanner(System.in);
        user.setPassword(md5Apache(sc2.next()));
        System.out.println("Админ ? (true/false)");
        Scanner sc3 = new Scanner(System.in);
        user.setAdmin(sc3.nextBoolean());
        System.out.println(user.toString());
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        userDaoImpl.addUser(user);
        String id = Long.toString(user.getId());
        System.out.println("id нового пользователя: " + id);
    }
}

