package template.rest.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "endereco")
public class Endereco {

	private Integer id;
	private String rua;
	private String numero;
	private String cep;
	private String cidade;
	private String estado;
	private String pais;
	
	public Endereco() {
		super();
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getRua() {
		return rua;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setEstado(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getPais() {
		return pais;
	}


}
