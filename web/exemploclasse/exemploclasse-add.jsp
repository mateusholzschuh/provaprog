<%-- 
    Document   : exemploclasse-add
    Created on : 26/04/2018, 11:40:08
    Author     : Mateus
--%>
<%--
   /**
    * - JSP form add padrão -
    * 
    * / Utilizar sempre nomedaclasse-add.jsp /
    * 
    * Para adaptar após o CTRL+C, CTRL+V :
    * Pressione CTRL+H e substitua "ExemploClasse" pelo nome da sua classe.
    * Adaptar o form conforme a necessidade.
    * 
    */
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ExemploClasse add</title>
    </head>
    <body>
        <h1>Cadastrar ExemploClasse</h1>
        <nav>
            <a href="ExemploClasseWS">Voltar</a>
            <a href="index.html">Menu</a>
        </nav>
        <form action="ExemploClasseWS" method="POST">
            <label>Atributo</label>
            <input name="atrnome" type="text"/>
            <br>
            <input type="submit" value="Guardar">
        </form>
    </body>
</html>
