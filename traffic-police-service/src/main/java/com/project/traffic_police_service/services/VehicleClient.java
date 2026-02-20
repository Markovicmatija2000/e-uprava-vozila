package com.project.traffic_police_service.services;

import com.project.traffic_police_service.dto.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VehicleClient {

    private final RestTemplate restTemplate;

    public VehicleClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDTO getUserByJmbg(String jmbg) {
        return restTemplate.getForObject(
                "http://mup-vehicles:8082/users/jmbg/{jmbg}",
                UserDTO.class,
                jmbg
        );
    }
}

