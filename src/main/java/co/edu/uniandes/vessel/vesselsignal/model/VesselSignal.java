package co.edu.uniandes.vessel.vesselsignal.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.lang.model.element.NestingKind;
import java.util.Date;


@Document(collection = "vessels")
@Getter
@Setter
public class VesselSignal {

    @Id
    public String id;
    @Field("Key")
    public String key;
    @Field("BaseDate")
    public Date baseDate;
    @Field("CargoName")
    public String cargoName;
    @Field("State")
    public String state;
    @Field("VesselType")
    public String typeName;

}
