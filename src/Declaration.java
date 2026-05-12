public sealed abstract class Declaration permits SimplifiedDeclaration, CompleteDeclaration{
    private double ganhoTributavel;
    private double valorPago;

    public Declaration(double ganhoTributavel, double valorPago) {
        this.ganhoTributavel = ganhoTributavel;
        this.valorPago = valorPago;
    }

    public Declaration() {}

    public double getValorAPagar() {

    }

    public double getDespesaDedutivel() {

    }

    public abstract double getValorImposto();

    public double getGanhoTributavel() {
        return ganhoTributavel;
    }

    public double getValorPago() {
        return valorPago;
    }
}