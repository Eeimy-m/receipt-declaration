package Application;

import Domain.DeclaracaoCompleta;
import Domain.DeclaracaoRepository;
import Domain.DeclaracaoSimplificada;

public class CriaRelatorioDeclaracoes {

    public String criaRelatorio() {
        final DeclaracaoRepository repo = new DeclaracaoRepository();
        final DeclaracaoCompleta completa = repo.buscarPorId(1).orElseThrow(IllegalStateException::new);
        final DeclaracaoSimplificada simplificada = repo.buscarPorId(2).orElseThrow(IllegalStateException::new);

        return simplificada + "\n\n" + completa;
    }
}
