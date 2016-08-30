package engine;

import entities.Disease;
import org.hibernate.mapping.List;

import java.sql.SQLException;

/**
 * Created by Nikita on 27.07.2016.
 */
public interface DiseaseDAO {
    void addDisease(Disease disease) throws SQLException;

    void delDisease(Disease disease) throws SQLException;

    void getDiseaseById(Long id) throws SQLException;

    List getAllDisease() throws SQLException;

    void upDateDisease(Disease disease) throws SQLException;

}
