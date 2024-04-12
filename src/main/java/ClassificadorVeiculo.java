public class ClassificadorVeiculo {
    public double calcularPrecoPorHora(Veiculo veiculo) {
        double precoPorHora = 0;

        if (veiculo instanceof Motocicleta) {
            Motocicleta moto = (Motocicleta) veiculo;
            if (moto.getPeso() <= 100) {
                precoPorHora = 2.00;
            } else if (moto.getPeso() <= 299.9) {
                precoPorHora = 4.00;
            } else {
                precoPorHora = 10.00;
            }
        } else if (veiculo instanceof CarroDePasseio) {
            CarroDePasseio carro = (CarroDePasseio) veiculo;
            if (carro.getPeso() <= 2.0) {
                precoPorHora = 13.00;
            } else {
                precoPorHora = 25.00; 
            }
        } else if (veiculo instanceof Camionete || veiculo instanceof Furgao) {
            if (veiculo.getPeso() <= 3.0) {
                precoPorHora = 25.00;
            } else if (veiculo.getPeso() <= 6.0) {
                precoPorHora = 50.00;
            }
        }

        return precoPorHora;
    }

    public boolean verificarAceitacao(Veiculo veiculo) {
        if (veiculo instanceof Motocicleta || veiculo instanceof CarroDePasseio ||
            veiculo instanceof Camionete || veiculo instanceof Furgao) {
            return true;
        } else {
            return false;
        }
    }
}
