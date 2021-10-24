<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Spring MVC recipes</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"
          rel="stylesheet">
    <%@ page isELIgnored="false" %>
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
<div class="container">
    <div class="col-md-offset-1 col-md-10">
        <h3 class="text-center">Список рецептов</h3>
        <hr/>

        <input type="button" value="Добавить рецепт"
               onclick="window.location.href='showForm'; return false;"
               class="btn btn-primary"/> <br/>
        <br/>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Список рецептов</div>
            </div>
            <div class="panel-body">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>Наименование</th>
                        <th>Описание</th>
                        <th>Дата создания</th>
                        <th>Action</th>
                    </tr>

                    <c:forEach var="tempRecipe" items="${recipe}">

                        <c:url var="updateLink" value="/updateForm">
                            <c:param name="recipeId" value="${tempRecipe.id}"/>
                        </c:url>

                        <c:url var="deleteLink" value="/delete">
                            <c:param name="recipeId" value="${tempRecipe.id}"/>
                        </c:url>

                        <tr>
                            <td>${tempRecipe.name}</td>
                            <td>${tempRecipe.descriptions}</td>
                            <td>${tempRecipe.date}</td>
                            <td>
                                <a href="${updateLink}">Update</a>
                                | <a href="${deleteLink}"
                                     onclick="if (!(confirm('Вы действительно хотите удалить рецепт ?'))) return false">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>