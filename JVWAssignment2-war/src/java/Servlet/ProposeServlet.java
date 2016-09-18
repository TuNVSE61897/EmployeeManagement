/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import EmployeeBean.EmployeeSessionBeanRemote;
import Entity.TblEmployee;
import Leave.LeaveError;
import LeaveBean.LeaveSessionBeanRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class ProposeServlet extends HttpServlet {

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
            String empID = (String) session.getAttribute("USER");
            String sFrom = request.getParameter("txtFrom");
            String sTo = request.getParameter("txtTo");


            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date from1 = sdf.parse(sFrom);
            Date to1 = sdf.parse(sTo);
            Date today = new Date();

            java.sql.Date from2 = new java.sql.Date(from1.getTime());
            java.sql.Date to2 = new java.sql.Date(to1.getTime());

            long hours = (to1.getTime() - from1.getTime()) / 1000 / 60 / 60 / 3;

            LeaveError leaveErrors = new LeaveError();
            boolean error = false;

            if (hours <= 0) {
                leaveErrors.setDateInvalidError("Your chosen date is invalid!");
                error = true;
            }
            if (from1.before(today) || to1.before(today)) {
                leaveErrors.setCurrentDateError("Your chosen date is before current date!");
                error = true;
            }

            if (error) {
                request.setAttribute("LEAVEERR", leaveErrors);
            } else {
                Context context = new InitialContext();
                LeaveSessionBeanRemote leaveObj = (LeaveSessionBeanRemote) 
                        context.lookup("LeaveJNDI");
                leaveObj.propose(empID, from2, to2);
                request.setAttribute("PROPOSE", "Your request is submitted successfully!");
                request.setAttribute("HOURS", hours);
            }

            String urlRewrite = "ProcessServlet?btAction=View Profile";
            RequestDispatcher rd = request.getRequestDispatcher(urlRewrite);
            rd.forward(request, response);

        } catch (NamingException ex) {
            log("Propose_Name " + ex.getMessage());
        } catch (ParseException ex) {
            log("Propose_Parse " + ex.getMessage());
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
