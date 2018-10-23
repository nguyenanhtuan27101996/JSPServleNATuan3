/**
 * 
 */
package com.tuan.service;

import java.util.List;

import com.tuan.model.Account;

/**
 * @author Tuan
 *
 */
public interface AccountService {

        int registerAccount(Account account);
        boolean loginAccount(Account account);
        List<Account> getListAllAccount();
        boolean deleteAccount(int accountID);
        boolean updateAccount(Account account);
}
