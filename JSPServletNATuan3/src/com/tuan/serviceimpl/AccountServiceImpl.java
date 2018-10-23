/**
 * 
 */
package com.tuan.serviceimpl;

import java.util.List;

import com.tuan.dao.AccountDAO;
import com.tuan.daoimpl.AccountDAOImpl;
import com.tuan.model.Account;
import com.tuan.service.AccountService;

/**
 * @author Tuan
 *
 */
public class AccountServiceImpl implements AccountService {
        private AccountDAO accountDAO;
        @Override
        public int registerAccount(Account account) {
                accountDAO = new AccountDAOImpl();
                return accountDAO.insertAccount(account);
        }
        @Override
        public boolean loginAccount(Account account) {
                accountDAO = new AccountDAOImpl();
                int countFilter = accountDAO.selectAccountByEmailPwd(account);
                if (countFilter == 1) {
                        return true;
                }
                return false;
        }
        @Override
        public List<Account> getListAllAccount() {
                accountDAO = new AccountDAOImpl();
                return accountDAO.getListAllAccount();
        }
        @Override
        public boolean deleteAccount(int accountID) {
                accountDAO = new AccountDAOImpl();
                int rowDeleted = accountDAO.deleleAccountByID(accountID);
                if (rowDeleted == 1) {
                        return true;
                }
                return false;
        }
        @Override
        public boolean updateAccount(Account account) {
                accountDAO = new AccountDAOImpl();
                int rowUpdated = accountDAO.updateAccount(account);
                if (rowUpdated == 1) {
                        return true;
                }
                return false;
        }
}
