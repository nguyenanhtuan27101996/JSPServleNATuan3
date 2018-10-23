package com.tuan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tuan.model.Account;
import com.tuan.service.AccountService;
import com.tuan.serviceimpl.AccountServiceImpl;
import com.tuan.utility.MyUtility;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        private AccountService accountService;

        /**
         * @see HttpServlet#HttpServlet()
         */
        public MainServlet() {
                super();
                // TODO Auto-generated constructor stub
        }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
         *      response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                response.setContentType("application/json");

                String email = request.getParameter("email");
                String pwd = request.getParameter("pwd");

                PrintWriter out = response.getWriter();
                accountService = new AccountServiceImpl();
                Account account = new Account();
                account.setEmail(email);
                account.setPwd(pwd);
                boolean checkLogin = accountService.loginAccount(account);
                HttpSession httpSession = request.getSession();
                MyUtility.storeLoginedUser(httpSession, account);
                out.print(checkLogin);
                out.flush();
        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
         *      response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                // doGet(request, response);
                response.setContentType("application/json");
                String fullName = request.getParameter("fullName");
                String telephoneNumber = request.getParameter("telephoneNumber");
                String email = request.getParameter("email");
                String pwd = request.getParameter("pwd");

                PrintWriter out = response.getWriter();

                accountService = new AccountServiceImpl();
                Account account = new Account();
                account.setFullName(fullName);
                account.setTelephoneNumber(telephoneNumber);
                account.setEmail(email);
                account.setPwd(pwd);

                int checkRegister = accountService.registerAccount(account);
                out.print(checkRegister);
                out.flush();

        }

}
