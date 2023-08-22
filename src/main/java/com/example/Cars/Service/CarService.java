package com.example.Cars.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Cars.Model.Car;

@Service
public class CarService {

    List<Car> cars = new ArrayList<>();

    public CarService(){}

    public void addCars(Car car)
    {
        cars.add(car);
    }
    
    public List<Car> getAllCars()
    {
        return cars;
    }

    public boolean deleteCar(String number)
    {
        for(Car car : cars){
            if(car.getNumber().equals(number))
            {cars.remove(car);
            return true;}
        }
        return false;
    }

    public boolean updatePrice(Car carParam)
    {
        for(Car car : cars)
        {
            if(car.getNumber().equals(carParam.getNumber()))
            {
                car.setPrice(carParam.getPrice());   
                return true;        
            }
        }
        return false;
    }

    public boolean updatePrice(String number, double price)
    {
        for(Car car : cars)
        {
            if(car.getNumber().equals(number))
                {
                    car.setPrice(price);
                    return true;
                }
        }
        return false;
    }
    
}
