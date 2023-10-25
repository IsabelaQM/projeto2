package br.edu.iftm.contact.contatos.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.edu.iftm.contact.contatos.domain.Contato;

@Component
public class ContatoDao {

    @Autowired
    JdbcTemplate db;

    public List<Contato> getContatos() {
		String sql = "select  nome, dataNascimento, matricula from tb_aluno";

		return db.query(sql, (res, rowNum) -> {
			return new Contato(
					res.getString("nome"),
					res.getDate("dataNascimento"),
					res.getString("matricula")
			);
		});
	}

	public List<Contato> getContatos(String nome) {
		String sql = "select  nome, dataNascimento, matricula from tb_aluno where lower(nome) like ?";

		return db.query(sql,
		                new BeanPropertyRowMapper<>(Contato.class),
						new Object[]{"%"+nome+"%"});
	}

	public Contato getContato(String matricula) {
		String sql = "select  nome, dataNascimento, matricula from tb_aluno where matricula = ?";

		List<Contato> contatos=  db.query(sql,
		                new BeanPropertyRowMapper<>(Contato.class),
						new Object[]{matricula});
		if (contatos != null && contatos.size() > 0) {
			return contatos.get(0);
		} else {
			return null;
		}
	}

	public void inserirContato(Contato contato) {
		String sql = "insert into tb_aluno(nome,dataNascimento,matricula) values(?,?,?)";

		db.update(sql,new Object[]{contato.getNome(),contato.getDataNascimento(),contato.getMatricula()});
	}

	public void updateContato(Contato contato) {
		String sql = "update tb_aluno set nome = ?, dataNascimento = ? where matricula = ?";

		db.update(sql,new Object[]{contato.getNome(),contato.getDataNascimento(),contato.getMatricula()});
	}

	public void deleteContato(String matricula) {
		String sql = "delete from tb_aluno where matricula = ?";

		db.update(sql,new Object[]{matricula});
	}	

}