package co.edu.uniandes.vessel.vesselsignal.service;

import co.edu.uniandes.vessel.vesselsignal.dto.*;
import co.edu.uniandes.vessel.vesselsignal.model.VesselSignal;

import java.text.ParseException;
import java.util.List;

public interface VesselSignalService {

    List<StateByPeriodDto>trafficStateByPeriod(String start, String end) throws ParseException;

    List<StateCargoByPeriodDto> cargoStateByPeriod(String start, String end) throws ParseException ;

    List<StateByPeriodCovidDto> getTrafficCovid() throws ParseException;

    List<VesselSignal> getVesselByMonth();

    List<RelationByDayWeekDto> relationDayWeekCargo() throws ParseException;

    List<RelationByTypeDto> relationStateByType() throws ParseException;

}
