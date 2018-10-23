/**
 * 
 */
package com.tuan.model;

/**
 * @author Tuan
 *
 */
public class Car {
        private int carID;
        private String maker;
        private String model;
        private String manufactureYear;
        private String color;
        private String note;
        
        public Car(int carID, String maker, String model, String manufactureYear, String color, String note) {
                super();
                this.carID = carID;
                this.maker = maker;
                this.model = model;
                this.manufactureYear = manufactureYear;
                this.color = color;
                this.note = note;
        }
        
        public Car(String maker, String model, String manufactureYear, String color, String note) {
                super();
                this.maker = maker;
                this.model = model;
                this.manufactureYear = manufactureYear;
                this.color = color;
                this.note = note;
        }

        public Car() {
                
        }
        public int getCarID() {
                return carID;
        }
        public void setCarID(int carID) {
                this.carID = carID;
        }
        public String getMaker() {
                return maker;
        }
        public void setMaker(String maker) {
                this.maker = maker;
        }
        public String getModel() {
                return model;
        }
        public void setModel(String model) {
                this.model = model;
        }
        public String getManufactureYear() {
                return manufactureYear;
        }
        public void setManufactureYear(String manufactureYear) {
                this.manufactureYear = manufactureYear;
        }
        public String getColor() {
                return color;
        }
        public void setColor(String color) {
                this.color = color;
        }
        public String getNote() {
                return note;
        }
        public void setNote(String note) {
                this.note = note;
        }
        
        
}
