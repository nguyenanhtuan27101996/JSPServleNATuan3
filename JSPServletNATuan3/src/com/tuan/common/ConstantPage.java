/**
 * 
 */
package com.tuan.common;

/**
 * @author User
 * @creatdate Oct 22, 2018
 * @modifieddate Oct 22, 2018
 * @content ...
 */
public class ConstantPage {
        public static final String SQL_DELETE_CAR_BY_ID = "delete from Car where CarID = ?";
        public static final String SQL_UPDATE_CAR_BY_ID = "update Car set Maker = ?, Model = ?,"
                        + " ManufactureYear = ?, Color = ?, Note = ? where CarID = ?";
        public static final String SQL_INSERT_CAR = "insert into Car(Maker,Model,ManufactureYear,"
                        + "Color,Note) values (?,?,?,?,?)";
        public static final String SQL_INSERT_ACCOUNT = "insert into Account"
                        + "(FullName,TelephoneNumber,Email,Pwd) values(?,?,?,?)";
        public static final String SQL_SELECT_ACCOUNT_BY_EMAIL_PWD = 
                        "select AccountID from Account where Email = ? and Pwd = ?";
        public static final String SQL_SELECT_ALL_FROM_ACCOUNT = "select AccountID,FullName,TelephoneNumber,"
                        + "Email,Pwd from Account";
        
        public static final String SQL_DELETE_ACCOUNT_BY_ID = "delete from Account where AccountID = ?";
        
        public static final String SQL_UPDATE_ACCOUNT_BY_ID = "update Account set FullName = ?,"
                        + "TelephoneNumber = ?,Email = ?,Pwd=? where AccountID = ?";
        
}
