package main.java.entities;

import javax.persistence.*;

/**
 * Created by Nikita on 29.07.2016.
 */
@Entity
@Table(name = "conection")
public class Conection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "conectionid")
    private long conectionid;
    @Column(name = "diseaseid")
    private int diseaseid;
    @Column(name = "symptomid")
    private int symptomid;

    public Conection(int diseaseid, int symptomid) {
        this.diseaseid = diseaseid;
        this.symptomid = symptomid;
    }
    public Conection() {
        }

    @Override
    public String toString() {
        return "Conection{" +
                "conectionid=" + conectionid +
                ", diseaseid=" + diseaseid +
                ", symptomid=" + symptomid +
                '}';
    }

    public long getConectionid() {
        return conectionid;
    }

    public void setConectionid(long conectionid) {
        this.conectionid = conectionid;
    }

    public int getDiseaseid() {
        return diseaseid;
    }

    public void setDiseaseid(int diseaseid) {
        this.diseaseid = diseaseid;
    }

    public int getSymptomid() {
        return symptomid;
    }

    public void setSymptomid(int symptomid) {
        this.symptomid = symptomid;
    }
}
