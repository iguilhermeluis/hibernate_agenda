package com.guilherme.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guilherme.dao.ClienteDao;
import com.guilherme.model.Cliente;


@WebServlet("/cadastrar")
public class ServletCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cli = new Cliente();
		cli.setNome(request.getParameter("nomeContato"));
		cli.setTelefone(request.getParameter("telefoneContato"));
		cli.setEmail(request.getParameter("emailContato"));
		cli.setEndereco(request.getParameter("enderecoContato"));
		// Processamento necessário para a persistênca
		ClienteDao dao = new ClienteDao();
		System.out.println("Id do cliente armazenado: " + dao.gravar(cli));
		
		response.sendRedirect("confirmacao.html");
	}
}
