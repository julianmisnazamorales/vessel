package co.edu.uniandes.vessel.vesselsignal.model;

import org.springframework.data.annotation.Id;

public class VesselSignal {

    @Id
    public String id;
    public String key;
    public String baseDate;
    public String cargoName;
    public String state;
    public String typeName;

    public VesselSignal() {}

    public VesselSignal(String id, String key, String baseDate, String cargoName, String state, String typeName) {
        this.id = id;
        this.key = key;
        this.baseDate = baseDate;
        this.cargoName = cargoName;
        this.state = state;
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return String.format(
                "Vessel[id=%s, key='%s', state='%s']",
                id, key, state);
    }

}
