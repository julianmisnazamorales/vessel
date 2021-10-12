package co.edu.uniandes.vessel;

import co.edu.uniandes.vessel.vesselsignal.repository.VesselSignalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class VesselApplication {

    @Autowired
    VesselSignalRepository vesselSignalRepository;

    public static void main(String[] args) {
        SpringApplication.run(VesselApplication.class, args);
    }

}
