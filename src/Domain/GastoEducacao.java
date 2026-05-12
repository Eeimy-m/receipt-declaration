package Domain;

public final class GastoEducacao extends Gasto {
    public static final double DEDUCAO_MAX_EDUCA = 2_000.0;
    private String registroConselho;

    public GastoEducacao(long id, String descricao, double valor, String cnpj, String nomeInstituicao) {
        super(id, descricao, valor, cnpj);
        this.registroConselho = nomeInstituicao;
    }

    @Override
    public String toString() {
        return "| Gastos com Educação | " + "registro = " + " " + registroConselho + super.toString();
    }

    public String getNomeInstituicao() {
        return registroConselho;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.registroConselho = nomeInstituicao;
    }
}
