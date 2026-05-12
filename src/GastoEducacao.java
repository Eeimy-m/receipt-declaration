public final class GastoEducacao extends Gasto {
    public static final double DEDUCAO_MAX_EDUCA = 2_000.0;
    private String nomeInstituicao;

    public GastoEducacao(long id, String descricao, double valor, String cnpj, String nomeInstituicao) {
        super(id, descricao, valor, cnpj);
        this.nomeInstituicao = nomeInstituicao;
    }

    @Override
    public String toString() {
        return "GastoEducacao{" +
                "nomeInstituicao='" + nomeInstituicao + '\'' +
                '}';
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }
}
