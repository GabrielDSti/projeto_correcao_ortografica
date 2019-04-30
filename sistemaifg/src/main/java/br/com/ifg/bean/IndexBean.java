package br.com.ifg.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "indexBean")
public class IndexBean {
	
	
	public String getBuscaUserLogado() {
		return" usuario logado:"+((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getUserPrincipal().getName();


	}

	
	
	
	


}
