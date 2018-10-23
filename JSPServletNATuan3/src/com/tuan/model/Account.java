/**
 * 
 */
package com.tuan.model;

/**
 * @author Tuan
 *
 */
public class Account {
        private int accountID;
        private String fullName;
        private String telephoneNumber;
        private String email;
        private String pwd;
        public Account() {
        }
        public Account(int accountID, String fullName, String telephoneNumber, String email, String pwd) {
                super();
                this.accountID = accountID;
                this.fullName = fullName;
                this.telephoneNumber = telephoneNumber;
                this.email = email;
                this.pwd = pwd;
        }
        
        public Account(String fullName, String telephoneNumber, String email, String pwd) {
                super();
                this.fullName = fullName;
                this.telephoneNumber = telephoneNumber;
                this.email = email;
                this.pwd = pwd;
        }
        public int getAccountID() {
                return accountID;
        }
        public void setAccountID(int accountID) {
                this.accountID = accountID;
        }
        public String getFullName() {
                return fullName;
        }
        public void setFullName(String fullName) {
                this.fullName = fullName;
        }
        public String getTelephoneNumber() {
                return telephoneNumber;
        }
        public void setTelephoneNumber(String telephoneNumber) {
                this.telephoneNumber = telephoneNumber;
        }
        public String getEmail() {
                return email;
        }
        public void setEmail(String email) {
                this.email = email;
        }
        public String getPwd() {
                return pwd;
        }
        public void setPwd(String pwd) {
                this.pwd = pwd;
        }
        
}
