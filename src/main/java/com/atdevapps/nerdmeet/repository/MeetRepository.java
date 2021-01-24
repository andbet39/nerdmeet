package com.atdevapps.nerdmeet.repository;

import com.atdevapps.nerdmeet.model.Meet;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetRepository extends JpaRepository<Meet, Long> {
    
	
	
    @Query(value = "SELECT m.id, m.name, m.location,m.latitude,m.longitude, ST_Distance(m.location,ST_SetSRID(ST_Point(:userLongitude,:userLatitude),4326)) AS distance "
            + "FROM meet m "
            + "ORDER BY m.location  <-> ST_SetSRID(ST_Point(:userLongitude,:userLatitude),4326) "
            + "LIMIT 5"
             , nativeQuery = true)
    List<Meet> findAllMeetByDistanceFromUser(@Param("userLongitude") Double userLongitude,@Param("userLatitude")  Double userLatitude);
    
    
    
}
