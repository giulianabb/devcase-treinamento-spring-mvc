package br.com.devcase.treinamento.springmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.stereotype.Repository;

import br.com.devcase.treinamento.springmvc.domain.Pessoa;

@Repository
public class PessoaDAO {
	
	/**
	 * Procura uma pessoa pelo valor do ID
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Pessoa findById(Long id) throws Exception {
		Pessoa pessoa = new Pessoa();
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception ex) {
			throw new Exception("Driver do banco de dados não está disponível", ex);
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cadastropessoas-db", "cadastropessoas",
					"cadastropessoas");
			Statement s = conn.createStatement();
			ResultSet resultSet = s.executeQuery("SELECT nome, endereco, sexo, datanascimento from pessoa where id=" + id);
			if(resultSet.next()){
				pessoa.setId(id);
				pessoa.setNome(resultSet.getString(1).toString());
				pessoa.setEndereco(resultSet.getString(2).toString());
				pessoa.setSexo(resultSet.getString(3).toString());
				Date d = resultSet.getDate(4);
				pessoa.setDataNascimento(d);				
			}
			
		} catch (Exception ex) {
			throw new Exception("Não foi possível conectar ao banco de dados", ex);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception ignore) {
			}
		}

		return pessoa;
	}

	/**
	 * Cria uma nova pessoa
	 * 
	 * @param pessoa
	 * @return
	 * @throws Exception 
	 * @throws ServletException
	 */
	public Pessoa save(Pessoa pessoa) throws Exception {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception ex) {
			throw new Exception("Driver do banco de dados não está disponível", ex);
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cadastropessoas-db", "cadastropessoas",
					"cadastropessoas");
			Statement s = conn.createStatement();
			s.executeUpdate("INSERT INTO PESSOA (nome, endereco, sexo, dataNascimento) VALUES " + "('" + pessoa.getNome()
					+ "','" + pessoa.getEndereco() + "','" + pessoa.getSexo() + "','" + pessoa.getDataNascimento() + "')");
			ResultSet resultSet = s.executeQuery("select currval('pessoa_id_seq');");
			if(resultSet.next()) {
				Long id = resultSet.getLong(1);
				pessoa.setId(id);		
		}
			
		} catch (Exception ex) {
			throw new Exception("Não foi possível conectar ao banco de dados", ex);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception ignore) {
			}
		}

		return pessoa;
	}

	/**
	 * Edita uma pessoa existente
	 * 
	 * @param pessoa
	 * @return
	 * @throws Exception 
	 */
	public Pessoa update(Pessoa pessoa) throws Exception {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception ex) {
			throw new Exception("Driver do banco de dados não está disponível", ex);
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cadastropessoas-db", "cadastropessoas",
					"cadastropessoas");
			Statement s = conn.createStatement();
			Long id = pessoa.getId();
			s.executeUpdate("UPDATE pessoa SET nome='" + pessoa.getNome() + "', endereco='" + pessoa.getEndereco()
			+ "', sexo='" + pessoa.getSexo() + "', datanascimento='" + pessoa.getDataNascimento() + "' where id=" + id);			
		} catch (Exception ex) {
			throw new Exception("Não foi possível conectar ao banco de dados", ex);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception ignore) {
			}
		}
		return pessoa;
	}
	
	/**
	 * Lista todas as pessoas cadastradas
	 * @return
	 * @throws Exception
	 */
	
	public List<Pessoa> findAll() throws Exception {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception ex) {
			throw new Exception("Driver do banco de dados não está disponível", ex);
		}
		Connection conn = null;
		List<Pessoa> resultado = new ArrayList<Pessoa>();
		
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cadastropessoas-db",
					"cadastropessoas", "cadastropessoas");
			Statement s = conn.createStatement();
			ResultSet resultSet = s.executeQuery("select id, nome, endereco, sexo, datanascimento from pessoa order by id");
			while (resultSet.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setId(resultSet.getLong(1));
				pessoa.setNome(resultSet.getString(2));
				pessoa.setEndereco(resultSet.getString(3));
				pessoa.setSexo(resultSet.getString(4));
				pessoa.setDataNascimento(resultSet.getDate(5));				

				resultado.add(pessoa);
			}

		} catch (Exception ex) {
			throw new ServletException("Não foi possível conectar ao banco de dados", ex);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception ignore) {
			}
		}
		
		return resultado;
	}
	
	/**
	 * Realiza uma busca a partir do nome fornecido
	 * @return
	 * @throws Exception 
	 */
	public List<Pessoa> findName(String nome) throws Exception {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception ex) {
			throw new Exception("Driver do banco de dados não está disponível", ex);
		}
		Connection conn = null;
		List<Pessoa> resultado = new ArrayList<Pessoa>();
		
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cadastropessoas-db",
					"cadastropessoas", "cadastropessoas");
			Statement s = conn.createStatement();
			ResultSet resultSet = s.executeQuery("select id, nome, endereco, sexo, datanascimento from pessoa where nome='" + nome + "' order by id;");
			while (resultSet.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setId(resultSet.getLong(1));
				pessoa.setNome(resultSet.getString(2));
				pessoa.setEndereco(resultSet.getString(3));
				pessoa.setSexo(resultSet.getString(4));
				pessoa.setDataNascimento(resultSet.getDate(5));				

				resultado.add(pessoa);
			}

		} catch (Exception ex) {
			throw new ServletException("Não foi possível conectar ao banco de dados", ex);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception ignore) {
			}
		}
		
		return resultado;
	}
	
	/**
	 * Realiza uma busca a partir do endereço fornecido
	 * @return
	 * @throws Exception 
	 */
	public List<Pessoa> findAddress(String endereco) throws Exception {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception ex) {
			throw new Exception("Driver do banco de dados não está disponível", ex);
		}
		Connection conn = null;
		List<Pessoa> resultado = new ArrayList<Pessoa>();
		
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cadastropessoas-db",
					"cadastropessoas", "cadastropessoas");
			Statement s = conn.createStatement();
			ResultSet resultSet = s.executeQuery("select id, nome, endereco, sexo, datanascimento from pessoa where endereco='" + endereco + "' order by id;");
			while (resultSet.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setId(resultSet.getLong(1));
				pessoa.setNome(resultSet.getString(2));
				pessoa.setEndereco(resultSet.getString(3));
				pessoa.setSexo(resultSet.getString(4));
				pessoa.setDataNascimento(resultSet.getDate(5));				

				resultado.add(pessoa);
			}

		} catch (Exception ex) {
			throw new ServletException("Não foi possível conectar ao banco de dados", ex);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception ignore) {
			}
		}
		
		return resultado;
	}
	
	/**
	 * Realiza uma busca a partir de uma data de nascimento informada
	 * @return
	 * @throws Exception 
	 */
	public List<Pessoa> findBirthday(String nascimento) throws Exception {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception ex) {
			throw new Exception("Driver do banco de dados não está disponível", ex);
		}
		Connection conn = null;
		List<Pessoa> resultado = new ArrayList<Pessoa>();
		
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cadastropessoas-db",
					"cadastropessoas", "cadastropessoas");
			Statement s = conn.createStatement();
			ResultSet resultSet = s.executeQuery("select id, nome, endereco, sexo, datanascimento from pessoa where datanascimento='" + nascimento + "' order by id;");
			while (resultSet.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setId(resultSet.getLong(1));
				pessoa.setNome(resultSet.getString(2));
				pessoa.setEndereco(resultSet.getString(3));
				pessoa.setSexo(resultSet.getString(4));
				pessoa.setDataNascimento(resultSet.getDate(5));				

				resultado.add(pessoa);
			}

		} catch (Exception ex) {
			throw new ServletException("Não foi possível conectar ao banco de dados", ex);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception ignore) {
			}
		}
		
		return resultado;
	}
	
	/**
	 * Delete uma pessoa pelo ID
	 * @param id
	 * @throws Exception
	 */
	public void delete(Long id) throws Exception {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception ex) {
			throw new Exception("Driver do banco de dados não está disponível", ex);
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cadastropessoas-db", "cadastropessoas",
					"cadastropessoas");
			Statement s = conn.createStatement();
			s.executeUpdate("DELETE from pessoa where id=" + id);
		} catch (Exception ex) {
			throw new Exception("Não foi possível conectar ao banco de dados", ex);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception ignore) {
			}
		}
	}
}
