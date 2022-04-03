/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote.model.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ApresentaAlteracaoServlet", urlPatterns = {"/ApresentaAlteracaoServlet"})
public class ApresentaAlteracaoServlet extends HttpServlet {

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

        int id = Integer.parseInt(request.getParameter("id"));

        Livro l = RepositorioLivros.ler(id);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ApresentaAlteracaoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Edite as informações do livro:</h1>");
            out.println("<a href='ApresentaLivrosServlet'>Menu de livros</a><br>");
            out.println("<form method='post' action='AlteraLivroServlet'>");
            out.println("<input type='hidden' name='id' value='" + l.getId() + "'/>");
            out.println("Nome: <input type=\"text\" name=\"nome\" value='" + l.getNome() + "'><br>");
            out.println("Autor: <input type=\"text\" name=\"autor\" value='" + l.getAutor() + "'><br>");
            out.println("Tema: <input type=\"text\" name=\"tema\" value='" + l.getTema() + "'><br>");
            out.println("Ano: <input type=\"text\" name=\"ano\" value='" + l.getAno() + "'><br>");
            out.println("<input type='submit' value='enviar'/>");
            out.println("</form>");
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
