package template.rest;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import template.rest.dto.Endereco;

@XmlRootElement(name = "enderecos")
public class ResponseListEndereco {
	
	private ArrayList<Endereco> lista;
	
	@XmlElement(name = "endereco")
	public ArrayList<Endereco> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Endereco> lista) {
		this.lista = lista;
	}
	
}
