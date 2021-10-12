package co.edu.uniandes.vessel.vesselsignal.service;

import co.edu.uniandes.vessel.vesselsignal.dto.*;
import co.edu.uniandes.vessel.vesselsignal.model.VesselSignal;
import co.edu.uniandes.vessel.vesselsignal.repository.VesselSignalRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class VesselSignalServiceImpl implements VesselSignalService {

    private VesselSignalRepository vesselSignalRepository;

    private final String FORMAT_DATE ="yyyy-MM-dd";

    @Autowired
    public void setVesselSignalRepository(VesselSignalRepository vesselSignalRepository) {
        this.vesselSignalRepository = vesselSignalRepository;
    }

    @Override
    public List<StateByPeriodDto> trafficStateByPeriod(String start, String end) throws ParseException {
       List<VesselSignal> vesselSignalList = vesselSignalRepository.trafficStateByPeriodQuery(DateUtils.parseDate(start,FORMAT_DATE),DateUtils.parseDate(end,"yyyy-MM-dd"));
        Map<String, Long> counted  = vesselSignalList.stream().collect(Collectors.groupingBy( VesselSignal::getState, Collectors.counting()));

        String max = counted.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

        List<StateByPeriodDto> stateByPeriodDtoList = new ArrayList<>();
        counted.forEach((x, y)-> stateByPeriodDtoList.add(new StateByPeriodDto(x,y)));
        return stateByPeriodDtoList;
    }

    @Override
    public List<StateCargoByPeriodDto> cargoStateByPeriod(String start, String end) throws ParseException {
        List<VesselSignal> vesselSignalList = vesselSignalRepository.trafficStateByPeriodQuery(DateUtils.parseDate(start,FORMAT_DATE),DateUtils.parseDate(end,"yyyy-MM-dd"));
        Map<String, Long> counted  = vesselSignalList.stream().collect(Collectors.groupingBy( x -> x.getState() + "-" + x.getCargoName(), Collectors.counting()));
        List<StateCargoByPeriodDto> stateCargoByPeriodDtos = new ArrayList<>();
         counted.forEach((x, y)-> {
             String[] value = x.split("-");
             stateCargoByPeriodDtos.add(new StateCargoByPeriodDto(value[0],value[1],y));
         });
        return stateCargoByPeriodDtos;
    }

    @Override
    public List<StateByPeriodCovidDto> getTrafficCovid() throws ParseException {
        List<VesselSignal> vesselSignalList = vesselSignalRepository.trafficStateByPeriodQuery(DateUtils.parseDate("2017-01-01",FORMAT_DATE),DateUtils.parseDate("2019-12-31","yyyy-MM-dd"));
        Map<String, Long> counted  = vesselSignalList.stream().collect(Collectors.groupingBy( x -> String.valueOf(x.getBaseDate().getYear()) + x.getBaseDate().getMonth() + "-" + x.getState(), Collectors.counting()));
        List<StateByPeriodCovidDto> stateCargoByPeriodDtos = new ArrayList<>();
        counted.forEach((x, y)-> {
            String[] value = x.split("-");
            stateCargoByPeriodDtos.add(new StateByPeriodCovidDto(value[0],value[1],y));
        });
        return stateCargoByPeriodDtos;
    }

    @Override
    public List<VesselSignal> getVesselByMonth() {
        return null;
    }


    @Override
    public List<RelationByDayWeekDto> relationDayWeekCargo() throws ParseException {
        List<VesselSignal> vesselSignalList = vesselSignalRepository.
                trafficStateByPeriodQuery(DateUtils.parseDate("2017-01-01",FORMAT_DATE),
                                          DateUtils.parseDate("2019-12-31",FORMAT_DATE));
        Map<String, Long> counted  = vesselSignalList.stream().collect(
                Collectors.groupingBy( x -> getDayName(x.baseDate) + "-" +  x.getBaseDate().getYear() + "-"
                                     + x.getCargoName() + "-" + x.getState(), Collectors.counting()));
        List<RelationByDayWeekDto> stateCargoByPeriodDtos = new ArrayList<>();
        counted.forEach((x, y)-> {
            String[] value = x.split("-");
            stateCargoByPeriodDtos.add(new RelationByDayWeekDto(value[0],value[1], value[2], value[3], y));
        });
        return stateCargoByPeriodDtos;
    }

    @Override
    public List<RelationByTypeDto> relationStateByType() throws ParseException {
        List<VesselSignal> vesselSignalList = vesselSignalRepository.
                trafficStateByType(DateUtils.parseDate("2017-01-01",FORMAT_DATE),
                        DateUtils.parseDate("2018-12-31",FORMAT_DATE), "");
        Map<String, Long> counted  = vesselSignalList.stream()
                .collect(Collectors.groupingBy( x -> String.valueOf(x.getBaseDate().getYear()) +
                                                x.getBaseDate().getMonth(), Collectors.counting()));

        Map<String, Long> orderedResult = counted.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        List<RelationByTypeDto> stateCargoByPeriodDtos = new ArrayList<>();
        orderedResult.forEach((x, y)-> {
            String[] value = x.split("-");
            stateCargoByPeriodDtos.add(new RelationByTypeDto(value[0],value[1], y));
        });
        return stateCargoByPeriodDtos;
    }


    public static String getDayName(Date date) {
        return new SimpleDateFormat("EEEE").format(date);
    }


}
