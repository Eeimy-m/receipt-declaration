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
        return 0.0;
    }

    public void addGasto(Gasto gasto) {
        gastos.add(gasto);
    }

    public void removeGasto(Gasto gasto) {
        gastos.remove(gasto);
    }
}
