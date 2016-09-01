package Functions;

import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;
import utils.APIHandlerServlet;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by cube on 20.08.2016.
 */
public class Login extends APIHandlerServlet.APIRequestHandler {

    public static final Login instance = new Login();


    public static Login getInstance() {
        return instance;
    }

    private Login() {
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("blablabla","hohoho");
        jsonObject.put("ZZZzzzzZZZZ","ololo");

        return jsonObject;
    }
}
