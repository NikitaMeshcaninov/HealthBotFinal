package Functions;

import engine.HealthEngine;
import entities.Disease;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;
import utils.APIHandlerServlet;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cube on 20.08.2016.
 */
public class Login extends APIHandlerServlet.APIRequestHandler {

    public static final Login instance = new Login();

    final static Logger logger = Logger.getLogger(Login.class);

    public static Login getInstance() {
        return instance;
    }

    private Login() {
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {

        JSONObject jsonObject = new JSONObject();

        logger.info("!!!! Login from HTTP!!!! " + request.getParameter("login"));

        jsonObject.put("resp", "some resp from login");

        return jsonObject;
    }
}
