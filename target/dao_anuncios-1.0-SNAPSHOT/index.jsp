<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Blog</title>
</head>
<body>
    <h1>Blog</h1>
    <p><a href="nuevo">Nuevo Post</a></p>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Fecha</th>
            <th>Título</th>
            <th>Contenido</th>
            <th>Acciones</th>
        </tr>
        <c:forEach var="post" items="${posts}">
            <tr>
                <td>${post.id}</td>
                <td>${post.fecha}</td>
                <td>${post.titulo}</td>
                <td>${post.contenido}</td>
                <td>
                    <a href="editar?id=${post.id}">Editar</a>
                    <a href="eliminar?id=${post.id}" onclick="return confirm('¿Estás seguro de eliminar este post?')">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
