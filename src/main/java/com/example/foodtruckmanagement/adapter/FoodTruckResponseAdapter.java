package com.example.foodtruckmanagement.adapter;

import com.example.foodtruckmanagement.dto.FoodTruckRequest;
import com.example.foodtruckmanagement.dto.FoodTruckResponse;
import com.example.foodtruckmanagement.entity.FoodTruck;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class FoodTruckResponseAdapter {

    private final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    public List<FoodTruckResponse> convertFoodTruckEntityToFoodTruckResponse(List<FoodTruck> foodTruckPageList) {

        List<FoodTruckResponse> foodTruckResponseList = new ArrayList<>();

        for(FoodTruck foodTruck : foodTruckPageList) {
            foodTruckResponseList.add(FoodTruckResponse.builder()
                    .locationId(foodTruck.getLocationId())
                    .applicant(foodTruck.getApplicant())
                    .facilityType(foodTruck.getFacilityType())
                    .cnn(foodTruck.getCnn())
                    .locationDescription(foodTruck.getLocationDescription())
                    .address(foodTruck.getAddress())
                    .blockLot(foodTruck.getBlockLot())
                    .block(foodTruck.getBlock())
                    .lot(foodTruck.getLot())
                    .permit(foodTruck.getPermit())
                    .status(foodTruck.getStatus())
                    .foodItems(foodTruck.getFoodItems())
                    .x(foodTruck.getX())
                    .y(foodTruck.getY())
                    .latitude(foodTruck.getLatitude())
                    .longitude(foodTruck.getLongitude())
                    .schedule(foodTruck.getSchedule())
                    .daysHours(foodTruck.getDaysHours())
                    .noiSent(getStringTime(foodTruck.getNoiSent()))
                    .approved(getStringTime(foodTruck.getApproved()))
                    .received(getStringTime(foodTruck.getReceived()))
                    .priorPermit(foodTruck.getPriorPermit())
                    .expirationDate(getStringTime(foodTruck.getExpirationDate()))
                    .location(foodTruck.getLocation()).build());
        }
        return foodTruckResponseList;
    }

    public FoodTruck convertFoodTruckRequestToFoodTruckEntity(FoodTruckRequest foodTruckRequest){
        return FoodTruck.builder()
                .locationId(foodTruckRequest.getLocationId())
                .applicant(foodTruckRequest.getApplicant())
                .facilityType(foodTruckRequest.getFacilityType())
                .cnn(foodTruckRequest.getCnn())
                .locationDescription(foodTruckRequest.getLocationDescription())
                .address(foodTruckRequest.getAddress())
                .blockLot(foodTruckRequest.getBlockLot())
                .block(foodTruckRequest.getBlock())
                .lot(foodTruckRequest.getLot())
                .permit(foodTruckRequest.getPermit())
                .status(foodTruckRequest.getStatus())
                .foodItems(foodTruckRequest.getFoodItems())
                .x(foodTruckRequest.getX())
                .y(foodTruckRequest.getY())
                .latitude(foodTruckRequest.getLatitude())
                .longitude(foodTruckRequest.getLongitude())
                .schedule(foodTruckRequest.getSchedule())
                .daysHours(foodTruckRequest.getDaysHours())
                .noiSent(getLongTime(foodTruckRequest.getNoiSent()))
                .approved(getLongTime(foodTruckRequest.getApproved()))
                .received(getLongTime(foodTruckRequest.getReceived()))
                .priorPermit(foodTruckRequest.getPriorPermit())
                .expirationDate(getLongTime(foodTruckRequest.getExpirationDate()))
                .location(foodTruckRequest.getLocation()).build();
    }

    public Long getLongTime(String stringDate){
        Long milliseconds = 0L;
        try {
            Date d = formatter.parse(stringDate);
            milliseconds = d.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return milliseconds/1000;
    }

    public String getStringTime(Long longDate){
        if(longDate == null){
            return null;
        }
        Date d = new Date(longDate*1000);
        return formatter.format(d);
    }
}
