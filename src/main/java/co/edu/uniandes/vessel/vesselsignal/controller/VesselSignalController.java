package co.edu.uniandes.vessel.vesselsignal.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class VesselSignalController {

    @GetMapping
    public String query1(){
        return "";
    }

    @GetMapping
    public String query2(){
        return "";
    }
}
