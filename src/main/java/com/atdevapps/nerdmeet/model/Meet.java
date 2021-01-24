package com.atdevapps.nerdmeet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Point;

import lombok.Data;

@Data
@Entity
public class Meet implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    
    @JsonSerialize(using = GeometrySerializer.class)
    //@JsonDeserialize(using = GeometryDeserializer.class)
    @JsonInclude(Include.NON_NULL)
    @Column(name = "location", columnDefinition = "geometry(Point,4326)")
    private Point location;
    
    private double latitude;
    private double longitude;

}
