<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="ISO-8859-1">
            <title>Insert title here</title>
            <link rel="stylesheet" href="style.css">
        </head>

        <body>
            <div class="center">
                <h1>Account Creation Page</h1>
                <form action="AccountCreation" method="post">
                    Enter Insured name <br>
                    <input type="text" name="insured_name" id="" required><br>
                    Enter Insured street <br>
                    <input type="text" name="insured_street" id="" required><br>
                    Enter Insured city <br>
                    <input type="text" name="insured_city" id="" required><br>
                    Enter Insured state <br>
                    <input type="text" name="insured_state" id="" required><br>
                    Enter Insured zip <br>
                    <input type="number" name="insured_zip" id="" required><br>

                    Business Segment <br>
                    <select name=business_segment>
                        <c:forEach var="bus_seg" items="${business_segments}">
                            <option value="${bus_seg.bus_seg_id}"> ${bus_seg.bus_seg_name}</option>
                        </c:forEach>
                    </select>


                    <br> Insured ID<br>
                    <c:choose>
                        <c:when test="${role.equals('insured')}">
                            <input type="text" name="insured" id="" value="${username}" readonly>
                        </c:when>
                        <c:otherwise>
                            <select name="insured">
                                <c:forEach var="insured" items="${insureds}">
                                    <option value="${insured.user_name}"> ${insured.user_name}</option>
                                </c:forEach>
                            </select>
                        </c:otherwise>
                    </c:choose>

                    <br> Agent ID<br>
                    <c:choose>
                        <c:when test="${role.equals('agent')}">
                            <input type="text" name="agent" id="" value="${username}" readonly>
                        </c:when>
                        <c:otherwise>
                            <select name="agent">
                                <c:forEach var="agent" items="${agents}">
                                    <option value="${agent.user_name}"> ${agent.user_name}</option>
                                </c:forEach>
                            </select>
                        </c:otherwise>
                    </c:choose>

                    <br>
                    <button type="submit">Submit</button>
                </form>
                <br>
                <a href="Homepage"> <button> Go Back to Homepage </button></a>
            </div>
        </body>

        </html>