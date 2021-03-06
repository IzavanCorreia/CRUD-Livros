/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote.model.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pacote.model.negocios.Livro;
import pacote.model.repositorios.RepositorioLivros;

/**
 *
 * @author Izavan
 */
@WebServlet(name = "ApresentaLivrosServlet", urlPatterns = {"/ApresentaLivrosServlet"})
public class ApresentaLivrosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Livro> livros = RepositorioLivros.lerTudo();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Livros cadastrados no sistema</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Livros cadastrados:</h1>");
            out.println("<a href=\"index.html\">Página inicial</a>");
            out.println("<table border='1'>");
            out.println("<tr><th>id</th><th>Nome</th>"
                    + "<th>Autor</th><th>Ano</th><th>Ações</th></tr>");

            for (Livro l : livros) {

                out.println("<tr><td>" + l.getId() + "</td><td>" + l.getNome() + "</td>"
                        + "<td>" + l.getAutor() + "</td><td>" + l.getAno() + "</td>"
                        + "<td><a href='VisualizaLivroServlet?id=" + l.getId() + "'>visualizar /</a>"
                        + "<a href='ApresentaAlteracaoServlet?id=" + l.getId() + "'> alterar /</a>"
                        + "<a href='DeletarLivroServlet?id=" + l.getId() + "'> deletar</a></td></tr>");

            }
            
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
