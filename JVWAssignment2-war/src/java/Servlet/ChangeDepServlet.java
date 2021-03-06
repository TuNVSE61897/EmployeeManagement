/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DepartmentBean.DepartmentSessionBeanRemote;
import EmployeeBean.EmployeeSessionBeanRemote;
import Entity.TblEmployee;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ChangeDepServlet extends HttpServlet {

    private final String changeDepSuccess = "ChangeDepSuccess.html";

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

            String empChosenID = request.getParameter("txtUserChosenID");
            String dName = request.getParameter("cbDep");
            String sSalary = request.getParameter("txtSalary");
            float salary = 0;
            String url = "ProcessServlet?btAction=Change";
            boolean error = false;

            try {
                salary = Float.parseFloat(sSalary);
            } catch (Exception e) {
                request.setAttribute("CHANGESALARY", "Salary must be a float number!");
                error = true;
            }

            if (!error) {
                Context context = new InitialContext();
                EmployeeSessionBeanRemote empObj = (EmployeeSessionBeanRemote) 
                        context.lookup("EmployeeJNDI");
                DepartmentSessionBeanRemote depObj = (DepartmentSessionBeanRemote) 
                        context.lookup("DepartmentJNDI");
                boolean result = empObj.changeDep(empChosenID, depObj.getDepID(dName), salary);
                url = changeDepSuccess;
            }

            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);

        } catch (NamingException ex) {
            log("Change_Name " + ex.getMessage());
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
