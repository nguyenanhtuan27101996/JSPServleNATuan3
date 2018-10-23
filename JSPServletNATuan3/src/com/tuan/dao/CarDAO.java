/**
 * 
 */
package com.tuan.dao;

import java.util.List;

import com.tuan.model.Car;

/**
 * @author Tuan
 *
 */
public interface CarDAO {
        List<Car> getAllListCar();
        int deleteCar(int carID);
        int updateCar(Car car);
        boolean insertCar(Car car);
        int insertCar1(Car car);
}
