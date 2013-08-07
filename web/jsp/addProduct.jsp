<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавить продукцию</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">

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
            <br>
            <form action="MainServlet?command=addProduct&v=2" method="post">
                <table class="addProd">
                    <tr>
                        <td class="addProd">Введите название продукции:</td>
                        <td class="addProd">
                            <input type="text"
                                   maxlength="35"
                                   size="40"
                                   value=""
                                   name="name"
                                   style="margin:5px">
                        </td>
                    </tr>
                    <tr>
                        <td class="addProd">Введите розничную цену:</td>
                        <td class="addProd">
                            <input type="text"
                                   maxlength="35"
                                   size="40"
                                   value=""
                                   name="retail_price"
                                   style="margin:5px">
                        </td>
                    </tr>
                    <tr>
                        <td class="addProd">Введите размер партии:</td>
                        <td class="addProd">
                            <input type="text"
                                   maxlength="35"
                                   size="40"
                                   value=""
                                   name="batch_size"
                                   style="margin:5px">
                        </td>
                    </tr>
                    <tr>
                        <td class="addProd">Введите стоимость партии:</td>
                        <td class="addProd">
                            <input type="text"
                                   maxlength="35"
                                   size="40"
                                   value=""
                                   name="batch_price"
                                   style="margin:5px">
                        </td>
                    </tr>
                    <tr>
                        <td class="addProd">Введите количество продукции:</td>
                        <td class="addProd">
                            <input type="text"
                                   maxlength="35"
                                   size="40"
                                   value=""
                                   name="amount"
                                   style="margin:5px">
                        </td>
                    </tr>
                    <tr>
                        <td class="addProd">Выберите дистрибьютора:</td>
                        <td class="addProd">
                            <select id="menu" name="menu" size="1" onchange="submit();">                               
                                <c:forEach var="listDistributor" items="${listDistributor}">                                    
                                    <option id="${listDistributor.id}" value="${listDistributor.id}"><c:out value="${listDistributor.name}"/></option>
                                </c:forEach>                                   
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="addProd">Выберите склад:</td>
                        <td class="addProd">
                            <select id="menu2" name="menu2" size="1" onchange="submit();">                                 
                                <c:forEach var="listWarehouse" items="${listWarehouse}">                                        
                                    <option id="${listWarehouse.id}" value=${listWarehouse.id}"><c:out value="${listWarehouse.name}"/></option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td class="addProd">
                            <input type="submit"
                                   name="submit"
                                   value="Добавить">
                        </td>
                        <td class="addProd"></td>           
                    </tr>
                </table>
                <br>
            </form>  
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
