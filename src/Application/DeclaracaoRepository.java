package Application;

import Domain.Declaracao;

import java.util.Optional;

public interface DeclaracaoRepository {
    void salvar(Declaracao declaracao) ;
    void atualizar(Declaracao declaracao);
    void remover(Declaracao declaracao);
    void remover(long id);
    Optional<Declaracao> buscarPorId(long id);
}
