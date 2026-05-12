package Domain;

import Application.AdicionarGastoTributavel;
import Application.CriaRelatorioDeclaracoes;
import Application.CriarDeclaracoesService;
import Application.TipoGasto;

public class Main {
    static void main() {
        final AdicionarGastoTributavel addGastosServices = new AdicionarGastoTributavel();
        final CriaRelatorioDeclaracoes criaRelatorioDeclaracoes = new CriaRelatorioDeclaracoes();
        final CriarDeclaracoesService criarDeclaracoesService = new CriarDeclaracoesService();

        criarDeclaracoesService.criarDeclaracoes(50_000, 5_000);

        addGastosServices.adicionarGasto(1, "Corote", "123", TipoGasto.EDUCACAO, 3.59, "IFSP");
        addGastosServices.adicionarGasto(2, "Unimed", "321", TipoGasto.SAUDE, 1_000.0, "24165");

        System.out.println(criaRelatorioDeclaracoes.criaRelatorio());
    }
}
