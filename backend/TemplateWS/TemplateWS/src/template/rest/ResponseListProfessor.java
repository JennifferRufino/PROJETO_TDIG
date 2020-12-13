package template.rest;

import java.util.ArrayList;
import javax.xml.bind.annotation.*;
import template.rest.dto.Professor;

@XmlRootElement(name = "professores")
public class ResponseListProfessor {
	
	private ArrayList<Professor> lista;
	
	@XmlElement(name = "professor")
	public ArrayList<Professor> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Professor> lista) {
		this.lista = lista;
	}
	
}
