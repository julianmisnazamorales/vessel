package co.edu.uniandes.vessel.vesselsignal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RelationByDayWeekDto {

    public String day;
    public String year;
    public String cargo;
    public String state;
    public long value;

}
