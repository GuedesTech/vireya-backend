package com.example.servletsvireya.controller.produto;

import com.example.servletsvireya.dao.ProdutoDAO;
import com.example.servletsvireya.model.Produto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletRemoverProduto", value = "/ServletRemoverProduto")
public class ServletRemoverProduto extends HttpServlet {
    ProdutoDAO produtoDAO = new ProdutoDAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Pegar o valor
        String idStr = req.getParameter("id");

        //Converter para inteiro
        int id = Integer.parseInt(idStr);

        //Instanciando objeto da classe model Produto
        Produto produto = new Produto();
        produto.setId(id);

        //Removendo produto do sistema
        produtoDAO.removerProduto(produto);

        //não precisa responder nada
    }
}