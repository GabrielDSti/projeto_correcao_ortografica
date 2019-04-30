package br.com.ifg.bean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.ifg.dao.VerificaDadosNoBancoDao;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {
	private String login;
	private String senha;
//	private VerificaDadosNoBancoDao verificaDadosNoBancoDao;
	
	public void verificaUser() throws ClassNotFoundException {
		VerificaDadosNoBancoDao vd = new VerificaDadosNoBancoDao();
		vd.verificaLoginNoBanco2(login, senha);
		
	}
	public String getForneceRegistrosUserLogado() {
			Date d  = new Date();
			String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			try {
				d = formato.parse(dStr);
			} catch (ParseException e) {
				System.out.println("não foi possivel fazer o  parse!");
				e.printStackTrace();
			}
		
			
			return"Usuário Logado:"+getLogin()+" - Ultimo Acesso:"+d;
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


//	public VerificaDadosNoBancoDao getVerificaDadosNoBancoDao() {
//		return verificaDadosNoBancoDao;
//	}
//
//	public void setVerificaDadosNoBancoDao(VerificaDadosNoBancoDao verificaDadosNoBancoDao) {
//		this.verificaDadosNoBancoDao = verificaDadosNoBancoDao;
//	}
//	
	

}
