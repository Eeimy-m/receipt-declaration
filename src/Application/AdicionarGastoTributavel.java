package Application;

import Domain.*;

import java.lang.classfile.instruction.SwitchCase;

public class AdicionarGastoTributavel {

    public void adicionarGasto(long id, String descricao, String cnpj, TipoGasto tipo, double valor, String adicional) {
        if(id < 0) throw new IllegalArgumentException("Id inválido"); //Vale a mesma ideia para todos

        DeclaracaoRepository repo = new DeclaracaoRepository();
        final DeclaracaoCompleta declaracao = (DeclaracaoCompleta) repo.buscarPorId(1).orElseThrow(IllegalStateException::new);

        Gasto gasto = switch (tipo) {
            case SAUDE -> new GastoEducacao(id, descricao, valor, cnpj, adicional);
            case EDUCACAO -> new GastoEducacao(id, descricao, valor, cnpj, adicional);
        };

        declaracao.addGasto(gasto);
        repo.salvar(declaracao);
    }
}
