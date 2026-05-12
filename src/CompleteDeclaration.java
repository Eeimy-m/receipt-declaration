import java.util.ArrayList;
import java.util.List;

public final class CompleteDeclaration extends Declaration {
    private List<Gasto> gastos = new ArrayList<>();

    public CompleteDeclaration(double ganhoTributavel, double valorPago, long id, List<Gasto> gastos) {
        super(ganhoTributavel, valorPago, id);
        this.gastos = gastos;
    }

    @Override
    public double getValorImposto() {

    }

    @Override
    public double getGastosDedutiveis() {

    }

    public void addGasto(Gasto gasto) {
        gastos.add(gasto);
    }

    public void removeGasto(Gasto gasto) {
        gastos.remove(gasto);
    }
}
