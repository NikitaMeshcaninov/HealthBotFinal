package main.java.engine;




import main.java.entities.Conection;

import java.sql.SQLException;

/**
 * Created by Nikita on 29.07.2016.
 */
public interface ConectionDAO {
    void addConection(Conection conection) throws SQLException;

    void delConection(Conection conection) throws SQLException;


}
