package com.tuan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tuan.model.Account;
import com.tuan.service.AccountService;
import com.tuan.serviceimpl.AccountServiceImpl;

/**
 * Servlet implementation class AccountServlet
 */

public class AccountServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        private AccountService accountService;

        /**
         * @see HttpServlet#HttpServlet()
         */
        public AccountServlet() {
                super();
                // TODO Auto-generated constructor stub
        }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
         *      response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/AccountPage.jsp");
                accountService = new AccountServiceImpl();
                List<Account> listAccount = accountService.getListAllAccount();
                request.setAttribute("listAccount", listAccount);
                dispatcher.forward(request, response);
        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
         *      response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                // TODO Auto-generated method stub
                // doGet(request, response);
                String method = request.getParameter("method");
                if ("deleteAccount".equals(method)) {
                        deleteAccount(request, response);
                } else if ("updateAccount".equals(method)) {
                        updateAccount(request, response);
                } else if ("insertAccount".equals(method)) {
                        insertAccount(request, response);
                }

        }

        /**
         * @author Tuan
         * @content delete account 
         * @param request
         * @param response
         * @throws ServletException
         * @throws IOException
         */
        public void deleteAccount(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                PrintWriter out = response.getWriter();
                // get parameter from user input
                String sAccountID = request.getParameter("accountID");
                int accountID = Integer.parseInt(sAccountID);

                // init accountService and call method deleteAccount
                accountService = new AccountServiceImpl();
                boolean isDeleted = accountService.deleteAccount(accountID);
                out.print(isDeleted);
                out.flush();
        }

        
        /**
         * @author Tuan
         * @content update account
         * @param request
         * @param response
         * @throws ServletException
         * @throws IOException
         */
        public void updateAccount(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                PrintWriter out = response.getWriter();

                // get parameter from user input
                String sAccountID = request.getParameter("accountID");
                int accountID = Integer.parseInt(sAccountID);
                String fullName = request.getParameter("fullName");
                String telephoneNumber = request.getParameter("telephoneNumber");
                String email = request.getParameter("email");
                String pwd = request.getParameter("pwd");

                // put parameter to account
                Account account = new Account(accountID, fullName, telephoneNumber, email, pwd);
                // init accountService and call method updateAccount
                accountService = new AccountServiceImpl();
                boolean isUpdated = accountService.updateAccount(account);
                out.print(isUpdated);
                out.flush();
        }

        /**
         * @author Tuan
         * @content insert account
         * @param request
         * @param response
         * @throws ServletException
         * @throws IOException
         */
        public void insertAccount(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                PrintWriter out = response.getWriter();
                // get parameter from user input
                String fullName = request.getParameter("fullName");
                String telephoneNumber = request.getParameter("telephoneNumber");
                String email = request.getParameter("email");
                String pwd = request.getParameter("pwd");

                // put parameter to account
                Account account = new Account(fullName, telephoneNumber, email, pwd);
                // init accountService and call method registerAccount
                accountService = new AccountServiceImpl();
                int isInserted = accountService.registerAccount(account);

                out.println(isInserted);
                out.flush();
        }
}
