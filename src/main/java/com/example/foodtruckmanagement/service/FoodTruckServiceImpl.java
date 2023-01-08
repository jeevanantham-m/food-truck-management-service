package com.example.foodtruckmanagement.service;

import com.example.foodtruckmanagement.adapter.FoodTruckResponseAdapter;
import com.example.foodtruckmanagement.dto.FetchFoodTrucksResponseDto;
import com.example.foodtruckmanagement.dto.FoodTruckRequest;
import com.example.foodtruckmanagement.dto.FoodTruckResponse;
import com.example.foodtruckmanagement.entity.FoodTruck;
import com.example.foodtruckmanagement.repository.FoodTruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodTruckServiceImpl implements FoodTruckService {

    @Autowired
    FoodTruckRepository foodTruckRepository;
    @Autowired
    FoodTruckResponseAdapter foodTruckResponseAdapter;
    @Override
    public FetchFoodTrucksResponseDto getByApplicantName(String applicant, Integer offset, Integer limit) {
        String likePatternForApplicant = "%" + applicant + "%";
        Page<FoodTruck> foodTruckPageList = foodTruckRepository.findByApplicantLike(likePatternForApplicant,getPagination(offset, limit));
        return getFetchFoodTrucksResponseDto(foodTruckPageList);
    }

    @Override
    public FetchFoodTrucksResponseDto getByExpirationDate(String expirationDate, Integer offset, Integer limit) {
        Page<FoodTruck> foodTruckPageList = foodTruckRepository.findByExpirationDateLessThan(foodTruckResponseAdapter.getLongTime(expirationDate),getPagination(offset, limit));
        return getFetchFoodTrucksResponseDto(foodTruckPageList);
    }

    @Override
    public FetchFoodTrucksResponseDto getByStreetName(String streetName, Integer offset, Integer limit) {
        String likePatternForStreetName = "%" + streetName + "%";
        Page<FoodTruck> foodTruckPageList = foodTruckRepository.findByAddressLike(likePatternForStreetName,getPagination(offset, limit));
        return getFetchFoodTrucksResponseDto(foodTruckPageList);
    }

    @Override
    public String addFoodTruckEntry(FoodTruckRequest foodTruckRequest) {
        foodTruckRepository.save(foodTruckResponseAdapter.convertFoodTruckRequestToFoodTruckEntity(foodTruckRequest));
        return "Food Truck entry is saved into the datasheet";
    }

    @Override
    public FoodTruckResponse getNearestTruckByLocation(Double latitude, Double longitude) {
        List<FoodTruck> foodTruckList = new ArrayList<>();
        foodTruckList.add(foodTruckRepository.findNearestTruckByLocation(latitude, longitude));
        return foodTruckResponseAdapter.convertFoodTruckEntityToFoodTruckResponse(foodTruckList).get(0);
    }

    private Pageable getPagination(Integer offset, Integer limit){
        offset = offset!=null ? offset : 0;
        limit = limit!=null ? limit : 10;
        return PageRequest.of(offset, limit);
    }

    private FetchFoodTrucksResponseDto getFetchFoodTrucksResponseDto(Page<FoodTruck> foodTruckPageList){
        return FetchFoodTrucksResponseDto.builder()
                .data(foodTruckResponseAdapter.convertFoodTruckEntityToFoodTruckResponse(foodTruckPageList.toList()))
                .totalRecords(foodTruckPageList.getTotalElements())
                .totalPages(foodTruckPageList.getTotalPages())
                .build();
    }
}
