package br.com.alura.livraria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.livraria.modelo.Autor;

public class CadastroDao {

	private Connection conexao;

	public CadastroDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void cadastrar(Autor autor) {

		try {
			String sql = "INSERT INTO AUTORES (NOME, EMAIL, DATA_NASCIMENTO, MINI_CURRICULO) VALUES(?, ?, ?, ?)";

			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1, autor.getNome());
			ps.setString(2, autor.getEmail());
			ps.setDate(3, Date.valueOf(autor.getDataNascimento()));
			ps.setString(4, autor.getMiniCurriculo());

			ps.execute();

		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
		
	public List<Autor> listar() {

//			
			try {

//				
				String sql = "select * from autores";

				PreparedStatement ps = conexao.prepareStatement(sql);

				ResultSet rs = ps.executeQuery();

				List<Autor> autores = new ArrayList<Autor>();

				while (rs.next()) {
					
					Autor ator = new Autor();

					ator.setNome(rs.getString("nome"));
					ator.setEmail(rs.getString("email"));
					ator.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
					ator.setMiniCurriculo(rs.getString("mini_curriculo"));
					

					autores.add(ator);
				
				}
				return autores;
			} catch (SQLException e) {
				throw new RuntimeException();
			}
			
	}
	
}
