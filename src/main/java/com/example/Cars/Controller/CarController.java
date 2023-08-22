package com.example.Cars.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Cars.Model.Car;
import com.example.Cars.Service.CarService;

@RestController

public class CarController {
    @Autowired
    CarService cars;

    @PostMapping(path = "/car")
    ResponseEntity<String> addCar(@RequestBody Car car) {
        cars.addCars(car);
        return new ResponseEntity<String>("Car successfully added", HttpStatus.CREATED);
    }

    @GetMapping(path="/car")
    ResponseEntity<List<Car>> getAllCars()
    {
        return new ResponseEntity<List<Car>>(cars.getAllCars(), HttpStatus.OK);
    }

    @PutMapping(path="/car")
    ResponseEntity<String> updatePriceUsingCar(@RequestBody Car car)
    {
        if(cars.updatePrice(car))
        return new ResponseEntity<String>("Car price has been successfully updated", HttpStatus.OK);
        return new ResponseEntity<String>("No car present with such number", HttpStatus.NOT_FOUND);
    }

    @PutMapping(path="/updatePrice")
    ResponseEntity<String> updatePrice(@RequestParam String number, @RequestParam Double price)
    {
        if(cars.updatePrice(number, price))
            return new ResponseEntity<String>("Price updated", HttpStatus.ACCEPTED);
        return new ResponseEntity<String>("No car present with such number", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path="/car")
    ResponseEntity<String> deleteCar(@RequestParam String number)
    {
        if(cars.deleteCar(number))
            return new ResponseEntity<String>("Car deleted", HttpStatus.NO_CONTENT);
        return new ResponseEntity<String>("No car with such number present", HttpStatus.NOT_FOUND);
    }
}
