package co.edu.uniandes.vessel.vesselsignal.service;

import co.edu.uniandes.vessel.vesselsignal.model.VesselSignal;

import java.util.Date;
import java.util.List;

public interface VesselSignalService {

    List<VesselSignal> getHeatMap(Date start, Date end);

    List<VesselSignal> getMapByState(String state,Date start, Date end);

    List<VesselSignal> getTrafficStateByDate();

    List<VesselSignal> getMostCommonCargoByDate();

    List<VesselSignal> getVesselByMonth();

    /*
• ¿Cuál es el tipo de carga más común por estado, en un periodo dado?
• ¿Qué tanto afectó la pandemia al tráfico de embarcaciones teniendo en cuenta el número de embarcaciones por
mes en cada estado en años anteriores?
• ¿Cómo es la distribución geográfica, en un periodo dado, de las embarcaciones? (e.g. mapa de calor)
• ¿Existe alguna relación entre el día de la semana y el tipo de carga en cada estado?¿La relación cambia por año?
     */

}
