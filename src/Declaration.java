import java.util.Objects;

public sealed abstract class Declaration permits SimplifiedDeclaration, CompleteDeclaration{
    private long id;
    private double ganhoTributavel;
    private double valorPago;

    public Declaration(double ganhoTributavel, double valorPago, long id) {
        this.ganhoTributavel = ganhoTributavel;
        this.valorPago = valorPago;
        this.id = id;
    }

    public double getValorAPagar() {
        return getValorImposto() - valorPago - getDespesaDedutivel();
    }

    public double getDespesaDedutivel() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Declaration that = (Declaration) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Declaration{" +
                "id=" + id +
                ", ganhoTributavel=" + ganhoTributavel +
                ", valorPago=" + valorPago +
                '}';
    }

    public abstract double getValorImposto();

    public double getGanhoTributavel() {
        return ganhoTributavel;
    }

    public double getValorPago() {
        return valorPago;
    }

    public long getId() {
        return id;
    }

    public void setGanhoTributavel(double ganhoTributavel) {
        this.ganhoTributavel = ganhoTributavel;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
}