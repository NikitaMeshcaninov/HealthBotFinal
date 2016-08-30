package engine;



import entities.Symptom;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Nikita on 27.07.2016.
 */
public interface SymptomDAO {
    void addSymptom(Symptom symptom) throws SQLException;

    void delSymptom(Symptom symptom) throws SQLException;

    Symptom getSymptomById(Long id) throws SQLException;

    List getAllSymptoms() throws SQLException;

    void upDateSymptom(Symptom symptom) throws SQLException;
}
