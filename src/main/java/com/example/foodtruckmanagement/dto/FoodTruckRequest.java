package com.example.foodtruckmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class FoodTruckRequest {
    @JsonProperty("location_id")
    @NotBlank
    private Long locationId;
    @JsonProperty("applicant")
    @NotBlank
    private String applicant;
    @JsonProperty("facility_type")
    @NotBlank
    private String facilityType;
    @JsonProperty("cnn")
    @NotBlank
    private Integer cnn;
    @JsonProperty("location_description")
    private String locationDescription;
    @JsonProperty("address")
    @NotBlank
    private String address;
    @JsonProperty("block_lot")
    private String blockLot;
    @JsonProperty("block")
    private String block;
    @JsonProperty("lot")
    private String lot;
    @JsonProperty("permit")
    @NotBlank
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
    @NotNull
    private String expirationDate;
    @JsonProperty("location")
    private String location;
}
