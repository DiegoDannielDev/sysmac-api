package br.com.pacotes.repositorys;

import br.com.pacotes.entitys.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {


    Contato findFirstByNome(String nome);

	List<Contato> findAllByNomeIgnoreCaseContaining(String nome);

//	@Query(value = "SELECT c FROM contato c")
//	List<Contato> buscaTodosComOrdenacao(Sort sort);

//	@Query(value = "SELECT c FROM contato c ORDER BY nome")
//	Stream<Contato> buscaTodosContatos();
}
