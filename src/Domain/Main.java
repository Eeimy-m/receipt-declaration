package Domain;

import Application.*;

import java.security.Provider;

public class Main {
    static void main() {
//        final DeclaracaoRepository repo = new DeclaracaoRepository();

        final AdicionarGastoTributavel addGastosServices = new AdicionarGastoTributavel();
        final CriaRelatorioDeclaracoes criaRelatorioDeclaracoes = new CriaRelatorioDeclaracoes();
        final CriarDeclaracoesService criarDeclaracoesService = new CriarDeclaracoesService();

        criarDeclaracoesService.criarDeclaracoes(50_000, 5_000);

        addGastosServices.adicionarGasto(1, "Corote", "123", TipoGasto.EDUCACAO, 3.59, "IFSP");
        addGastosServices.adicionarGasto(2, "Unimed", "321", TipoGasto.SAUDE, 1_000.0, "24165");

        System.out.println(criaRelatorioDeclaracoes.criaRelatorio());
    }
}
