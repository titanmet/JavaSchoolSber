<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Spring MVC Recipes</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"
          rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <h3 class="text-center">Список рецептов</h3>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Добавить рецепт</div>
            </div>
            <div class="panel-body">
                <form:form action="saveRecipe" cssClass="form-horizontal"
                           method="post" modelAttribute="recipe">

                    <form:hidden path="id"/>

                    <div class="form-group">
                        <label for="name" class="col-md-3 control-label">Наименование</label>
                        <div class="col-md-9">
                            <form:input path="name" cssClass="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="descriptions" class="col-md-3 control-label">Описание</label>
                        <div class="col-md-9">
                            <form:input path="descriptions" cssClass="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="date" class="col-md-3 control-label">Дата</label>
                        <div class="col-md-9">
                            <form:input path="date" cssClass="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-offset-3 col-md-9">
                            <form:button cssClass="btn btn-primary">Submit</form:button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>