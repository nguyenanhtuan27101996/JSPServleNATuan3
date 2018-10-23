/**
 * 
 */
package com.tuan.utility;

import javax.servlet.http.HttpSession;

import com.tuan.model.Account;

/**
 * @author Tuan
 *
 */
public class MyUtility {
        public static void storeLoginedUser(HttpSession session, Account loginedUser) {
                // access by ${loginedUser}
                session.setAttribute("loginedUser", loginedUser);
        }
}
