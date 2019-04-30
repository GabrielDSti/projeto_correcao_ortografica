package br.com.ifg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.ifg.bd.DadosUsuario;
import br.com.ifg.jdbc.ConnectionFactory;

public class CrudDao {

	private Connection connection;
	
	public CrudDao() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	
	public void insereUsuario(DadosUsuario dados){
		String sql = "insert into usuario (nome,email,usuario,senha) values (?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,dados.getNome());
			stmt.setString(2,dados.getEmail());
			stmt.setString(3,dados.getLogin());
			stmt.setString(4,dados.getSenha());
			stmt.execute();
			stmt.close();
			 System.out.println("Usuario:"+dados.getNome()+",inserido com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
