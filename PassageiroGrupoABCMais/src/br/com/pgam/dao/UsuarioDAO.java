package br.com.pgam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.pgam.connection.ConnectionFactory;
import br.com.pgam.model.Usuario;

public class UsuarioDAO {

	// a conexão com o banco de dados
	private static Connection connection;

	public UsuarioDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Usuario usuario) {

		// cria um preparedStatement
		String sql = "INSERT INTO login" + " (USUARIO,SENHA,EMAIL,PERFIL)" + " values (?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getPerfil());
			// stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Usuario> getLista() {
		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			PreparedStatement stmt = connection.prepareStatement("select * from login");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("ID_USUARIO"));
				usuario.setUsuario(rs.getString("USUARIO"));
				usuario.setSenha(rs.getString("SENHA"));
				usuario.setEmail(rs.getString("EMAIL"));
				usuario.setPerfil(rs.getString("PERFIL"));

				// montando a data através do Calendar
				// Calendar data = Calendar.getInstance();
				// data.setTime(rs.getDate("dataNascimento"));
				// usuario.setDataNascimento(data);

				// adicionando o objeto à lista
				usuarios.add(usuario);
			}

			rs.close();
			stmt.close();
			return usuarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Usuario usuario) {
		String sql = "update login set usuario=?, senha=?, email=?, perfil=? where id_usuario=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getPerfil());
			stmt.setInt(5, usuario.getId());
			// stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Usuario buscaUsuario(long id) {

		String sql = "SELECT * FROM login WHERE ID_USUARIO=" + id;

		Usuario usuario = new Usuario();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				usuario.setId(rs.getInt("ID_USUARIO"));
				usuario.setUsuario(rs.getString("USUARIO"));
				usuario.setSenha(rs.getString("SENHA"));
				usuario.setEmail(rs.getString("EMAIL"));
				usuario.setPerfil(rs.getString("PERFIL"));
			}
			
			rs.close();
			stmt.close();
			return usuario;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void remove(Usuario usuario) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from login where id_usuario=?");
			stmt.setLong(1, usuario.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean existeUsuario(Usuario usuario) {
		
		if (usuario == null) {
			throw new IllegalArgumentException("Usuário não deve ser nulo");
		}

		try {
			PreparedStatement stmt = connection.prepareStatement("select * from login where usuario = ? and senha = ?");
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getSenha());
			ResultSet rs = stmt.executeQuery();

			boolean encontrado = rs.next();
			rs.close();
			stmt.close();

			return encontrado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
