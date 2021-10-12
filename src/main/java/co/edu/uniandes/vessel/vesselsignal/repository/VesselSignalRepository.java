package co.edu.uniandes.vessel.vesselsignal.repository;

import co.edu.uniandes.vessel.vesselsignal.model.VesselSignal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface VesselSignalRepository extends MongoRepository<VesselSignal, String>{

    @Query(value = "{ 'baseDate' : { '$gte': ?0,  $lte: ?1  }}")
    List<VesselSignal> trafficStateByPeriodQuery (Date gte, Date end);

    @Query(value = "{ 'baseDate' : { '$gte': ?0,  $lte: ?1  }, cargoName : ?2}")
    List<VesselSignal> trafficStateByType (Date gte, Date end, String cargoName);
}
