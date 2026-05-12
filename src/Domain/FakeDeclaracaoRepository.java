package Domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class FakeDeclaracaoRepository {
    private static final Map<Long, Declaracao> fakeRepository = new LinkedHashMap<>();

    public void salvar(Declaracao declaracao) {
        long id = declaracao.getId();
        if(fakeRepository.containsKey(id))
            throw new EntityAlreadyExistsException("Entidade já cadastrada" + id);
        fakeRepository.put(id, declaracao);
    }

    public void atualizar(Declaracao declaracao) {
        long id = declaracao.getId();
        if(!fakeRepository.containsKey(id)) throw new EntityAlreadyExistsException("Entidade não cadastrada");
        fakeRepository.replace(id, declaracao);
    }

    public void remover(Declaracao declaracao) {
        remover(declaracao.getId());
    }

    public void remover(long id) {
        if(!fakeRepository.containsKey(id)) throw new EntityAlreadyExistsException("Entidade não cadastrada");
        fakeRepository.remove(id);
    }

    public Optional<Declaracao> buscarPorId(long id) {
        return Optional.ofNullable(fakeRepository.get(id));
    }
}
