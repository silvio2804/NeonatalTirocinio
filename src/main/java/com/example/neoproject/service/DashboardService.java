package com.example.neoproject.service;
import com.example.neoproject.exception.DashboardException;
import com.example.neoproject.exception.PostolettoNotFoundException;
import com.example.neoproject.exception.SensoreNotFoundException;
import com.example.neoproject.jsonRequest.DashboardRequest;
import com.example.neoproject.model.*;
import com.example.neoproject.repository.DashboardRepository;
import com.example.neoproject.repository.PostolettoRepository;
import com.example.neoproject.repository.SensoreEcgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private DashboardRepository dashboardRepository;
    @Autowired
    private PostolettoRepository postolettoRepository;

    @Autowired
    private SensoreEcgRepository sensoreEcgRepository;

    private Dashboard dashboard;

    //precondizioni (il posto letto gia esiste)
    //associo i sensori al posto letto e al sensore gli observation (fatto in Sensore service)
    /*public Dashboard createDashboard(DashboardRequest dR, HttpStatus ok){
        dashboard = new Dashboard();
        if(!postolettoRepository.existsById(dR.getIdPostoletto()))
            throw new PostolettoNotFoundException(dR.getIdPostoletto());
        Postoletto postoletto = postolettoRepository.findPostolettoById(dR.getIdPostoletto());
        dashboard.setIdpostoletto(postoletto);
        if(!sensoreEcgRepository.existsByTipologia(dR.getTipoSensore()))
            throw new SensoreNotFoundException(dR.getTipoSensore());
        Sensore s = new Sensore();
        s.setTipologia(dR.getTipoSensore());
        s.setDimensione(dR.getDimensione());
        s.setPosizione(dR.getPosizione());
        s.setIdpostoletto(postoletto);
        List <Sensore> sensores = new ArrayList<>();
        sensores.add(s);
        for(Sensore sens: sensores) sens.setIddashboard(dashboard);
        dashboard.setSensores(sensores);
        return dashboardRepository.save(dashboard);
    }

    public Dashboard findDashboardByIdPostoletto(Integer idPostoletto){
        if(!postolettoRepository.existsById(idPostoletto))
            throw new PostolettoNotFoundException(idPostoletto);
        Postoletto postoletto = postolettoRepository.findPostolettoById(idPostoletto);
        return dashboardRepository.findDashboardByIdpostoletto(postoletto);
    }
//aggiunta di un nuovo sensore
    public Dashboard updateDashboard(Integer idDashboard, Dashboard reqDashboard){
        if(!dashboardRepository.existsById(idDashboard))
            throw new DashboardException(idDashboard);
        this.dashboard.setSensores(reqDashboard.getSensores());
        this.dashboard.setIdpostoletto(reqDashboard.getIdpostoletto());
        return dashboardRepository.save(dashboard);
    }*/

}
