package com.example.foodtruckmanagement.controller;

import com.example.foodtruckmanagement.dto.FetchFoodTrucksResponseDto;
import com.example.foodtruckmanagement.dto.FoodTruckRequest;
import com.example.foodtruckmanagement.dto.FoodTruckResponse;
import com.example.foodtruckmanagement.service.FoodTruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
public class FoodTruckController {

    @Autowired
    FoodTruckService foodtruckService;

    @GetMapping(path = "/food-truck/applicants/{applicant}")
    public ResponseEntity<FetchFoodTrucksResponseDto> getByApplicantName(@Valid @PathVariable("applicant") @NotBlank String applicant, @RequestParam(required = false) Integer offset, @RequestParam(required = false)Integer limit){
        return new ResponseEntity<FetchFoodTrucksResponseDto>(foodtruckService.getByApplicantName(applicant,offset,limit), HttpStatus.OK);
    }

    @GetMapping(path = "/food-truck/expired/{expirationDate}")
    public ResponseEntity<FetchFoodTrucksResponseDto> getByExpirationDate(@Valid @PathVariable("expirationDate") @NotBlank String expirationDate, @RequestParam(required = false) Integer offset, @RequestParam(required = false)Integer limit){
        return new ResponseEntity<FetchFoodTrucksResponseDto>(foodtruckService.getByExpirationDate(expirationDate,offset,limit), HttpStatus.OK);
    }

    @GetMapping(path = "/food-truck/street_name/{streetName}")
    public ResponseEntity<FetchFoodTrucksResponseDto> getByStreetName(@Valid @PathVariable("streetName") @NotBlank String streetName, @RequestParam(required = false) Integer offset, @RequestParam(required = false)Integer limit){
        return new ResponseEntity<FetchFoodTrucksResponseDto>(foodtruckService.getByStreetName(streetName,offset,limit), HttpStatus.OK);
    }

    @PostMapping(path = "/food-truck")
    public ResponseEntity<String> addFoodTruckEntry(@RequestBody @Valid FoodTruckRequest foodTruckRequest){
        return new ResponseEntity<String>(foodtruckService.addFoodTruckEntry(foodTruckRequest), HttpStatus.OK);
    }

    @GetMapping(path = "/food-truck/nearest/{latitude}/{longitude}")
    public ResponseEntity<FoodTruckResponse> getNearestTruckByLocation(@Valid @PathVariable("latitude") @NotBlank Double latitude, @Valid @PathVariable("longitude") @NotBlank Double longitude){
        return new ResponseEntity<FoodTruckResponse>(foodtruckService.getNearestTruckByLocation(latitude,longitude), HttpStatus.OK);
    }
}
