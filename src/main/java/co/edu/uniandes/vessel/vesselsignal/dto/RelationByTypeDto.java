package co.edu.uniandes.vessel.vesselsignal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RelationByTypeDto {

    public String year;
    public String month;
    public long value;

}
