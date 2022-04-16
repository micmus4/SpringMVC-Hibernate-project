<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tagLib"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

    <head>
        <title> Team Manager - Spring MVC + Hibernate project </title>
    </head>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add_footballer-style.css"/>

    <body>

        <div id="divHeaderWrapper">
            <div id="divHeader">
                <h1>Team Manager - Spring MVC + Hibernate project</h1>
            </div>
        </div>

        <div id="divContentWrapper">
            <div id="divContentForAddFootballer" class="ignore-css">
                <h3>Adding Footballer</h3>

                <form:form action="addFootballer"
                           modelAttribute="newFootballer"
                           method="POST">

                    <table>
                        <tbody>
                            <tr>
                                <td><label>First Name:</label></td>
                                <td><form:input path="firstName"/></td>
                            </tr>
                            <tr>
                                <td><label>Last Name:</label></td>
                                <td><form:input path="lastName"/></td>
                            </tr>
                            <tr>
                                <td><label>Club:</label></td>
                                <td><form:input path="club"/></td>
                            </tr>
                            <tr>
                                <td><label>Weekly Wage (€):</label></td>
                                <td><form:input path="weeklyWage"/></td>
                            </tr>
                            <tr>
                                <td><label>Contract Expiration Date:</label></td>
                                <td><form:input type="date"
                                                path="contractExpirationDate"/></td>
                            </tr>
                            <tr>
                                <td><label>Height (cm):</label></td>
                                <td><form:input path="height"/></td>
                            </tr>
                            <tr>
                                <td><label>Weight (kg):</label></td>
                                <td><form:input path="weight"/></td>
                            </tr>
                            <tr>
                                <td><label></label></td>
                                <td>
                                    <input type="submit"
                                           value="Add Footballer"/>
                                </td>
                            </tr>
                        </tbody>
                    </table>

                </form:form>
            </div>
        </div>

    <div id="goBackDiv">
        <p>
            <a href="/displayFootballers">Go back to list</a>
        </p>
    </div>

    </body>
</html>