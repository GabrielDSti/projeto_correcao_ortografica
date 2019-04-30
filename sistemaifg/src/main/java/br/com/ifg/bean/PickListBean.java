package br.com.ifg.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.DualListModel;

@ManagedBean(name = "pickListBean")
public class PickListBean {
	
	private  DualListModel<String> cidades;
	
	@PostConstruct
	public void init() {
		List<String> cidadeFonte = new ArrayList<String>();
		List<String> cidadeAlvo = new ArrayList<String>();
		
		cidadeFonte.add("Goiânia");
		cidadeFonte.add("Inhumas");
		cidadeFonte.add("Anapólis");
		cidadeFonte.add("Morrinhos");
		cidadeFonte.add("Urutaí");
		
		cidades = new DualListModel<String>(cidadeFonte,cidadeAlvo);
		
	}


	public DualListModel<String> getCidades() {
		return cidades;
	}


	public void setCidades(DualListModel<String> cidades) {
		this.cidades = cidades;
	}
	
	

}
