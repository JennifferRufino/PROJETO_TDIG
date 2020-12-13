package template.rest.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import template.rest.dto.Professor;

public class ProfessorDAO {
	
	public ArrayList<Professor> getProfessor(Connection connection) throws Exception {
		
		ArrayList<Professor> professores = new ArrayList<Professor>();
		try {
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement("SELECT id, matricula, nome, curso, fk_enderecos_id FROM controle_academico.professor");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Professor professor = new Professor();
				professor.setId(rs.getInt("id"));
				professor.setMatricula(rs.getInt("matricula"));
				professor.setNome(rs.getString("nome"));
				professor.setCurso(rs.getString("curso"));
				professor.setIdEnderedo(rs.getInt("fk_enderecos_id"));
				professores.add(professor);
			}
			return professores;
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public void cadastraProfessor(Connection connection, Professor professorEntrada){
		
		try {
			Statement stm = (Statement) connection.createStatement();
			
			String query = "INSERT INTO controle_academico.professor (matricula, nome, curso, fk_enderecos_id) VALUES ( '"
					+ professorEntrada.getMatricula() + "', '" 
					+ professorEntrada.getNome() + "', '" 
					+ professorEntrada.getCurso() + "', '" 
					+ professorEntrada.getIdEnderedo() + "');";
			stm.execute(query);
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
	
public void atualizaProfessor(Connection connection, Professor professorEntrada){
		
		try {
			Statement stm = (Statement) connection.createStatement();
			
			String query = "UPDATE controle_academico.professor SET "
					+ "matricula='"+ professorEntrada.getMatricula()
					+ "', nome='"+ professorEntrada.getNome()
					+ "', curso='"+ professorEntrada.getCurso()
					+ "', fk_enderecos_id='"+ professorEntrada.getIdEnderedo()
					+ "' where ID='" + professorEntrada.getId() + "';";
			stm.execute(query);
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
		
/**
 * @param connection
 * @param professorEntrada
 * @throws Exception
 */
	public void removeProfessor(Connection connection, Professor professorEntrada) throws Exception{
			Statement stm = (Statement) connection.createStatement();
			
			String query = "DELETE FROM controle_academico.professor where ID= '"+ professorEntrada.getId() + "';";
			stm.execute(query);	
	}
}
