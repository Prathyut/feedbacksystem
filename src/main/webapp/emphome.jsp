<%@ page import="javax.naming.InitialContext" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.ejb.EJB" %>
<%@ page import="com.klef.ep.services.EmployeeService" %>
<%@ page import="com.klef.ep.models.Employee" %>

<%
Employee emp = (Employee) session.getAttribute("emps");
if (emp == null) {
    response.sendRedirect("sessionexpiry.html");
    return; // Ensure the rest of the page is not processed
}
%>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <title>Employee Home</title>
    <style>
       body {
    font-family: 'Roboto', sans-serif;
    background: url('images/image6.jpg') no-repeat center center fixed;
    background-size: cover;
    color: #333;
    margin: 0;
    padding: 0;
}

.container {
    width: 80%;
    margin: 60px auto 0; /* Adjust top margin for fixed navbar if needed */
    background: rgba(255, 255, 255, 0.9);
    padding: 30px;
    border-radius: 10px;
    box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
    transition: box-shadow 0.3s ease, transform 0.3s ease;
}

.container:hover {
    box-shadow: 0 20px 40px rgba(0, 0, 0, 0.3);
    transform: translateY(-5px);
}

h3 {
    text-align: center;
    color: #4A90E2;
    font-size: 24px;
    margin-bottom: 20px;
}

.nav-links {
    text-align: center;
    margin-top: 20px;
}

.nav-links a {
    margin: 0 10px;
    text-decoration: none;
    color: #4A90E2;
    font-weight: bold;
    padding: 12px 24px;
    border: 2px solid #4A90E2;
    border-radius: 6px;
    transition: background-color 0.3s ease, color 0.3s ease, transform 0.2s ease;
}

.nav-links a:hover {
    background-color: #4A90E2;
    color: #fff;
    transform: scale(1.05);
}

p {
    text-align: center;
    font-size: 18px;
    color: #333;
}

    </style>
</head>
<body>
    <jsp:include page="empnav.jsf" />
    <div class="container">
        <h3>Employee Home Page</h3>
        <div class="nav-links">
            <a href="emphome.jsp">Home</a>
            <a href="emplogout.jsp">Logout</a>
        </div>
        <br/><br/>
        <p>Welcome, <%= emp.getFullname() %>! You are now in the Employee Home.</p>
    </div>
</body>
</html>
