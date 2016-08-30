package engine;

import java.sql.SQLException;

/**
 * Created by Nikita on 30.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        HealthEngine h1 = new HealthEngine();

        try {
            h1.addUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
