package template.rest;

import java.util.ArrayList;
import javax.xml.bind.annotation.*;
import template.rest.dto.Projeto;

@XmlRootElement(name = "projetos")
public class ResponseListProjeto {
	
	
	private ArrayList<Projeto> lista;
	
	@XmlElement(name = "projeto")
	public ArrayList<Projeto> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Projeto> lista) {
		this.lista = lista;
	}
}
