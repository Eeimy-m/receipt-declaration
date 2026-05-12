package Application;

import Domain.DeclaracaoCompleta;
import Domain.DeclaracaoRepository;
import Domain.DeclaracaoSimplificada;

public class CriarDeclaracoesService {

    public void criarDeclaracoes(double valorPago, double rendaTributavel) {
        if(rendaTributavel < 0) throw new IllegalArgumentException("Renda tributável inválida");
        if(valorPago < 0) throw new IllegalArgumentException("Valor pago inválido");

        final DeclaracaoCompleta declaracaoCompleta = new DeclaracaoCompleta(valorPago, rendaTributavel, 1);
        final DeclaracaoSimplificada declaracaoSimplificada = new DeclaracaoSimplificada(valorPago, rendaTributavel, 2);

        final DeclaracaoRepository repo = new DeclaracaoRepository();
        repo.salvar(declaracaoCompleta);
        repo.salvar(declaracaoSimplificada);
    }

}
