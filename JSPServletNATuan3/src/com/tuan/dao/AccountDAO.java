/**
 * 
 */
package com.tuan.dao;

import java.util.List;

import com.tuan.model.Account;

/**
 * @author Tuan
 *
 */
public interface AccountDAO {

        /**
         * @author Tuan
         * @content return id of account inserted
         * @param account
         * @return int
         */
        int insertAccount(Account account);

        /**
         * @author Tuan
         * @content return count row that filtered
         * @param account
         * @return int
         */
        int selectAccountByEmailPwd(Account account);

        /**
         * @author Tuan
         * @content return list of all account
         * @return list
         */
        List<Account> getListAllAccount();

        /**
         * @author Tuan
         * @content return number row affected in table account
         * @param accountID
         * @return int
         */
        int deleleAccountByID(int accountID);
        
        int updateAccount(Account account);
}
