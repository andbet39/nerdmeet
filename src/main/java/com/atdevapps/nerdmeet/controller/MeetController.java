package com.atdevapps.nerdmeet.controller;

import java.util.List;

import com.atdevapps.nerdmeet.model.Meet;
import com.atdevapps.nerdmeet.repository.MeetRepository;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeetController {
    
    @Autowired
    MeetRepository meetRepository;

    @PostMapping("/meet")
    public Meet addMeet(@RequestBody Meet meet){

        GeometryFactory gf = new GeometryFactory();
        Point point = gf.createPoint(new Coordinate(meet.getLatitude(),meet.getLongitude() ));
        meet.setLocation(point);

        return meetRepository.save(meet);
    }

	@CrossOrigin
    @GetMapping("/meets")
    public List<Meet> getAll(){
        return meetRepository.findAll();
    }
    
    @GetMapping("/nearmeets")
    public List<Meet> getNearest(){
        return meetRepository.findAllMeetByDistanceFromUser(41.902782,12.496366);
    }
    
    
}
