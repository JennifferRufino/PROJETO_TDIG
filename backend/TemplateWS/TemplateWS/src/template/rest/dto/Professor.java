package template.rest.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "professor")
public class Professor {
	
	private int id;  //Id: Integer (Auto-increment)
	private Integer matricula;
	private String nome;
	private String curso;
//	private Endereco endereco;
	private int idEnderedo;
	
	public Professor() {
		super();
//		this.endereco = new Endereco();
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	
	public Integer getMatricula() {
		return matricula;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public String getCurso() {
		return curso;
	}

//	public Endereco getEndereco() {
//		return endereco;
//	}
//
//	public void setEndereco(Endereco endereco) {
//		this.endereco = endereco;
//	}

	public int getIdEnderedo() {
		return idEnderedo;
	}

	public void setIdEnderedo(int idEnderedo) {
		this.idEnderedo = idEnderedo;
	}
	
	
	
}
