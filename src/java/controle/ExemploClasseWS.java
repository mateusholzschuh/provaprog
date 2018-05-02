/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * - Servlet padrão -
 *
 * / Utilizar sempre NomeDaClaseWS /
 *
 * Para adaptar após o CTRL+C, CTRL+V :
 * Pressione CTRL+H e substitua "ExemploClasse" pelo nome da sua classe.
 *
 */
package controle;

import dao.ExemploClasseDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ExemploClasse;

/**
 *
 * @author Mateus
 */
@WebServlet(name = "ExemploClasseWS", urlPatterns = "/ExemploClasseWS")
public class ExemploClasseWS extends HttpServlet {

    private String paginaListar = "exemploclasse/exemploclasse.jsp";
    private String paginaAdd    = "exemploclasse/exemploclasse-add.jsp";
    private String paginaAddOK  = "exemploclasse/exemploclasse-add-ok.jsp";
    private String paginaDelOK  = "exemploclasse/exemploclasse-del-ok.jsp";

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Para deletar (deve receber o param 'funcao' == 'del' e o 'id' do objeto a ser deletado
        if (request.getParameter("funcao") != null && request.getParameter("funcao").equals("del")
                && request.getParameter("id") != null) {
            //Abre conexão com dao
            ExemploClasseDAO dao = new ExemploClasseDAO();
            //Busca pelo objeto
            ExemploClasse obj = dao.buscarPorChavePrimaria(Long.parseLong(request.getParameter("id")));

            //Tenta deletar o objeto
            boolean deucerto = dao.excluir(obj);

            //Testa a exclusão
            String msg;
            if (deucerto) {
                msg = "Você deletou o objeto: " + obj.toString();
            } else {
                msg = "Ocorreu um erro!";
            }

            //Fecha conexão com dao
            dao.fecharConexao();

            //Envia a msg
            request.setAttribute("msg", msg);

            //Abre o destino
            RequestDispatcher destino;
            destino = request.getRequestDispatcher(this.paginaDelOK);
            destino.forward(request, response);
        } //Se receber parametro 'funcao' == 'add', redireciona para o formulario
        else if (request.getParameter("funcao") != null && request.getParameter("funcao").equals("add")) {
            //Abre o destino
            RequestDispatcher destino;
            destino = request.getRequestDispatcher(this.paginaAdd);
            destino.forward(request, response);
        } //Se não receber parâmetro, quer listar
        else {
            //Recupera a lista
            List<ExemploClasse> lista = this.listar();
            //Seta como atributo
            request.setAttribute("lista", lista);
            //Envia atributo para o destino
            RequestDispatcher destino = request.getRequestDispatcher(this.paginaListar);
            //Carrega o destino
            destino.forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ExemploClasse obj;
        obj = new ExemploClasse();
        /* Definir os atributos do objeto */

        /* ****************************** */

        /* Adicionar no banco de dados */
        //Abre conexão
        ExemploClasseDAO dao = new ExemploClasseDAO();
        //Tenta iserir o objeto
        boolean deucerto = dao.incluir(obj);
        //Fecha conexão
        dao.fecharConexao();
        /* -------------------------- */

        String msg;
        //Verifica se foi possivel inserir
        if (deucerto) {
            msg = "Você adicionou um novo objeto: " + obj.toString();
        } else {
            msg = "Ocorreu um erro ao inserir";
        }
        request.setAttribute("msg", msg);

        //Vai para a pagina de resposta
        RequestDispatcher destino;
        destino = request.getRequestDispatcher(this.paginaAddOK);
        destino.forward(request, response);
    }

    /**
     * Função para recuperar as informações do banco de dados através do DAO.
     *
     * @return Uma lista de objetos do banco.
     */
    public List<ExemploClasse> listar() {
        List<ExemploClasse> lista;
        //Cria objeto DAO referente à classe
        ExemploClasseDAO dao = new ExemploClasseDAO();
        //Pega a lista do banco de dados
        lista = dao.listar();
        //Fecha conexão com o banco
        dao.fecharConexao();
        //Retorna a lista
        return lista;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
