<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Post</title>
</head>
<body>
    <h1>Editar Post</h1>
    <form action="actualizar" method="post">
        <input type="hidden" name="id" value="${post.id}">
        <label for="titulo">Título:</label>
        <input type="text" id="titulo" name="titulo" value="${post.titulo}"><br>
        <label for="contenido">Contenido:</label><br>
        <textarea id="contenido" name="contenido" rows="5" cols="50">${post.contenido}</textarea><br>
        <input type="submit" value="Actualizar">
    </form>
</body>
</html>

