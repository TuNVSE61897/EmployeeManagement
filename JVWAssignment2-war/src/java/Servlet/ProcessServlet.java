/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DepartmentBean.DepartmentSessionBeanRemote;
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
import java.util.List;

/**
 *
 * @author Tu Nguyen
 */
public class ProcessServlet extends HttpServlet {

    private final String loginPage = "Login.html";
    private final String loginServlet = "LoginServlet";
    private final String viewProfileServlet = "ViewProfileServlet";
    private final String proposeServlet = "ProposeServlet";
    private final String updateServlet = "UpdateServlet";
    private final String searchServlet = "SearchServlet";
    private final String changeDepServlet = "ChangeDepServlet";
    private final String changeDepPage = "ChangeDep.jsp";
    private final String acceptServlet = "AcceptServlet";
    private final String logoutServlet = "LogoutServlet";

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
            String url = loginPage;
            String button = request.getParameter("btAction");
            Context context = new InitialContext();

            if (button == null) {
                url = loginPage;
            } else if (button.equals("Login")) {
                url = loginServlet;
            } else if (button.equals("View Profile")) {
                url = viewProfileServlet;
            } else if (button.equals("Update")) {
                url = updateServlet;
            } else if (button.equals("Propose")) {
                url = proposeServlet;
            } else if (button.equals("Search")) {
                url = searchServlet;
            } else if (button.equals("Change")) {
                DepartmentSessionBeanRemote depObj = (DepartmentSessionBeanRemote) 
                        context.lookup("DepartmentJNDI");
                List result = depObj.loadListDep();
                request.setAttribute("LISTDEP", result);
                url = changeDepPage;
            } else if (button.equals("Confirm")) {
                url = changeDepServlet;
            } else if ((button.equals("Accept")) || (button.equals("Reject"))) {
                url = acceptServlet;
            } else if (button.equals("Logout")) {
                url = logoutServlet;
            }

            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (NamingException ex) {
            log("Process _ Name " + ex.getMessage());
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
