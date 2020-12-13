package template.rest.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "projeto")
public class Projeto {
	
	private Integer id;
	private String tituloProjeto;
//	private Professor professorResponsavel;
	private String areaProjeto;
	private String resumo;
	private String palavraChave1;
	private String palavraChave2;
	private String palavraChave3;
	private String url; 
	private Integer idProfessorResponsavel;
	private Integer idAlunoParticipante;
	
	public Projeto() {
		super();
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setTituloProjeto(String tituloProjeto) {
		this.tituloProjeto = tituloProjeto;
	}
	
	public String getTituloProjeto() {
		return tituloProjeto;
	}

	public void setAreaProjeto(String areaProjeto) {
		this.areaProjeto = areaProjeto;
	}
	
	public String getAreaProjeto() {
		return areaProjeto;
	}
	
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getResumo() {
		return resumo;
	}
	
	public void setPalavraChave1(String palavraChave1) {
		this.palavraChave1 = palavraChave1;
	}
	
	public String getPalavraChave1() {
		return palavraChave1;
	}

	public void setPalavraChave2(String palavraChave2) {
		this.palavraChave2 = palavraChave2;
	}
	
	public String getPalavraChave2() {
		return palavraChave2;
	}

	public void setPalavraChave3(String palavraChave3) {
		this.palavraChave3 = palavraChave3;
	}
	
	public String getPalavraChave3() {
		return palavraChave3;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
	public Integer getIdProfessorResponsavel() {
		return idProfessorResponsavel;
	}

	public void setIdProfessorResponsavel(Integer idProfessorResponsavel) {
		this.idProfessorResponsavel = idProfessorResponsavel;
	}

	public Integer getIdAlunoParticipante() {
		return idAlunoParticipante;
	}

	public void setIdAlunoParticipante(Integer idAlunoParticipante) {
		this.idAlunoParticipante = idAlunoParticipante;
	}

//	public Professor getProfessorResponsavel() {
//		return professorResponsavel;
//	}
//
//	public void setProfessorResponsavel(Professor professorResponsavel) {
//		this.professorResponsavel = professorResponsavel;
//	}
	
}	
