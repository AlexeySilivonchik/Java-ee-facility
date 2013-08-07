<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Продукция</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        
        <script src="js/jquery-1.4.2.js" type="text/javascript"></script>
        <script src="js/jquery-ui-1.8.4.custom.min.js" type="text/javascript"></script>

        <script type="text/javascript">
            $(document).ready(function(){
                $('a.categoryButton').hover(
                    function () {$(this).animate({backgroundColor: '#b2d2d2'})},
                    function () {$(this).animate({backgroundColor: '#d3ede8'})}
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
                <div class="headerWidget">
                    <a href="MainServlet?command=aboutProject" style="color: #31a900">О проекте</a>
                </div>
                
                <div class="headerWidget">
                    <a href="MainServlet?command=mainPage" style="color: #31a900">На главную</a>
                </div>
            </div>

            <a href="MainServlet?command=mainPage">
                <img src="css/img/logo.jpg" id="logo" alt="Логотип">
            </a>
            
            <h1><br><br>Учет выпуска продукции<br>на предприятии</h1>
            <%--<img class="logo" src="img/logo.png" id="logoText" alt="Система учета">--%>
        </div>

        <div id="productionCenter">
            <br><h3 align="center">Продукция</h3>

            <c:forEach var="production" items="${products}">
                <h2><span style="font:bold italic 20px/25px Georgia; float: left">&nbsp;&nbsp;<c:out value="${production.name}"/></span></h2>
                <br>
                <span style="float: right; margin-right: 50px">
                    <a href="MainServlet?command=deleteProduct&id=${production.id}" class="line" style="color: #31a900; font-size: 14px;">Удалить</a>
                    <a href="MainServlet?command=editProduct&id=${production.id}&v=1"class="line" style="color: #31a900; font-size: 14px;">Редактировать</a>
                </span>
                <br>
                <c:out value="Розничная цена: ${production.retailPrice}."/>
                <c:out value="Размер партии: ${production.batchSize}."/>
                <c:out value="Стоимость партии: ${production.batchPrice}."/>
                <c:out value="Количество продукта: ${production.amount}."/>
                <c:out value="Название склада - ${production.warehouse.name}."/>
                <c:out value="Дистрибьютор - ${production.distributor.name}."/>
                <hr style="width: 500px">
            </c:forEach>
            
                <br>
            <form action="MainServlet?command=addProduct&v=1" method="post">
                <input type="submit"
                       name="submit"
                       value="Добавить">
            </form>
                <br>
        </div>        
        
        <div id="footer">
            <hr>
            <h5>©   2013 Силивончик Алексей</h5>
            <%--<p class="reallySmallText">©   2013 Силивончик Алексей</p>--%>
        </div>
    </div>
</html>
