# food-truck-management-service
# REST API

The REST API to the food truck management app is described below.

## Add a Food Truck Entry

### Request

```
POST http://food-truck-management-service-dev.ap-south-1.elasticbeanstalk.com/food-truck/
```

### RequestBody
    Expected Date format : "dd-MM-yyyy"
```json
    {
        "location_id": long,
        "applicant": String,
        "facility_type": String,
        "cnn": int,
        "location_description": string,
        "address": string,
        "block_lot": string,
        "block": string,
        "lot": string,
        "permit":string,
        "status": string,
        "food_items": string,
        "x": double,
        "y": double,
        "latitude": double,
        "longitude": double,
        "schedule": string,
        "days_hours": string,
        "noi_sent": string,
        "approved": string,
        "received": string,
        "prior_permit": int,
        "expiration_date": string,
        "location": string
    }
```
### Response

    Returns a response message says "Food Truck entry is saved into the datasheet".

## Get Food Truck by Applicant

### Request
```
GET http://food-truck-management-service-dev.ap-south-1.elasticbeanstalk.com/food-truck/applicants/{applicant}
```

### Response

    Returns all food trucks with the equivalent applicant name given.

## Get Food Truck by Street name

### Request
```
GET http://food-truck-management-service-dev.ap-south-1.elasticbeanstalk.com/food-truck/street_name/{streetName}
```

### Response

    Returns all food trucks which contains the street name given.

## Get Food Truck by Expiration Date
    Expected Date format : "dd-MM-yyyy"
### Request
```
GET http://food-truck-management-service-dev.ap-south-1.elasticbeanstalk.com/food-truck/expired/{expirationDate}
```

### Response

    Returns all food trucks which are expired for the date given.

## Get the Nearest Food Truck by Location

### Request
```
GET http://food-truck-management-service-dev.ap-south-1.elasticbeanstalk.com/food-truck/nearest/{latitude}/{longitude}
```

### Response

    Returns a food truck which is nearer to the location given.