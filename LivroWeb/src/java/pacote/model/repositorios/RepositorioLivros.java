/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote.model.repositorios;

import java.util.ArrayList;
import java.util.List;
import pacote.model.negocios.Livro;

/**
 *
 * @author Izavan
 */
public class RepositorioLivros {

    private static int incremento = 1;
    private static List<Livro> livros = new ArrayList<>();

    public static void inserir(Livro l) {
        l.setId(incremento++);
        livros.add(l);
    }

    public static void alterar(Livro l) {

        for (Livro cont : livros) {
            if (cont.getId() == l.getId()) {
                cont.setNome(l.getNome());
                cont.setAutor(l.getAutor());
                cont.setTema(l.getTema());
                cont.setAno(l.getAno());
                return;
            }   
        }
    }

    public static Livro ler(int id) {
        for (Livro cont : livros) {
            if (cont.getId() == id) {
                return cont;
            }
        }
        return null;
    }

    public static void delete(Livro l) {

        Livro cAux = null;

        for (Livro cont : livros) {
            if (cont.getId() == l.getId()) {
                cAux = cont;
                break;
            }
        }
        livros.remove(cAux);
    }
    
     public static List<Livro> lerTudo(){
        return livros;
    }
}
