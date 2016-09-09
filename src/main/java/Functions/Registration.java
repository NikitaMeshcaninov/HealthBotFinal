package Functions;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;
import utils.APIHandlerServlet;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nikita on 01.09.2016.
 */
public class Registration extends APIHandlerServlet.APIRequestHandler {

    public static final Registration instance = new Registration();

    final static Logger logger = Logger.getLogger(Registration.class);

    public static Registration getInstance() {
        return instance;
    }

    private Registration() {
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {

        JSONObject jsonObject = new JSONObject();

        logger.info("!!!! Password from HTTP!!!! " + request.getParameter("password"));

        jsonObject.put("resp", "some resp from login");

        return jsonObject;
    }
}
