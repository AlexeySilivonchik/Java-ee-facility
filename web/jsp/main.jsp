<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Главная</title>
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

        <div id="indexLeftColumn">
            <hr>
            <div id="welcomeText">
                <p>Добро пожаловать в веб-приложение для учета выпуска продукции на предприятии.</p>
                <p>Данное приложение позволяет создавать, дополнять, а также систематизировать
                    все аспекты выпускаемой продукции.</p>
            </div>
        </div>

        <div id="indexRightColumn">
            <div class="categoryBox">
                <a href="MainServlet?command=production">
                    <span class="categoryLabel"></span>
                    <span class="categoryLabelText">Продукция</span>

                    <img src="css/img/production.jpg"
                         alt="production" class="categoryImage">
                </a>
            </div>
            <div class="categoryBox">
                <a href="MainServlet?command=search&v=1">
                    <span class="categoryLabel"></span>
                    <span class="categoryLabelText">Поиски</span>
                    
                    <img src="css/img/reports.jpg"
                     alt="reports" class="categoryImage">
                </a>
            </div>
            <div class="categoryBox">
                <a href="MainServlet?command=warehouses">
                    <span class="categoryLabel"></span>
                    <span class="categoryLabelText">Склады</span>
                    
                    <img src="css/img/warehouses.jpg"
                     alt="warehouses" class="categoryImage">
                </a>
            </div>
            <div class="categoryBox">
                <a href="MainServlet?command=distributors">
                    <span class="categoryLabel"></span>
                    <span class="categoryLabelText">Дистрибьюторы</span>
                    
                    <img src="css/img/distributors.jpg"
                     alt="meats" class="categoryImage">
                </a>
            </div>          
        </div>
        
        <div id="footer">
            <hr>
            <h5>©   2013 Силивончик Алексей</h5>
            <%--<p class="reallySmallText">©   2013 Силивончик Алексей</p>--%>
        </div>
    </div>
</html>
