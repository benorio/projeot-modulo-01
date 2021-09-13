package br.com.alura.livraria.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.livraria.dao.CadastroDao;
import br.com.alura.livraria.factory.ConnectionFactory;
import br.com.alura.livraria.modelo.Autor;

@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {

	private CadastroDao dao;
	
	public CadastroServlet() {
		this.dao = new CadastroDao(new ConnectionFactory().getConnection());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("autores", dao.listar());
		req.getRequestDispatcher("WEB-INF/jsp/cadastro.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String nome = req.getParameter("nome");
			String email = req.getParameter("email");
			LocalDate data = LocalDate.parse(req.getParameter("dataNascimento"),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			String curriculo = req.getParameter("miniCurriculo");
			
			
			Autor autor = new Autor(nome,email,data,curriculo);
			dao.cadastrar((autor));
			
			resp.sendRedirect("cadastro");
			
		} catch (Exception e) {
			resp.sendRedirect("cadastro?erro=campo invalido");
		
		}
	}
	
}
