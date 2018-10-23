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

import org.apache.commons.codec.digest.DigestUtils;

import com.tuan.common.ConstantPage;
import com.tuan.dao.AccountDAO;
import com.tuan.model.Account;
import com.tuan.sqlserver.ConnectDB;
import com.tuan.utility.DBUtils;

/**
 * @author Tuan
 *
 */
public class AccountDAOImpl implements AccountDAO {
        private ConnectDB connectDB;
        private DBUtils dbUtils;
        // static Logger log = Logger.getLogger(AccountDAO.class);

        @Override
        public int insertAccount(Account account) {
                connectDB = new ConnectDB();
                dbUtils = new DBUtils();
                Connection conn = connectDB.getConnection();
                PreparedStatement preparedStatement = null;
                ResultSet resultSet = null;
                int idGenerated = 0;
                try {
                        preparedStatement = conn.prepareStatement(ConstantPage.SQL_INSERT_ACCOUNT
                                        , Statement.RETURN_GENERATED_KEYS);
                        preparedStatement.setString(1, account.getFullName());
                        preparedStatement.setString(2, account.getTelephoneNumber());
                        preparedStatement.setString(3, account.getEmail());
                        String pwdSHA256 =DigestUtils.sha256Hex(account.getPwd());
                        preparedStatement.setString(4, pwdSHA256);
                        preparedStatement.executeUpdate();
                        resultSet = preparedStatement.getGeneratedKeys();
                        resultSet.next();
                        idGenerated = resultSet.getInt(1);
                } catch (SQLException e) {
                        System.out.println("Khong the insert account");
                        idGenerated = 0;
                } finally {
                        dbUtils.closePreparedStatement(preparedStatement);
                        dbUtils.closeConnection(conn);
                }
                return idGenerated;
        }

        @Override
        public int selectAccountByEmailPwd(Account account) {
                connectDB = new ConnectDB();
                dbUtils = new DBUtils();
                int countFilter = 0;
                Connection conn = connectDB.getConnection();
                PreparedStatement preparedStatement = null;
                ResultSet resultSet = null;
                try {
                        preparedStatement = conn.prepareStatement(ConstantPage.SQL_SELECT_ACCOUNT_BY_EMAIL_PWD);
                        preparedStatement.setString(1, account.getEmail());
                        String pwdSHA256 =DigestUtils.sha256Hex(account.getPwd());
                        preparedStatement.setString(2, pwdSHA256);
                        resultSet = preparedStatement.executeQuery();
                        if (resultSet.next()) {
                                countFilter = 1;
                        }
                } catch (SQLException e) {
                        // log.error("Dang nhap account that bai");
                        countFilter = 0;
                } finally {
                        dbUtils.closeResultSet(resultSet);
                        dbUtils.closePreparedStatement(preparedStatement);
                        dbUtils.closeConnection(conn);
                }
                return countFilter;
        }

        @Override
        public List<Account> getListAllAccount() {
                connectDB = new ConnectDB();
                dbUtils = new DBUtils();
                Connection conn = connectDB.getConnection();
                List<Account> listAccounts = new ArrayList();
                Account account = null;
                PreparedStatement preparedStatement = null;
                ResultSet resultSet = null;
                
                try {
                        preparedStatement = conn.prepareStatement(ConstantPage.SQL_SELECT_ALL_FROM_ACCOUNT);
                        resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                                account = new Account();
                                account.setAccountID(resultSet.getInt(1));
                                account.setFullName(resultSet.getString(2));
                                account.setTelephoneNumber(resultSet.getString(3));
                                account.setEmail(resultSet.getString(4));
                                account.setPwd(resultSet.getString(5));
                                
                                listAccounts.add(account);
                        }
                } catch (SQLException e) {
                        System.out.println("Loi khi query all account");
                        e.printStackTrace();
                } finally {
                        dbUtils.closeResultSet(resultSet);
                        dbUtils.closePreparedStatement(preparedStatement);
                        dbUtils.closeConnection(conn);
                }
                return listAccounts;
        }

        @Override
        public int deleleAccountByID(int accountID) {
                connectDB = new ConnectDB();
                dbUtils = new DBUtils();
                Connection conn = connectDB.getConnection();
                PreparedStatement preparedStatement = null;
                int rowAffected = 0;
                try {
                        preparedStatement = conn.prepareStatement(ConstantPage.SQL_DELETE_ACCOUNT_BY_ID);
                        preparedStatement.setInt(1, accountID);
                        rowAffected = preparedStatement.executeUpdate();
                } catch (SQLException e) {
                        System.out.println("loi khi delete account");
                } finally {
                        dbUtils.closePreparedStatement(preparedStatement);
                        dbUtils.closeConnection(conn);
                }
                return rowAffected;
        }

        @Override
        public int updateAccount(Account account) {
                connectDB = new ConnectDB();
                dbUtils = new DBUtils();
                Connection conn = connectDB.getConnection();
                PreparedStatement preparedStatement = null;
                int rowAffected = 0;
                try {
                        preparedStatement = conn.prepareStatement(ConstantPage.SQL_UPDATE_ACCOUNT_BY_ID);
                        preparedStatement.setString(1, account.getFullName());
                        preparedStatement.setString(2, account.getTelephoneNumber());
                        preparedStatement.setString(3, account.getEmail());
                        
                        String pwdSHA256 =DigestUtils.sha256Hex(account.getPwd());
                        preparedStatement.setString(4, pwdSHA256);
                        
                        preparedStatement.setInt(5, account.getAccountID());
                        rowAffected = preparedStatement.executeUpdate();
                } catch (SQLException e) {
                        System.out.println("loi khi update account");
                } finally {
                        dbUtils.closePreparedStatement(preparedStatement);
                        dbUtils.closeConnection(conn);
                }
                
                return rowAffected;
        }
}
