package br.com.ifg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.ifg.bean.LoginBean;
import br.com.ifg.jdbc.ConnectionFactory;

public class VerificaDadosNoBancoDao {
	private Connection connection;
	private LoginBean loginBean;

	public VerificaDadosNoBancoDao() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}

	
public  void verificaLoginNoBanco2(String login,String senha) {
	FacesContext context = FacesContext.getCurrentInstance();
		try {
			String sql = "select u.usuario, u.senha from usuario u where u.usuario like '"+login+
					 "' and u.senha like '"+senha+"' ; ";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				System.out.println("login e senha  valido!");
				rs.close();
				stmt.close();
				FacesContext fc = FacesContext.getCurrentInstance();

				ExternalContext ec = fc.getExternalContext();
				ec.getFlash().setKeepMessages(true);     
				context.addMessage(null, new FacesMessage("Bem vindo!", "Login autenticado com sucesso."));
				ec.redirect(ec.getRequestContextPath()+"/faces/index.xhtml");
				
				
			}else {
				System.out.println("login/senha incorreto!");
//				FacesContext fc = FacesContext.getCurrentInstance();
//
//				ExternalContext ec = fc.getExternalContext();
//				ec.getFlash().setKeepMessages(true);     
//
//				ec.redirect(ec.getRequestContextPath()+"/loginError.xhtml");
				
		         
		        
		        context.addMessage(null, new FacesMessage("Atenção!", "Login/Senha incorreto."));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

}
