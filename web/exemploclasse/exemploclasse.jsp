<%-- 
    Document   : exemploclasse
    Created on : 26/04/2018, 11:40:08
    Author     : Mateus
--%>
<%--
   /**
    * - JSP listar padrão -
    * 
    * / Utilizar sempre nomedaclasse.jsp /
    * 
    * Para adaptar após o CTRL+C, CTRL+V :
    * Pressione CTRL+H e substitua "ExemploClasse" pelo nome da sua classe.
    * Adaptar a tabela conforme a necessidade.
    * 
    */
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ExemploClasse listar</title>
    </head>
    <body>
        <h1>Listar ExemploClasse</h1>
        <nav>
            <a href="ExemploClasseWS?funcao=add">Add</a>
            <a href="index.html">Menu</a>
        </nav>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Funções</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${lista}" var="obj">
                <tr>
                    <td>${obj.id}</td>
                    <td>
                        <a href="ExemploClasseWS?funcao=del&id=${obj.id}">Deletar</a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
