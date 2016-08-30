package entities;

import javax.persistence.*;

/**
 * Created by Nikita on 26.07.2016.
 */
@Entity
@Table(name = "symptom")
public class Symptom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "symptomId")
    private long symptomId;
    @Column(name = "symptomName")
    private String symptomName;
    @Column(name = "symptomSynonyms")
    private String symptomSynonyms;
    @Column (name = "disease")

    public long getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(long symptomId) {
        this.symptomId = symptomId;
    }

    public String getSymptomName() {
        return symptomName;
    }

    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName;
    }

    public String getSymptomSynonyms() {
        return symptomSynonyms;
    }

    public void setSymptomSynonyms(String symptomSynonyms) {
        this.symptomSynonyms = symptomSynonyms;
    }

    public Symptom(long symptomId, String symptomName, String symptomSynonyms) {

        this.symptomId = symptomId;
        this.symptomName = symptomName;
        this.symptomSynonyms = symptomSynonyms;
    }
    public Symptom() {
     }
}
