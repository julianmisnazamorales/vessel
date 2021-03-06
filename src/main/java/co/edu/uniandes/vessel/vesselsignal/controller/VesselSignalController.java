package co.edu.uniandes.vessel.vesselsignal.controller;

import co.edu.uniandes.vessel.vesselsignal.dto.*;
import co.edu.uniandes.vessel.vesselsignal.model.VesselSignal;
import co.edu.uniandes.vessel.vesselsignal.service.VesselSignalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@Slf4j
public class VesselSignalController {

    private VesselSignalService vesselSignalService;

    @Autowired
    public void setVesselSignalService(VesselSignalService vesselSignalService) {
        this.vesselSignalService = vesselSignalService;
    }

    @GetMapping("/traffic-state-period")
    public List<StateByPeriodDto> trafficStateByPeriod(@RequestParam("start-date") String startDate,
                                                @RequestParam("end-date") String endDate) throws ParseException {
        return vesselSignalService.trafficStateByPeriod(startDate,endDate);
    }

    @GetMapping("/traffic-state-cargo-period")
    public List<StateCargoByPeriodDto> cargoStateByPeriod(@RequestParam("start-date") String startDate,
                                                          @RequestParam("end-date") String endDate) throws ParseException {
        return vesselSignalService.cargoStateByPeriod(startDate,endDate);
    }

    @GetMapping("/traffic-state-covid-period")
    public List<StateByPeriodCovidDto> getTrafficCovid() throws ParseException {
        return vesselSignalService.getTrafficCovid();
    }

    @GetMapping("/traffic-vessel-period")
    public List<StateByPeriodDto> trafficVesselPeriod(@RequestParam("start-date") String startDate,
                                                       @RequestParam("end-date") String endDate) throws ParseException {
        return vesselSignalService.trafficStateByPeriod(startDate,endDate);
    }

    @GetMapping("/traffic-vessel-relation-day")
    public List<RelationByDayWeekDto> trafficVesselRelationDay()throws ParseException{
        return vesselSignalService.relationDayWeekCargo();
    }

    @GetMapping("/traffic-vessel-relation-type")
    public List<RelationByTypeDto> trafficVesselRelationType()throws ParseException{
        return vesselSignalService.relationStateByType();
    }
}
