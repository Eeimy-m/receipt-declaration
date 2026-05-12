package Application;

import Domain.DeclaracaoCompleta;
import Domain.FakeDeclaracaoRepository;
import Domain.DeclaracaoSimplificada;

public class CriaRelatorioDeclaracoes {

    public String criaRelatorio() {
        final FakeDeclaracaoRepository repo = new FakeDeclaracaoRepository();
        final DeclaracaoCompleta completa = (DeclaracaoCompleta) repo.buscarPorId(1).orElseThrow(IllegalStateException::new);
        final DeclaracaoSimplificada simplificada = (DeclaracaoSimplificada) repo.buscarPorId(2).orElseThrow(IllegalStateException::new);

        return simplificada + "\n\n" + completa;
    }
}
