package com.example.neoproject.controller;

import com.example.neoproject.model.Dashboard;
import com.example.neoproject.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api")
@RestController
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/dashboard/{idPostoletto}")
    public ResponseEntity<Dashboard> getDashboard(@PathVariable Integer idPostoletto){
        return new ResponseEntity<>(dashboardService.findDashboardByIdPostoletto(idPostoletto), HttpStatus.OK);
    }

    //testare
    @PostMapping("/dashboard")
    public Integer createDashboard(@RequestParam Integer idPostoletto){
        return dashboardService.createDashboard(idPostoletto).getId();
    }

    @PutMapping("/dashboard/{idPostoletto}")
    public ResponseEntity<Dashboard> updateDashboard(@PathVariable Integer idPostoletto, @RequestBody Dashboard dashboard){
        return new ResponseEntity<>(dashboardService.updateDashboard(idPostoletto, dashboard),HttpStatus.OK);
    }
}
