/**
 * 
 */
package com.tuan.model;

/**
 * @author Tuan
 *
 */
public class Customer {
        private int customerID;
        private String name;
        private String phone;
        private String email;
        private String customerAddress;
        private String note;
        public Customer(int customerID, String name, String phone, String email, String customerAddress, String note) {
                super();
                this.customerID = customerID;
                this.name = name;
                this.phone = phone;
                this.email = email;
                this.customerAddress = customerAddress;
                this.note = note;
        }
        public Customer() {
                super();
        }
        public int getCustomerID() {
                return customerID;
        }
        public void setCustomerID(int customerID) {
                this.customerID = customerID;
        }
        public String getName() {
                return name;
        }
        public void setName(String name) {
                this.name = name;
        }
        public String getPhone() {
                return phone;
        }
        public void setPhone(String phone) {
                this.phone = phone;
        }
        public String getEmail() {
                return email;
        }
        public void setEmail(String email) {
                this.email = email;
        }
        public String getCustomerAddress() {
                return customerAddress;
        }
        public void setCustomerAddress(String customerAddress) {
                this.customerAddress = customerAddress;
        }
        public String getNote() {
                return note;
        }
        public void setNote(String note) {
                this.note = note;
        }
        
}
