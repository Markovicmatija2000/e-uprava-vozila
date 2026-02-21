package com.project.e_goverment.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Enumeration;

@RestController
@RequestMapping("/gateway")
public class GatewayController {

    private final RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/traffic/**")
    public ResponseEntity<?> forwardTraffic(HttpServletRequest request,
                                            @RequestBody(required = false) String body) {
        return forwardRequest(request, body, "http://traffic-police-service:8081");
    }

    @RequestMapping("/vehicles/**")
    public ResponseEntity<?> forwardVehicles(HttpServletRequest request,
                                             @RequestBody(required = false) String body) {
        return forwardRequest(request, body, "http://mup-vehicles:8082");
    }

    @RequestMapping("/users/**")
    public ResponseEntity<?> forwardUsers(HttpServletRequest request,
                                          @RequestBody(required = false) String body) {
        return forwardRequest(request, body, "http://mup-vehicles:8082");
    }

    private ResponseEntity<?> forwardRequest(HttpServletRequest request,
                                             String body,
                                             String baseUrl) {
        // Build target URL
        String targetUrl = baseUrl + request.getRequestURI().replace("/gateway", "");
        if (request.getQueryString() != null) {
            targetUrl += "?" + request.getQueryString();
        }

        // Copy headers
        HttpHeaders headers = new HttpHeaders();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.put(headerName, Collections.list(request.getHeaders(headerName)));
        }

        // Wrap body + headers
        HttpEntity<String> entity = new HttpEntity<>(body, headers);

        // Forward with correct HTTP method
        HttpMethod method = HttpMethod.valueOf(request.getMethod());
        return restTemplate.exchange(targetUrl, method, entity, Object.class);
    }
}
