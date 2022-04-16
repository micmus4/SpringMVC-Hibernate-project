<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tagLib"%>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

    <head>
        <title> Team Manager - Spring MVC + Hibernate project </title>
    </head>

    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>

    <body>

        <div id="divHeaderWrapper">
            <div id="divHeader">
                <h1>Team Manager - Spring MVC + Hibernate project</h1>
            </div>
        </div>

        <div id="divContentWrapper">
            <div id="divContent">

                <input type="button"
                       value="Add Footballer"
                       onclick="window.location.href='${pageContext.request.contextPath}/addFootballer'"
                       class="add-button">

                <table>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Club</th>
                        <th>Weekly Wage (€)</th>
                        <th>Contract Expires</th>
                        <th>Height (cm)</th>
                        <th>Weight (kg)</th>
                    </tr>

                    <tagLib:forEach var="currentFootballer" items="${footballers}">
                        <tr>
                            <td>${currentFootballer.firstName}</td>
                            <td>${currentFootballer.lastName}</td>
                            <td>${currentFootballer.club}</td>
                            <td>${currentFootballer.weeklyWage}</td>
                            <td>${currentFootballer.contractExpirationDate}</td>
                            <td>${currentFootballer.height}</td>
                            <td>${currentFootballer.weight}</td>
                        </tr>
                    </tagLib:forEach>
                </table>
            </div>
        </div>

    </body>
</html>