/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Employee.UpdateError;
import EmployeeBean.EmployeeSessionBeanRemote;
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
 * @author Binh Nguyen
 */
public class UpdateServlet extends HttpServlet {

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
            HttpSession session = request.getSession();
            String eID = (String) session.getAttribute("USER");
            String add = request.getParameter("txtAdr");
            String email = request.getParameter("txtEmail");
            String phone = request.getParameter("txtPhone");
            String family = request.getParameter("txtFamily");

            boolean error = false;
            UpdateError errors = new UpdateError();

            if (add.trim().length() < 1 || add.trim().length() > 20) {
                errors.setAddressLengthError("Address has 1-20 characters");
                error = true;
            }
            if (email.trim().length() < 1 || email.trim().length() > 30) {
                errors.setEmailLengthError("Email has 1-30 characters");
                error = true;
            }
            if (phone.trim().length() < 1 || phone.trim().length() > 11) {
                errors.setPhoneLengthError("Phone has 1-11 characters");
                error = true;
            }
            if (family.trim().length() < 1 || family.trim().length() > 20) {
                errors.setFamilyLengthErrror("Family has 1-20 characters");
                error = true;
            }

            if (error) {
                request.setAttribute("UPDATEERR", errors);
            } else {
                Context context = new InitialContext();
                EmployeeSessionBeanRemote empObj = (EmployeeSessionBeanRemote) 
                        context.lookup("EmployeeJNDI");

                boolean result = empObj.updateEmployee(eID, add, email, phone, family);

                if (result) {
                    request.setAttribute("UPDATESUCCESS", "Update successfully!");
                } 
            }

            String urlRewrite = "ProcessServlet?btAction=View Profile";

            RequestDispatcher rd = request.getRequestDispatcher(urlRewrite);
            rd.forward(request, response);

        } catch (NamingException ex) {
            log("Update_Name " + ex.getMessage());
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
