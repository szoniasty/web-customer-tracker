<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>


<html>
<head>
    <title>List Customers</title>

    <%-- reference our style sheet --%>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
    <div id="container">
        <div id="content">
            <div id="menu">
                <input type="button" value="Add Customer"
                       onclick="window.location.href='showFormForAdd'; return false;"
                       class="add-button"
                />
                <form:form method="get" action="showFormForSearch">
                <input type="text"
                       id="searchParam"
                       name="searchParam"
                />
                <input type="submit"
                       value="Search"
                       class="add-button"
                />
                </form:form>
            </div>
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="tmpCustomer" items="${customers}">
                    <c:url var="update_link" value="/showFormForUpdate">
                        <c:param name="customerId" value="${tmpCustomer.id}" />
                    </c:url>
                    <c:url var="delete_link" value="/delete">
                        <c:param name="customerId" value="${tmpCustomer.id}" />
                    </c:url>
                    <tr>
                        <td>${tmpCustomer.firstName}</td>
                        <td>${tmpCustomer.lastName}</td>
                        <td>${tmpCustomer.email}</td>
                        <td><a href="${update_link}">Update</a>
                            |
                            <a href="${delete_link}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a> </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>


</body>
</html>