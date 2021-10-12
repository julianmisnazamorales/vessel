package co.edu.uniandes.vessel.vesselsignal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StateByPeriodCovidDto {

    public String period;
    public String state;
    public long value;


}
