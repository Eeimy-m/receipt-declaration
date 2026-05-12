package Domain;

import java.util.Objects;

public sealed abstract class Declaracao permits DeclaracaoSimplificada, DeclaracaoCompleta {
    private long id;
    private double ganhoTributavel;
    private double valorPago;

    public Declaracao(double ganhoTributavel, double valorPago, long id) {
        this.ganhoTributavel = ganhoTributavel;
        this.valorPago = valorPago;
        this.id = id;
    }

    public final double getValorAPagar() {
        return getValorImposto() - valorPago - getGastosDedutiveis();
    }

    public double getGastosDedutiveis() {
        return 0.0;
    }

    public abstract double getValorImposto();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Declaracao that = (Declaracao) o;
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