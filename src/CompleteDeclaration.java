import java.util.ArrayList;
import java.util.List;

public final class CompleteDeclaration extends Declaration {
    private List<Gasto> gastos = new ArrayList<>();

    @Override
    public double getValorImposto() {

    }

    @Override
    public double getDespesaDedutivel() {

    }

    public void addGasto(Gasto gasto) {
        gastos.add(gasto);
    }

    public void removeGasto(Gasto gasto) {
        gastos.remove(gasto);
    }
}
