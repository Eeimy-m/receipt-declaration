import java.util.ArrayList;
import java.util.List;

public final class CompleteDeclaration extends Declaration {
    private final List<Gasto> gastos;

    public CompleteDeclaration(double ganhoTributavel, double valorPago, long id) {
        super(ganhoTributavel, valorPago, id);
        gastos = new ArrayList<>();
    }

    @Override
    public double getValorImposto() {
        return 0;
    }

    @Override
    public double getGastosDedutiveis() {
        double totalSaude = gastos.stream()
                .filter(e -> e instanceof GastoSaude)
                .mapToDouble(Gasto::getValor)
                .sum();

        double totalEducacao = gastos.stream()
                .filter(e -> e instanceof GastoEducacao)
                .mapToDouble(Gasto::getValor)
                .sum();

        return Math.min(totalEducacao, GastoEducacao.DEDUCAO_MAX_EDUCA) + Math.min(totalSaude, GastoSaude.DEDUCAO_MAX_SAUDE);
    }

    public void addGasto(Gasto gasto) {
        gastos.add(gasto);
    }

    public void removeGasto(Gasto gasto) {
        gastos.remove(gasto);
    }
}
