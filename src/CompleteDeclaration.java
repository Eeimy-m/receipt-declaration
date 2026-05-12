import java.util.ArrayList;
import java.util.List;

public final class CompleteDeclaration extends Declaration {
    private List<Gasto> gastos = new ArrayList<>();

    @Override
    public double getValorImposto() {

    }

    public void addToList(Gasto gasto) {
        gastos.add(gasto);
    }

    public void removeFromList(Gasto gasto) {
        gastos.remove(gasto);
    }
}
