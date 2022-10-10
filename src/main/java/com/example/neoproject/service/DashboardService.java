package com.example.neoproject.service;
import com.example.neoproject.exception.DashboardException;
import com.example.neoproject.exception.PostolettoNotFoundException;
import com.example.neoproject.model.*;
import com.example.neoproject.repository.DashboardRepository;
import com.example.neoproject.repository.PostolettoRepository;
import com.example.neoproject.repository.SensoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class DashboardService {

    @Autowired
    private DashboardRepository dashboardRepository;
    @Autowired
    private PostolettoRepository postolettoRepository;
    @Autowired
    private SensoreRepository sensoreRepository;

    private Dashboard dashboard;

    public Dashboard createDashboard(Integer idPostoLetto){
        dashboard = new Dashboard();
        if(!postolettoRepository.existsById(idPostoLetto))
            throw new PostolettoNotFoundException(idPostoLetto);
        Postoletto postoletto = postolettoRepository.findPostolettoById(idPostoLetto);
        dashboard.setIdpostoletto(postoletto);
        List <Sensore> sensores = sensoreRepository.findSensoreByIdpostoletto(postoletto);
        dashboard.setSensores(sensores);
        return dashboardRepository.save(dashboard);
    }

    public Dashboard findDashboardByIdPostoletto(Integer idPostoletto){
        if(!postolettoRepository.existsById(idPostoletto))
            throw new PostolettoNotFoundException(idPostoletto);
        Postoletto postoletto = postolettoRepository.findPostolettoById(idPostoletto);
        return dashboardRepository.findDashboardByIdpostoletto(postoletto);
    }

    public Dashboard updateDashboard(Integer idDashboard, Dashboard reqDashboard){
        if(!dashboardRepository.existsById(idDashboard))
            throw new DashboardException(idDashboard);
        this.dashboard.setSensores(reqDashboard.getSensores());
        this.dashboard.setIdpostoletto(reqDashboard.getIdpostoletto());
        return dashboardRepository.save(dashboard);
    }


}
