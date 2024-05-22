<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nuevo Post</title>
</head>
<body>
    <h1>Nuevo Post</h1>
    <form action="crear" method="post">
        <label for="fecha">Fecha:</label><br>
        <input type="text" id="fecha" name="fecha"><br>
        <label for="titulo">Título:</label><br>
        <input type="text" id="titulo" name="titulo"><br>
        <label for="contenido">Contenido:</label><br>
        <textarea id="contenido" name="contenido"></textarea><br>
        <input type="submit" value="Crear Post">
    </form>
</body>
</html>
