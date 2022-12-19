package com.example.neoproject;

import com.example.neoproject.model.*;
import com.example.neoproject.repository.*;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.Random;


@SpringBootTest
@RunWith(SpringRunner.class)
 public class NeoProjectApplicationTests {

    @Autowired
    private PostolettoRepository postolettoRepository;

    @Autowired
    private NeonatoRepository neonatoRepository;

    @Autowired
    private RepartoRepository repartoRepository;

    @Autowired
    private SensoreTempRepository sensoreTempRepository;

    @Autowired
    private SensoreEcgRepository sensoreEcgRepository;
    @Autowired
    private ObservationtempRepository observationtempRepository;

    private static int START_NEONATI= 1;
    private static int END_NEONATI = 10000;

    private static int START_SENSORI = 0;
    private static int END_SENSORI = 10000;

    private static int BEGIN_OBSERVATION = 1;
    private static int END_OBSERVATION = 10000;
    @Autowired
    private ObservationecgRepository observationecgRepository;


    @Test
        public void createPostiletto() {
            Reparto r = new Reparto();
            r.setId("neo reparto");
            r.setOspedale("san leonardo");
            r.setLivello(1);
            repartoRepository.save(r);
            for (int i = 0; i < 6999; i++) {
                Postoletto p = new Postoletto();
                p.setNomereparto(r);
                postolettoRepository.save(p);
            }
        }

        @Test
        public void createNeonato(){

            EasyRandomParameters parameters = new EasyRandomParameters();
            parameters.excludeField(FieldPredicates.named("id").and(FieldPredicates.inClass(Neonato.class)));
            parameters.excludeField(FieldPredicates.named("idpostoletto").and(FieldPredicates.inClass(Neonato.class)));
            EasyRandom gen = new EasyRandom(parameters);

            for (int i = 2002; i <=10000; i++){

                Neonato n = gen.nextObject(Neonato.class);
                Postoletto p = postolettoRepository.findPostolettoById(i);
                Reparto r = repartoRepository.findRepartoById("neo reparto");
                p.setNomereparto(r);
                n.setIdpostoletto(p);
                neonatoRepository.save(n);
            }

        }

        @Test
        public void createSensoreTemp(){

            EasyRandomParameters parameters = new EasyRandomParameters();
            parameters.excludeField(FieldPredicates.named("id").and(FieldPredicates.inClass(Sensoretemp.class)));
            parameters.excludeField(FieldPredicates.named("idpostoletto").and(FieldPredicates.inClass(Sensoretemp.class)));
            EasyRandom gen = new EasyRandom(parameters);
            for (int i = START_SENSORI; i <= END_SENSORI; i++){
                Sensoretemp s = gen.nextObject(Sensoretemp.class);
                Postoletto p = postolettoRepository.findPostolettoById(i);
                s.setIdpostoletto(p);
                sensoreTempRepository.save(s);
            }
    }

    @Test
    public void createSensoreEcg(){

        EasyRandomParameters parameters = new EasyRandomParameters();
        parameters.excludeField(FieldPredicates.named("id").and(FieldPredicates.inClass(Sensoreecg.class)));
        parameters.excludeField(FieldPredicates.named("idpostoletto").and(FieldPredicates.inClass(Sensoreecg.class)));
        EasyRandom gen = new EasyRandom(parameters);
        for (int i = START_SENSORI; i <= END_SENSORI; i++){
            Sensoreecg s = gen.nextObject(Sensoreecg.class);
            Postoletto p = postolettoRepository.findPostolettoById(i);
            s.setIdpostoletto(p);
            sensoreEcgRepository.save(s);
        }
    }

    //ok
   /* @Test
    public void deleteAll(){
            neonatoRepository.deleteAll();
    }*/

    @Test
    public void createObs(){
        EasyRandomParameters parameters = new EasyRandomParameters();
        parameters.excludeField(FieldPredicates.named("idsensore").and(FieldPredicates.inClass(Observationtemp.class)));
        parameters.excludeField(FieldPredicates.named("id_observation_temp").and(FieldPredicates.inClass(Observationtemp.class)));
        parameters.excludeField(FieldPredicates.named("neonato_fk").and(FieldPredicates.inClass(Observationtemp.class)));
        parameters.excludeField(FieldPredicates.named("id").and(FieldPredicates.inClass(Observationtemp.class)));
        parameters.excludeField(FieldPredicates.named("neonato").and(FieldPredicates.inClass(Observationtemp.class)));
        //parameters.excludeField(FieldPredicates.named("idObservationtemp").and(FieldPredicates.inClass(Observationtemp.class)));
        EasyRandom gen = new EasyRandom(parameters);
        long startTime = 0;
        long endTime = 0;
        long timeElapsed = 0;

        for (int i = START_NEONATI; i <= END_NEONATI; i++){
            startTime = System.currentTimeMillis();
            Observationtemp obs = gen.nextObject(Observationtemp.class);
            Sensoretemp s = sensoreTempRepository.findSensoreById(i);
            Neonato n = neonatoRepository.findNeonatoById(i);
            System.out.println("-----------------------neonato numero: "+ i + "----------------------------");
            for (int j = BEGIN_OBSERVATION; j <= END_OBSERVATION; j++){
                ObservationtempId obsId = new ObservationtempId(Instant.now(),s.getId());
                obs.setId(obsId);
                obs.setTemperatura(new Random().nextInt(36,41));
                obs.setNeonato(n);
                obs.setIdsensore(s);
                //obs.setIdObservationtemp(j);
                observationtempRepository.save(obs);
            }
            endTime = System.currentTimeMillis();
            timeElapsed = endTime - startTime;
            System.out.println(timeElapsed);
        }
    }

    @Test
    public void createObsEcg(){
        EasyRandomParameters parameters = new EasyRandomParameters();
        parameters.excludeField(FieldPredicates.named("idsensore").and(FieldPredicates.inClass(Observationtemp.class)));
        parameters.excludeField(FieldPredicates.named("id_observation_ecg").and(FieldPredicates.inClass(Observationecg.class)));
        parameters.excludeField(FieldPredicates.named("neonato_fk").and(FieldPredicates.inClass(Observationtemp.class)));
        parameters.excludeField(FieldPredicates.named("id").and(FieldPredicates.inClass(Observationtemp.class)));
        parameters.excludeField(FieldPredicates.named("neonato").and(FieldPredicates.inClass(Observationtemp.class)));
        //parameters.excludeField(FieldPredicates.named("idObservationtemp").and(FieldPredicates.inClass(Observationtemp.class)));
        EasyRandom gen = new EasyRandom(parameters);
        for (int i = START_NEONATI; i <= END_NEONATI; i++){
            Observationecg obs = gen.nextObject(Observationecg.class);
            Sensoreecg s = sensoreEcgRepository.findSensoreById(i);
            Neonato n = neonatoRepository.findNeonatoById(i);
            System.out.println("bambino numero: "+ i);
            for (int j = BEGIN_OBSERVATION; j <= END_OBSERVATION; j++){
                ObservationecgId obsId = new ObservationecgId(Instant.now(),s.getId());
                obs.setId(obsId);
                obs.setIdObservationecg(i);
                obs.setBattiti(new Random().nextInt(60,110));
                obs.setSaturazione(new Random().nextInt(90,97));
                obs.setNeonato(n);
                obs.setIdsensore(s);
                observationecgRepository.save(obs);
            }
        }
    }
/*
    @Test
    public void createObsEcg(){
        EasyRandomParameters parameters = new EasyRandomParameters();
        parameters.excludeField(FieldPredicates.named("idsensore").and(FieldPredicates.inClass(Observationtemp.class)));
        parameters.excludeField(FieldPredicates.named("id_observation_ecg").and(FieldPredicates.inClass(Observationtemp.class)));
        parameters.excludeField(FieldPredicates.named("neonato_fk").and(FieldPredicates.inClass(Observationtemp.class)));
        parameters.excludeField(FieldPredicates.named("id").and(FieldPredicates.inClass(Observationtemp.class)));
        parameters.excludeField(FieldPredicates.named("neonato").and(FieldPredicates.inClass(Observationtemp.class)));
        //parameters.excludeField(FieldPredicates.named("idObservationtemp").and(FieldPredicates.inClass(Observationtemp.class)));
        EasyRandom gen = new EasyRandom(parameters);

        for (int i = START_NEONATI; i <= END_NEONATI; i++){
            Observationecg obs = gen.nextObject(Observationecg.class);
            Sensoreecg s = sensoreEcgRepository.findSensoreById(i);
            Neonato n = neonatoRepository.findNeonatoById(i);
            System.out.println("neonato numero: "+i);
            for (int j = BEGIN_OBSERVATION; j <= END_OBSERVATION; j++){
                ObservationecgId obsId = new ObservationecgId(Instant.now(),s.getId());
                obs.setId(obsId);
                obs.setBattiti(new Random().nextInt(60,110));
                obs.setSaturazione(new Random().nextInt(90,97));
                obs.setNeonato(n);
                obs.setIdsensore(s);
                observationecgRepository.save(obs);
            }
        }
    }*/


    /*
        @Test
    public void createObs(){
        EasyRandomParameters parameters = new EasyRandomParameters();
        parameters.excludeField(FieldPredicates.named("idsensore").and(FieldPredicates.inClass(Observationtemp.class)));
        parameters.excludeField(FieldPredicates.named("id_observation_temp").and(FieldPredicates.inClass(Observationtemp.class)));
        parameters.excludeField(FieldPredicates.named("neonato_fk").and(FieldPredicates.inClass(Observationtemp.class)));
        parameters.excludeField(FieldPredicates.named("id").and(FieldPredicates.inClass(Observationtemp.class)));
        parameters.excludeField(FieldPredicates.named("neonato").and(FieldPredicates.inClass(Observationtemp.class)));
        parameters.excludeField(FieldPredicates.named("idObservationtemp").and(FieldPredicates.inClass(Observationtemp.class)));
        EasyRandom gen = new EasyRandom(parameters);

        Observationtemp obs = gen.nextObject(Observationtemp.class);
        Sensoretemp s = sensoreTempRepository.findSensoreById(1);

        ObservationtempId obsId = new ObservationtempId(Instant.now(),s.getId());
        obs.setId(obsId);

        obs.setTemperatura(new Random().nextInt(36,41));

        Neonato n = neonatoRepository.findNeonatoById(1);

        obs.setNeonato(n);
        obs.setIdsensore(s);

        obs.setIdObservationtemp(1);
        observationtempRepository.save(obs);
    }*/


    //assegnare le patologie ai bambini
    //creare le observation
    //creare le dashboard
    //creare i widget

}
