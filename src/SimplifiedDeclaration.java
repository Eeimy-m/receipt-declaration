public final class SimplifiedDeclaration extends Declaration {

    public SimplifiedDeclaration(double ganhoTributavel, double valorPago, long id) {
        super(ganhoTributavel, valorPago, id);
    }

    @Override
    public double getValorImposto() {
        if(getGanhoTributavel() <= 22_847.88) return 0.0;
        return (getGanhoTributavel() - 22_847.88) * 0.2;
    }
}
