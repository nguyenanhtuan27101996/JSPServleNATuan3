/**
 * 
 */
package com.tuan.model;

/**
 * @author Tuan
 *
 */
public class CarOrder {
        private int orderID;
        private int customerID;
        private int carID;
        private int amount;
        private float salePrice;
        private String orderDate;
        private String deliveryDate;
        private int orderStatus;
        private String note;
        public CarOrder(int orderID, int customerID, int carID, int amount, float salePrice, String orderDate,
                        String deliveryDate, int orderStatus, String note) {
                super();
                this.orderID = orderID;
                this.customerID = customerID;
                this.carID = carID;
                this.amount = amount;
                this.salePrice = salePrice;
                this.orderDate = orderDate;
                this.deliveryDate = deliveryDate;
                this.orderStatus = orderStatus;
                this.note = note;
        }
        public CarOrder() {
                super();
        }
        public int getOrderID() {
                return orderID;
        }
        public void setOrderID(int orderID) {
                this.orderID = orderID;
        }
        public int getCustomerID() {
                return customerID;
        }
        public void setCustomerID(int customerID) {
                this.customerID = customerID;
        }
        public int getCarID() {
                return carID;
        }
        public void setCarID(int carID) {
                this.carID = carID;
        }
        public int getAmount() {
                return amount;
        }
        public void setAmount(int amount) {
                this.amount = amount;
        }
        public float getSalePrice() {
                return salePrice;
        }
        public void setSalePrice(float salePrice) {
                this.salePrice = salePrice;
        }
        public String getOrderDate() {
                return orderDate;
        }
        public void setOrderDate(String orderDate) {
                this.orderDate = orderDate;
        }
        public String getDeliveryDate() {
                return deliveryDate;
        }
        public void setDeliveryDate(String deliveryDate) {
                this.deliveryDate = deliveryDate;
        }
        public int getOrderStatus() {
                return orderStatus;
        }
        public void setOrderStatus(int orderStatus) {
                this.orderStatus = orderStatus;
        }
        public String getNote() {
                return note;
        }
        public void setNote(String note) {
                this.note = note;
        }
        
        
}
