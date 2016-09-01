package Functions;

import engine.HealthEngine;
import entities.Disease;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;
import utils.APIHandlerServlet;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by cube on 20.08.2016.
 */
public class DiseaseReqest extends APIHandlerServlet.APIRequestHandler {

    public static final DiseaseReqest instance = new DiseaseReqest();


    public static DiseaseReqest getInstance() {
        return instance;
    }

    private DiseaseReqest() {
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        System.out.println(request.getParameter("symptom1"));
        System.out.println(request.getParameter("symptom2"));
        System.out.println(request.getParameter("symptom3"));
        System.out.println(request.getParameter("symptom4"));
        System.out.println(request.getParameter("symptom5"));

        ArrayList symptomList = new ArrayList();
        symptomList.add(request.getParameter("symptom1"));
        symptomList.add(request.getParameter("symptom2"));
        symptomList.add(request.getParameter("symptom3"));
        symptomList.add(request.getParameter("symptom4"));
        symptomList.add(request.getParameter("symptom5"));


        HealthEngine engine = new HealthEngine();

        JSONObject jsonObject = new JSONObject();
        System.out.println(engine.findUserDisease(symptomList).get(0).toString());
        jsonObject.put("resp","Судя по симптомам вы страдаете от " +
                ((Disease)engine.findUserDisease(symptomList).get(0)).getDiseaseName() +
                " советуем вам обратиться к " +
                ((Disease)engine.findUserDisease(symptomList).get(0)).getSpecialistType());

        return jsonObject;
    }
}
