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
public class DiseaseReqest extends APIHandlerServlet.APIRequestHandler {

    public static final DiseaseReqest instance = new DiseaseReqest();

    final static Logger logger = Logger.getLogger(DiseaseReqest.class);
    public static DiseaseReqest getInstance() {
        return instance;
    }

    private DiseaseReqest() {
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        logger.info(request.getParameter("symptom1"));
        logger.info(request.getParameter("symptom2"));
        logger.info(request.getParameter("symptom3"));
        logger.info(request.getParameter("symptom4"));
        logger.info(request.getParameter("symptom5"));
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
        logger.info("симптом лист: " + symptomList.toString());
        logger.info("болезни: " + usersSiseases.toString());


        resp = "Возможно вы страдаете от болезни под названием " +
                (usersSiseases.get(0)).getDiseaseName() +
                " советуем вам обратиться к специалисту с специализацией " +
                (usersSiseases.get(0)).getSpecialistType() + "    <br>    ";

        for (int i = 1; i < usersSiseases.size(); i++) {
            resp = resp + "Возможно вы страдаете от болезни под названием " +
                    (usersSiseases.get(i)).getDiseaseName() +
                    " советуем вам обратиться к специалисту с специализацией " +
                    (usersSiseases.get(i)).getSpecialistType() + "    <br>    ";
        }

        logger.info("строка ответ= " + resp.toString());

        jsonObject.put("resp", resp);

        return jsonObject;
    }
}
