package com.example.foodtruckmanagement.service;

import com.example.foodtruckmanagement.dto.FetchFoodTrucksResponseDto;
import com.example.foodtruckmanagement.dto.FoodTruckRequest;
import com.example.foodtruckmanagement.dto.FoodTruckResponse;

public interface FoodTruckService {
     FetchFoodTrucksResponseDto getByApplicantName(String applicant, Integer offset, Integer limit);
     FetchFoodTrucksResponseDto getByExpirationDate(String expirationDate, Integer offset, Integer limit);
     FetchFoodTrucksResponseDto getByStreetName(String streetName, Integer offset, Integer limit);
     String addFoodTruckEntry(FoodTruckRequest foodTruckRequest);
     FoodTruckResponse getNearestTruckByLocation(Double latitude, Double longitude);
}
