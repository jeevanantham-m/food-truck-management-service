package com.example.foodtruckmanagement.repository;

import com.example.foodtruckmanagement.entity.FoodTruck;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodTruckRepository extends JpaRepository<FoodTruck,Long> {
    Page<FoodTruck> findByApplicant(String applicant, Pageable page);
    Page<FoodTruck> findByExpirationDateLessThan(Long expirationDate, Pageable page);
    Page<FoodTruck> findByAddressLike(String likePatternForStreetName, Pageable page);
    @Query(nativeQuery = true, value = "select * from food_truck order by ((latitude - ?1)*(latitude - ?1)) + ((longitude - ?2)*(longitude - ?2)) limit 1")
    FoodTruck findNearestTruckByLocation(Double latitude, Double longitude);
}
