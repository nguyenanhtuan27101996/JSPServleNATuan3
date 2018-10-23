/**
 * 
 */
package com.tuan.serviceimpl;

import java.util.List;

import com.tuan.dao.CarDAO;
import com.tuan.daoimpl.CarDAOImpl;
import com.tuan.model.Car;
import com.tuan.service.CarService;

/**
 * @author Tuan
 *
 */
public class CarServiceImpl implements CarService{
        private CarDAO carDAO;
        @Override
        public List<Car> getAllListCar() {
                carDAO = new CarDAOImpl();
                return carDAO.getAllListCar();
        }
        @Override
        public boolean deleteCar(int carID) {
                carDAO = new CarDAOImpl();
                int rowDeleted = carDAO.deleteCar(carID);
                if (rowDeleted == 1) {
                        return true;
                }
                return false;
        }
        @Override
        public boolean updateCar(Car car) {
                carDAO = new CarDAOImpl();
                int rowUpdated = carDAO.updateCar(car);
                if (rowUpdated == 1) {
                        return true;
                }
                return false;
        }
        @Override
        public boolean insertCar(Car car) {
                carDAO = new CarDAOImpl();
                return carDAO.insertCar(car);
        }
        @Override
        public int insertCar1(Car car) {
                carDAO = new CarDAOImpl();
                return carDAO.insertCar1(car);
        }
        
}
