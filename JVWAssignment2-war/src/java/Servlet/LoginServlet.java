/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import AccountBean.AccountSessionBeanRemote;
import DepartmentBean.DepartmentSessionBeanRemote;
import EmployeeBean.EmployeeSessionBeanRemote;
import Entity.TblEmployee;
import java.io.IOException;
import java.io.PrintWriter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tu Nguyen
 */
public class LoginServlet extends HttpServlet {

    private final String loginPage = "Login.jsp";
    private final String invalidPage = "Invalid.html";
    private final String managerPage = "Manager.jsp";
    private final String employeePage = "Employee.jsp";
    private final String viewProfileServlet = "ViewProfileServlet";
    private final String managerServlet = "ManagerServlet";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String url = invalidPage;

            boolean empty = false;
            if (username.isEmpty()) {
                request.setAttribute("EMPTYUSERNAME", "Please input Username!");
                empty = true;
            }
            if (password.isEmpty()) {
                request.setAttribute("EMPTYPASSWORD", "Please input Password!");
                empty = true;
            }

            if (empty) {
                url = loginPage;
            } else {
                Context context = new InitialContext();
                AccountSessionBeanRemote accountObj = (AccountSessionBeanRemote) context.lookup("AccountJNDI");

                boolean result = accountObj.checkLogin(username, password);

                if (result) {
                    HttpSession session = request.getSession();
                    session.setAttribute("USER", username);

                    boolean role = accountObj.isManager(username);
                    session.setAttribute("ROLE", role);

                    DepartmentSessionBeanRemote depObj = (DepartmentSessionBeanRemote) 
                            context.lookup("DepartmentJNDI");;
                    EmployeeSessionBeanRemote empObj = (EmployeeSessionBeanRemote) 
                            context.lookup("EmployeeJNDI");
                    TblEmployee emp = empObj.getOneEmployee(username);
                    String depName = depObj.getDepName(emp.getDepID());
                    session.setAttribute("DEPID", emp.getDepID());
                    session.setAttribute("DEPNAME", depName);

                    if (role) {
                        url = managerServlet;
                    } else {
                        url = viewProfileServlet;
                    }
                }

            }

            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);

        } catch (NamingException ex) {
            log("Login_Name " + ex.getMessage());
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
