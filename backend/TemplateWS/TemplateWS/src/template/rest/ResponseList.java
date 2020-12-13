package template.rest;

import java.util.ArrayList;
import javax.xml.bind.annotation.*;
import template.rest.dto.Aluno;

@XmlRootElement(name = "alunos")
public class ResponseList {
	
	private ArrayList<Aluno> lista;
	
	@XmlElement(name = "aluno")
	public ArrayList<Aluno> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Aluno> lista) {
		this.lista = lista;
	}
	
}
