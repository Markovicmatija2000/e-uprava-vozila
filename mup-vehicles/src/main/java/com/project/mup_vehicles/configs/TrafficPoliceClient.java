package com.project.mup_vehicles.configs;
import com.project.mup_vehicles.dtos.ViolationDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class TrafficPoliceClient {

    private final RestTemplate restTemplate;

    public TrafficPoliceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ViolationDTO> getViolationsByDriverJmbg(String jmbg) {
        ViolationDTO[] violations = restTemplate.getForObject(
                "http://traffic-police-service:8081/traffic/violations/driver/{jmbg}",
                ViolationDTO[].class,
                jmbg
        );
        return Arrays.asList(violations);
    }
}

