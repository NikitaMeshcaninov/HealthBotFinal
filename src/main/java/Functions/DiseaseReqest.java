package Functions;

import engine.HealthEngine;
import entities.Disease;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;
import utils.APIHandlerServlet;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
        HealthEngine engine = new HealthEngine();
        JSONObject jsonObject = new JSONObject();
        String resp = null;
        ArrayList symptomList = new ArrayList();
        List<Disease> usersSiseases = null;


        for (int i = 1; i <= 5; i++) {
            symptomList.add(request.getParameter("symptom" + i));
            System.out.println(symptomList.toString());
        }
        usersSiseases = engine.findUserDisease(symptomList);
        System.out.println("симптом лист " + symptomList.toString());
        System.out.println("болезни: " + usersSiseases.toString());


        resp = "Судя по симптомам вы страдаете от " +
                (usersSiseases.get(0)).getDiseaseName() +
                " советуем вам обратиться к " +
                (usersSiseases.get(0)).getSpecialistType() + "<br>";

        for (int i = 1; i < usersSiseases.size(); i++) {
            resp = resp + "Судя по симптомам вы страдаете от " +
                    (usersSiseases.get(i)).getDiseaseName() +
                    " советуем вам обратиться к " +
                    (usersSiseases.get(i)).getSpecialistType() + "<br>";
        }

        System.out.println("строка ответ= " + resp.toString());

        jsonObject.put("resp", resp);

        return jsonObject;
    }
}
