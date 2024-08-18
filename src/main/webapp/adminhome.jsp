<%@page import="com.klef.ep.models.Admin"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.List"%>
<%@page import="javax.ejb.EJB"%>
<%
Admin admin = (Admin) session.getAttribute("admin");
if (admin == null) {
    response.sendRedirect("sessionexpiry.html");
    return; // Ensure the rest of the page is not processed
}
%>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <title>Admin Home</title>
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background: url('pictures/image11.jpg') no-repeat center center fixed;
            background-size: cover;
            color: #333;
            margin: 0;
            padding: 0;
        }

        /* Navbar container */
        .navbar {
            overflow: hidden;
            background-color: #4A90E2;
            font-family: 'Roboto', sans-serif;
            display: flex;
            justify-content: center;
            position: fixed;
            width: 100%;
            top: 0;
            z-index: 1000;
        }

        /* Navbar links */
        .navbar a {
            color: white;
            text-align: center;
            padding: 14px 20px;
            text-decoration: none;
            font-size: 17px;
            flex: 1;
            text-transform: uppercase;
        }

        /* Change color on hover */
        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }

        /* Hide the icon initially */
        .navbar a.icon {
            display: none;
        }

        /* Responsive styles */
        @media screen and (max-width: 600px) {
            .navbar a:not(:first-child) {display: none;}
            .navbar a.icon {
                float: right;
                display: block;
            }
        }

        .navbar.responsive {position: relative;}
        .navbar.responsive .icon {
            position: absolute;
            right: 0;
            top: 0;
        }

        .navbar.responsive a {
            float: none;
            display: block;
            text-align: left;
        }

        /* Container for content */
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
    <div class="navbar">
        <a href="adminhome.jsp">Home</a>
        <a href="viewall.jsf">View All</a>
        <a href="viewgre.jsf">View Grievances</a>
        <a href="adminlogout.jsp">Logout</a>
    </div>

    <div class="container">
        <h3>Admin Home Page</h3>
        
    </div>
</body>
</html>
