package com.example.foodtruckmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity(name="food_truck")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodTruck {
    @Id
    @Column(name="location_id")
    private Long locationId;
    @Column(name="applicant", nullable=false)
    private String applicant;
    @Column(name="facility_type", nullable=false)
    private String facilityType;
    @Column(name="cnn")
    private Integer cnn;
    @Column(name="location_description")
    private String locationDescription;
    @Column(name="address")
    private String address;
    @Column(name="block_lot")
    private String blockLot;
    @Column(name="block")
    private String block;
    @Column(name="lot")
    private String lot;
    @Column(name="permit")
    private String permit;
    @Column(name="status")
    private String status;
    @Column(name="food_items", columnDefinition = "text")
    @Lob
    private String foodItems;
    @Column(name="x")
    private Double x;
    @Column(name="y")
    private Double y;
    @Column(name="latitude")
    private Double latitude;
    @Column(name="longitude")
    private Double longitude;
    @Column(name="schedule")
    private String schedule;
    @Column(name="days_hours")
    private String daysHours;
    @Column(name="noi_sent")
    private Long noiSent;
    @Column(name="approved")
    private Long approved;
    @Column(name="received")
    private Long received;
    @Column(name="prior_permit")
    private Integer priorPermit;
    @Column(name="expiration_date")
    private Long expirationDate;
    @Column(name="location")
    private String location;
}
