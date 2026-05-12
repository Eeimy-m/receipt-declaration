public final class GastoSaude extends Gasto {
    public static final double DEDUCAO_MAX_SAUDE = 1_500.0;
    private String registroConselho;

    public GastoSaude(long id, String descricao, double valor, String cnpj, String registroConselho) {
        super(id, descricao, valor, cnpj);
        this.registroConselho = registroConselho;
    }

    @Override
    public String toString() {
        return "GastoSaude{" +
                "registroConselho='" + registroConselho + '\'' +
                '}';
    }

    public String getRegistroConselho() {
        return registroConselho;
    }

    public void setRegistroConselho(String registroConselho) {
        this.registroConselho = registroConselho;
    }
}
