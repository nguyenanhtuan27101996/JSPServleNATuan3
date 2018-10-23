/**
 * 
 */
package com.tuan.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tuan.common.ConstantPage;
import com.tuan.dao.CarDAO;
import com.tuan.model.Car;
import com.tuan.sqlserver.ConnectDB;
import com.tuan.utility.DBUtils;

/**
 * @author Tuan
 *
 */
public class CarDAOImpl implements CarDAO {
        private ConnectDB connectDB;
        private DBUtils dbUtils;

        @Override
        public List<Car> getAllListCar() {
                connectDB = new ConnectDB();
                dbUtils = new DBUtils();
                Connection conn = connectDB.getConnection();
                List<Car> listCar = new ArrayList<>();
                PreparedStatement preparedStatement = null;
                ResultSet resultSet = null;
                Car car = null;
                String sql = "select CarID,Maker,Model,ManufactureYear,Color,Note from Car";
                try {
                        preparedStatement = conn.prepareStatement(sql);
                        resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                                car = new Car();
                                car.setCarID(resultSet.getInt("CarID"));
                                car.setMaker(resultSet.getString("Maker"));
                                car.setModel(resultSet.getString("Model"));
                                car.setManufactureYear(resultSet.getString("ManufactureYear"));
                                car.setColor(resultSet.getString("Color"));
                                car.setNote(resultSet.getString("Note"));

                                listCar.add(car);
                        }
                } catch (SQLException e) {
                        System.out.println("Loi khi query all car");
                } finally {
                        dbUtils.closeResultSet(resultSet);
                        dbUtils.closePreparedStatement(preparedStatement);
                        dbUtils.closeConnection(conn);
                }
                return listCar;
        }

        @Override
        public int deleteCar(int carID) {
                connectDB = new ConnectDB();
                dbUtils = new DBUtils();
                Connection conn = connectDB.getConnection();
                PreparedStatement preparedStatement = null;
                int rowAffected = 0;
                try {
                        preparedStatement = conn.prepareStatement(ConstantPage.SQL_DELETE_CAR_BY_ID);
                        preparedStatement.setInt(1, carID);
                        rowAffected = preparedStatement.executeUpdate();
                } catch (SQLException e) {
                        System.out.println("loi khi delete car");
                } finally {
                        dbUtils.closePreparedStatement(preparedStatement);
                        dbUtils.closeConnection(conn);
                }
                return rowAffected;
        }

        @Override
        public int updateCar(Car car) {
                connectDB = new ConnectDB();
                dbUtils = new DBUtils();
                Connection conn = connectDB.getConnection();
                PreparedStatement preparedStatement = null;
                int rowAffected = 0;
                try {
                        preparedStatement = conn.prepareStatement(ConstantPage.SQL_UPDATE_CAR_BY_ID);
                        preparedStatement.setString(1, car.getMaker());
                        preparedStatement.setString(2, car.getModel());
                        preparedStatement.setString(3, car.getManufactureYear());
                        preparedStatement.setString(4, car.getColor());
                        preparedStatement.setString(5, car.getNote());
                        preparedStatement.setInt(6, car.getCarID());
                        rowAffected = preparedStatement.executeUpdate();
                } catch (SQLException e) {
                        System.out.println("loi khi update car");
                } finally {
                        dbUtils.closePreparedStatement(preparedStatement);
                        dbUtils.closeConnection(conn);
                }
                return rowAffected;
        }

        @Override
        public boolean insertCar(Car car) {
                connectDB = new ConnectDB();
                dbUtils = new DBUtils();
                Connection conn = connectDB.getConnection();
                PreparedStatement preparedStatement = null;
                boolean isSuccess = false;
                
                try {
                        preparedStatement = conn.prepareStatement(ConstantPage.SQL_INSERT_CAR);
                        preparedStatement.setString(1, car.getMaker());
                        preparedStatement.setString(2, car.getModel());
                        preparedStatement.setString(3, car.getManufactureYear());
                        preparedStatement.setString(4, car.getColor());
                        preparedStatement.setString(5, car.getNote());
                        preparedStatement.executeUpdate();
                        isSuccess = true;
                        
                } catch (SQLException e) {
                        System.out.println("Loi khi them car");
                         isSuccess = false;
                } finally {
                        
                        dbUtils.closePreparedStatement(preparedStatement);
                        dbUtils.closeConnection(conn);
                }
                return isSuccess;
        }

        @Override
        public int insertCar1(Car car) {
                connectDB = new ConnectDB();
                dbUtils = new DBUtils();
                Connection conn = connectDB.getConnection();
                PreparedStatement preparedStatement = null;
                ResultSet resultSet = null;
                int idGenerated = 0;
                try {
                        preparedStatement = conn.prepareStatement(ConstantPage.SQL_INSERT_CAR, Statement.RETURN_GENERATED_KEYS);
                        preparedStatement.setString(1, car.getMaker());
                        preparedStatement.setString(2, car.getModel());
                        preparedStatement.setString(3, car.getManufactureYear());
                        preparedStatement.setString(4, car.getColor());
                        preparedStatement.setString(5, car.getNote());
                        preparedStatement.executeUpdate();
                        resultSet =preparedStatement.getGeneratedKeys();
                        if (resultSet.next()) {
                                idGenerated = resultSet.getInt(1);
                        }
                } catch (SQLException e) {
                        System.out.println("Loi khi them car");
                        e.printStackTrace();
                        idGenerated = 0;
                } finally {
                        dbUtils.closeResultSet(resultSet);
                        dbUtils.closePreparedStatement(preparedStatement);
                        dbUtils.closeConnection(conn);
                }
                return idGenerated;
                
        }
        

}
