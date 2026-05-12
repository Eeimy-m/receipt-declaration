package Application;

import Domain.*;

import java.lang.classfile.instruction.SwitchCase;

public class AdicionarGastoTributavel {
//    private final DeclaracaoRepository repo;
//
//    public AdicionarGastoTributavel(DeclaracaoRepository repo) {
//        this.repo = repo;
//    }

    public void adicionarGasto(long id, String descricao, String cnpj, TipoGasto tipo, double valor, String adicional) {
        if(id < 0) throw new IllegalArgumentException("Id inválido"); //Vale a mesma ideia para todos

        FakeDeclaracaoRepository repo = new FakeDeclaracaoRepository();
        final DeclaracaoCompleta declaracao = (DeclaracaoCompleta) repo.buscarPorId(1).orElseThrow(IllegalStateException::new);

        Gasto gasto = switch (tipo) {
            case SAUDE -> new GastoSaude(id, descricao, valor, cnpj, adicional);
            case EDUCACAO -> new GastoEducacao(id, descricao, valor, cnpj, adicional);
        };

        declaracao.addGasto(gasto);
        repo.atualizar(declaracao);
    }
}
