package com.tuan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tuan.model.Car;
import com.tuan.service.CarService;
import com.tuan.serviceimpl.CarServiceImpl;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        private CarService carService;

        /**
         * @see HttpServlet#HttpServlet()
         */
        public HomeServlet() {
                super();
                // TODO Auto-generated constructor stub
        }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
         *      response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                carService = new CarServiceImpl();
                List<Car> listCar = carService.getAllListCar();
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/HomePage.jsp");

                request.setAttribute("listCar", listCar);

                requestDispatcher.forward(request, response);
        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
         *      response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                // doGet(request, response);
                String method = request.getParameter("method");
                if ("deleteCar".equals(method)) {
                        deleteCar(request, response);
                } else if ("updateCar".equals(method)) {
                        updateCar(request, response);
                } else if ("insertCar".equals(method)) {
                        insertCar(request, response);
                }
        }
        public void deleteCar(HttpServletRequest request, HttpServletResponse response) throws IOException {
                PrintWriter out = response.getWriter();
                String sCarID = request.getParameter("carID");
                int carID = Integer.parseInt(sCarID);
                carService = new CarServiceImpl();
                boolean isDeleted = carService.deleteCar(carID);
                out.print(isDeleted);
                out.flush();
        }
        public void updateCar(HttpServletRequest request, HttpServletResponse response) throws IOException {
                PrintWriter out = response.getWriter();
                String sCarID = request.getParameter("carID");
                String maker = request.getParameter("maker");
                String model = request.getParameter("model");
                String manufactureYear = request.getParameter("manufactureYear");
                String color = request.getParameter("color");
                String note = request.getParameter("note");
                int carID = Integer.parseInt(sCarID);
                Car car = new Car(carID, maker, model, manufactureYear, color, note);
                System.out.println(car.getCarID() + car.getMaker()+car.getModel()+car.getManufactureYear()+car.getColor()+car.getNote());
                carService = new CarServiceImpl();
                boolean isUpdated = carService.updateCar(car);
                out.print(isUpdated);
                out.flush();

        }
        public void insertCar(HttpServletRequest request, HttpServletResponse response) throws IOException {
                PrintWriter out = response.getWriter();
                String maker = request.getParameter("maker");
                String model = request.getParameter("model");
                String manufactureYear = request.getParameter("manufactureYear");
                String color = request.getParameter("color");
                String note = request.getParameter("note");
                Car car = new Car(maker, model, manufactureYear, color, note);
                carService = new CarServiceImpl();
                //boolean isInserted = carService.insertCar(car);
                int idInserted = carService.insertCar1(car);
                //out.print(isInserted);
                out.print(idInserted);
                out.flush();

        }
        
}
