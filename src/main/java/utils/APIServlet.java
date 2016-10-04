package main.java.utils;

import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.annotation.WebServlet;


/**
 * Created by Nikita on 20.08.2016.
 */

public class APIServlet {
    public static final JSONStreamAware ERROR_INCORRECT_REQUEST;

    static {
        JSONObject response = new JSONObject();
        response.put("errorCode", 1);
        response.put("errorDescription", "Incorrect request");
        ERROR_INCORRECT_REQUEST = JSON.prepare(response);
    }

}
