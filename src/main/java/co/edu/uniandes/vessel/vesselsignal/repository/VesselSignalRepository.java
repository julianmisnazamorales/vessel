package co.edu.uniandes.vessel.vesselsignal.repository;

import co.edu.uniandes.vessel.vesselsignal.model.VesselSignal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VesselSignalRepository extends MongoRepository<VesselSignal, String>{
}
