package Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class DeclaracaoCompleta extends Declaracao {
    private final List<Gasto> gastos;

    public DeclaracaoCompleta(double ganhoTributavel, double valorPago, long id) {
        super(ganhoTributavel, valorPago, id);
        gastos = new ArrayList<>();
    }

    @Override
    public double getValorImposto() {
        // 7,5% <R$22.847,88- R$33.919,92>; 15% < R$33.919,93 - R$ 45.012,72>; 22,5% <R$45.012,73 - R$55.976,16> e 27,5%
        //<acima de R$55.976,16>.
        double valorImposto = 0.0;
        double ganhoTributavelAtual = getGanhoTributavel();

        if(ganhoTributavelAtual > 55_976.16) {
            valorImposto += (ganhoTributavelAtual - 55_976.16) * 0.275;
            ganhoTributavelAtual = 55_976.16;
        }
        if(ganhoTributavelAtual > 45_012.73) {
            valorImposto += (ganhoTributavelAtual - 45_012.73) * 0.225;
            ganhoTributavelAtual = 45_012.73;
        }
        if(ganhoTributavelAtual > 33_919.93) {
            valorImposto += (ganhoTributavelAtual - 33_919.93) * 0.15;
            ganhoTributavelAtual = 33_919.93;
        }
        if(ganhoTributavelAtual > 22_847.88) {
            valorImposto += (ganhoTributavelAtual - 22_847.88) * 0.075;
        }

        return valorImposto;
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

    @Override
    public String toString() {
        return "+++ DeclaracaoCompleta +++" + "\n" + super.toString() + "\nGastos dedutíveis: \n"
                + gastos.stream().map(Gasto::toString).collect(Collectors.joining("\n"));
    }

    public void addGasto(Gasto gasto) {
        gastos.add(gasto);
    }

    public void removeGasto(Gasto gasto) {
        gastos.remove(gasto);
    }
}
