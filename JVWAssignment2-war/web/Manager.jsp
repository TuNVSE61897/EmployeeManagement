<%-- 
    Document   : manager
    Created on : Apr 5, 2016, 9:01:45 PM
    Author     : Binh Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Page</title>
    </head>
    <body>
        <font color="red"> Welcome, ${sessionScope.USER} </font>
        <a href="ProcessServlet?btAction=Logout">Logout</a><br>
        <h1>Manager Control Page</h1>


        <c:set var="dep" value="${sessionScope.DEPNAME}"/>
        <c:set var="countemps" value="${sessionScope.COUNTEMP}"/>

        <form action="ProcessServlet">
            <table border="0" width="800" >
                <thead>
                    <tr>
                        <th><h3>
                                Department Name: ${dep}

                            </h3></th>

                        <th><h3>Total of Employee: ${countemps}</h3></th>
                            <c:url var="viewProfileLink" value="ProcessServlet">
                                <c:param name="btAction" value="View Profile"/>
                            </c:url>
                        <th><h3><a href="${viewProfileLink}">View Profile</a></h3></th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td colspan="3">
                            Name/ID: <input type="text" name="txtSearch" value="${param.txtSearch}" /> 
                            <input type="submit" value="Search" name="btAction" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>

        <c:set var="listEmps" value="${requestScope.SEARCH}"/>

        <c:if test="${empty listEmps}">
            <font color="red">No record is matched!</font>
        </c:if>
        <br>

        <c:if test="${not empty listEmps}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>employeeID</th>
                        <th>Name</th>
                        <th>Salary</th>
                        <th>Address</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Status</th>
                        <th>Update</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="anEmp" items="${listEmps}" varStatus="counter">
                    <form action="ProcessServlet">

                        <tr>
                            <td>${counter.count}</td>
                            <td>
                                ${anEmp.employeeID}
                                <input type="hidden" name="txtUserChosenID" value="${anEmp.employeeID}" />
                            </td>
                            <td>${anEmp.name}</td>
                            <td>
                                ${anEmp.salary}
                                <input type="hidden" name="txtSalary" value="${anEmp.salary}" />
                            </td>
                            <td>${anEmp.address}</td>
                            <td>${anEmp.email}</td>
                            <td>${anEmp.phone}</td>
                            <td>${anEmp.status}</td>
                            <td>
                                <c:if test="${anEmp.status eq 1}">
                                    <c:url var="acceptLink" value="ProcessServlet">
                                        <c:param name="btAction" value="Accept"/>
                                        <c:param name="eID" value="${anEmp.employeeID}"/>
                                        <c:param name="lastSearchValue" value="${param.txtSearch}"/>
                                    </c:url>

                                    <c:url var="rejectLink" value="ProcessServlet">
                                        <c:param name="btAction" value="Reject"/>
                                        <c:param name="eID" value="${anEmp.employeeID}"/>
                                        <c:param name="lastSearchValue" value="${param.txtSearch}"/>
                                    </c:url>
                                    <a href="${acceptLink}">Accept</a> / <a href="${rejectLink}">Reject</a>
                                </c:if>

                                <c:if test="${anEmp.status eq 0}">
                                    Rejected
                                </c:if>

                                <c:if test="${anEmp.status eq 2}">
                                    Accepted
                                </c:if>

                            </td> 
                            <td>
                                <input type = "submit" value = "Change" name = "btAction" />
                                <input type = "hidden" value = "${param.txtSearch}" name="lastSearchValue" />
                            </td>
                        </tr>

                    </form>
                </c:forEach>

            </tbody>
        </table>
    </c:if>



</body>
</html>
