<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="ISO-8859-1">
            <title>Homepage</title>
            <link rel="stylesheet" href="style.css">
        </head>

        <body>
            <h1>Homepage</h1>
            <div class="center homepage">
                <h3>Welcome ${role} ${username} </h3>

                <c:if test="${role.equals('agent')}">
                </c:if>
                <c:if test="${role.equals('insured')}">
                </c:if>

                <c:if test="${role.equals('admin')}">
                    <a href="UserCreation"><button>Create new user</button> </a> <br>
                </c:if>

                <c:choose>
                    <c:when test="${role.equals('insured')}">
                        <c:if test="${account.equals('not created')}">
                            <a href="AccountCreation"><button>Create New Account</button></a><br>
                        </c:if>
                    </c:when>
                    <c:otherwise>
                        <a href="AccountCreation"><button>Create New Account</button></a><br>
                    </c:otherwise>
                </c:choose>


                <c:if test="${!role.equals('insured')}">
                    <a href="PolicyCreation"><button>Policy Creation</button></a><br>
                </c:if>

                <a href="ViewPolicy"><button>View Policy</button></a> <br>

                <c:if test="${role.equals('admin')}">
                    <button>report Generation</button><br>
                </c:if>

                <a href="Logout">
                    <button>Logout</button>
                </a>
            </div>
        </body>

        </html>