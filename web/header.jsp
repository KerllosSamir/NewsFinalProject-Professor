<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header id="header">
    <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12">
            <div class="header_top">
                <div class="header_top_left">
                    <ul class="top_nav">
                        <li><a href="index.jsp">Home</a></li>
                        <li><a href="#">About</a></li>
                        <li><a href="contact">Contact</a></li>
                    </ul>
                </div>
                <div class="header_top_right">
                    <p><%!
                        Date dNow = new Date();
                        SimpleDateFormat ft = new SimpleDateFormat("EEEE, MMMM d, y");
                    %><%=ft.format(dNow)%>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-lg-12 col-md-12 col-sm-12">
            <div class="header_bottom">
                <div class="logo_area"><a href="index.jsp" class="logo"><img src="images/logo.jpg" alt=""></a>
                </div>
                <div class="add_banner"><a href="#"><img src="images/addbanner_728x90_V1.jpg" alt=""></a></div>
            </div>
        </div>
    </div>
</header>