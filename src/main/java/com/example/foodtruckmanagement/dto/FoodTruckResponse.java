package com.example.foodtruckmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FoodTruckResponse {
    @JsonProperty("location_id")
    private Long locationId;
    @JsonProperty("applicant")
    private String applicant;
    @JsonProperty("facility_type")
    private String facilityType;
    @JsonProperty("cnn")
    private Integer cnn;
    @JsonProperty("location_description")
    private String locationDescription;
    @JsonProperty("address")
    private String address;
    @JsonProperty("block_lot")
    private String blockLot;
    @JsonProperty("block")
    private String block;
    @JsonProperty("lot")
    private String lot;
    @JsonProperty("permit")
    private String permit;
    @JsonProperty("status")
    private String status;
    @JsonProperty("food_items")
    private String foodItems;
    @JsonProperty("x")
    private Double x;
    @JsonProperty("y")
    private Double y;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("schedule")
    private String schedule;
    @JsonProperty("days_hours")
    private String daysHours;
    @JsonProperty("noi_sent")
    private String noiSent;
    @JsonProperty("approved")
    private String approved;
    @JsonProperty("received")
    private String received;
    @JsonProperty("prior_permit")
    private Integer priorPermit;
    @JsonProperty("expiration_date")
    private String expirationDate;
    @JsonProperty("location")
    private String location;
}
