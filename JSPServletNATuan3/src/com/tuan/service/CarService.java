/**
 * 
 */
package com.tuan.service;

import java.util.List;

import com.tuan.model.Car;

/**
 * @author Tuan
 *
 */
public interface CarService {
        List<Car> getAllListCar();
        boolean deleteCar(int carID);
        boolean updateCar(Car car);
        boolean insertCar(Car car);
        int insertCar1(Car car);
}
