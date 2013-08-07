
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Авторизация</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/style.css">

        <script src="js/jquery-1.4.2.js" type="text/javascript"></script>
        <script src="js/jquery-ui-1.8.4.custom.min.js" type="text/javascript"></script>

        <script type="text/javascript">
            $(document).ready(function() {
                $('a.categoryButton').hover(
                        function() {
                            $(this).animate({backgroundColor: '#b2d2d2'})
                        },
                        function() {
                            $(this).animate({backgroundColor: '#d3ede8'})
                        }
                );

                $('div.categoryBox').hover(over, out);

                function over() {
                    var span = this.getElementsByTagName('span');
                    $(span[0]).animate({opacity: 0.3});
                    $(span[1]).animate({color: 'red'});

                }

                function out() {
                    var span = this.getElementsByTagName('span');
                    $(span[0]).animate({opacity: 0.7});
                    $(span[1]).animate({color: '#444'});
                }
            });
        </script>
    </head>
    <div id="main">
        <div id="header"><br>
            <div id="widgetBar">
            </div>

            <img src="css/img/logo.jpg" id="logo" alt="Логотип">

            <h1><br><br>Учет выпуска продукции<br>на предприятии</h1>
                <%--<img class="logo" src="img/logo.png" id="logoText" alt="Система учета">--%>
        </div>

        <div id="addProductCenter">
            <br><h3 align="center">Авторизация</h3>
            <table style="margin: auto; border: none">
                <tr>
                    <td><br></td>
                    <td><br></td>
                </tr>
                <tr>
                    <td><h4 align="center">Вход</h4></td>
                    <td></td>
                </tr>
                <form action="MainServlet?command=loginRegister&v=2" method="post">
                    <tr>
                        <td>Введите имя:</td>
                        <td>
                            <input type="text"
                                   maxlength="35"
                                   size="40"
                                   value=""
                                   name="login"
                                   style="margin:5px">
                        </td>
                    </tr>
                    <tr>
                        <td>Введите пароль:</td>
                        <td>
                            <input type="password"
                                   maxlength="35"
                                   size="40"
                                   value=""
                                   name="password"
                                   style="margin:5px">
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit"
                                   name="submit"
                                   value="Вход"></td>
                        <td>
                        </td>
                    </tr>
                </form>
                <tr>
                    <td><br><br></td>
                    <td><br><br></td>
                </tr>
                <tr>
                    <td><h4 align="center">Регистрация</h4></td>
                    <td></td>
                </tr>
                <form action="MainServlet?command=loginRegister&v=3" method="post">
                    <tr>
                        <td>Введите имя:</td>
                        <td>
                            <input type="text"
                                   maxlength="35"
                                   size="40"
                                   value="${production.name}"
                                   name="login"
                                   style="margin:5px">
                        </td>
                    </tr>
                    <tr>
                        <td>Введите пароль:</td>
                        <td>
                            <input type="password"
                                   maxlength="35"
                                   size="40"
                                   value="${production.name}"
                                   name="password"
                                   style="margin:5px">
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit"
                                   name="submit"
                                   value="Регистрация"></td>
                        <td>
                        </td>
                    </tr>
                </form>
            </table>
            <br>
            <h4 align="center">
                <%if (request.getAttribute("error") != null) {%>
                <%=request.getAttribute("error")%>
                <%}%></h4>
            <br>
        </div>            

        <div id="footer">
            <hr>
            <h5>©   2013 Силивончик Алексей</h5>
            <%--<p class="reallySmallText">©   2013 Силивончик Алексей</p>--%>
        </div>
    </div>
</html>
