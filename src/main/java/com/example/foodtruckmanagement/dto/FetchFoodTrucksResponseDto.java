package com.example.foodtruckmanagement.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class FetchFoodTrucksResponseDto {
    List<FoodTruckResponse> data;
    Integer totalPages;
    Long totalRecords;

}
