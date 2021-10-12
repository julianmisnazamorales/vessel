package co.edu.uniandes.vessel.vesselsignal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StateCargoByPeriodDto {

    public String state;
    public String cargo;
    public long value;


}
