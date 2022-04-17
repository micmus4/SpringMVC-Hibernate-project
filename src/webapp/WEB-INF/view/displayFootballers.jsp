<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tagLib"%>
<%@ taglib prefix="taglib" uri="http://java.sun.com/jsp/jstl/core" %>
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

                <form action="${pageContext.request.contextPath}/addOrUpdateFootballer" method="GET">
                    <button name="eventType" value="add">Add Footballer</button>
                </form>

                <table>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Club</th>
                        <th>Weekly Wage (€)</th>
                        <th>Contract Expires</th>
                        <th>Height (cm)</th>
                        <th>Weight (kg)</th>
                        <th>Action</th>
                    </tr>

                    <tagLib:forEach var="currentFootballer" items="${footballers}">

                        <tagLib:url var="updateFootballer" value="addOrUpdateFootballer">
                            <tagLib:param name="eventType" value="update"/>
                            <tagLib:param name="footballerId" value="${currentFootballer.id}"/>
                        </tagLib:url>

                        <tr>
                            <td>${currentFootballer.firstName}</td>
                            <td>${currentFootballer.lastName}</td>
                            <td>${currentFootballer.club}</td>
                            <td>${currentFootballer.weeklyWage}</td>
                            <td>${currentFootballer.contractExpirationDate}</td>
                            <td>${currentFootballer.height}</td>
                            <td>${currentFootballer.weight}</td>
                            <td><a href="${updateFootballer}">Update</a></td>
                        </tr>
                    </tagLib:forEach>
                </table>
            </div>
        </div>

    </body>
</html>