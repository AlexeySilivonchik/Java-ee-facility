<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Поиски</title>
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

        <div id="addProductCenter">
            <br><h3 align="center">Поиски</h3>
            &nbsp;&nbsp;&nbsp;&nbsp;<a href="MainServlet?command=search&v=2" style="color: #31a900">Поиск по продукции</a>
            <br>
            &nbsp;&nbsp;&nbsp;&nbsp;<a href="MainServlet?command=search&v=3" style="color: #31a900">Поиск по дистрибьюторам</a>
            <br>
            &nbsp;&nbsp;&nbsp;&nbsp;<a href="MainServlet?command=search&v=4" style="color: #31a900">Поиск по складам</a>
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
