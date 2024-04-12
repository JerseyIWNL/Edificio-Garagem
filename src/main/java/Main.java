import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClassificadorVeiculo classificador = new ClassificadorVeiculo();

        while (true) {
            System.out.println("Informe o tipo de veículo (Ex: motocicleta leve, carro de passeio hatchback, caminhonete):");
            String tipo = scanner.nextLine();

            System.out.println("Informe o peso do veículo:");
            double peso = scanner.nextDouble();
            scanner.nextLine(); 

            Veiculo veiculo = null;

            if (tipo.equalsIgnoreCase("motocicleta leve") || tipo.equalsIgnoreCase("motocicleta padrão") ||
                tipo.equalsIgnoreCase("motocicleta pesada")) {
                veiculo = new Motocicleta(tipo, peso);
            } else if (tipo.equalsIgnoreCase("carro de passeio hatchback") || tipo.equalsIgnoreCase("carro de passeio sedan") ||
                       tipo.equalsIgnoreCase("suv")) {
                veiculo = new CarroDePasseio(tipo, peso);
            } else if (tipo.equalsIgnoreCase("caminhonete")) {
                veiculo = new Camionete(tipo, peso);
            } else if (tipo.equalsIgnoreCase("furgão")) {
                veiculo = new Furgao(tipo, peso);
            } else {
                System.out.println("Tipo de veículo não reconhecido.");
                continue;
            }

            if (classificador.verificarAceitacao(veiculo)) {
                double precoPorHora = classificador.calcularPrecoPorHora(veiculo);
                System.out.println("O preço por hora estacionada para este veículo é: R$ " + precoPorHora);
            } else {
                System.out.println("Este veículo não pode ser aceito no estacionamento.");
            }

            System.out.println("Deseja informar um novo veículo? (sim/não)");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("não")) {
                break;
            }
        }

        scanner.close();
    }
}
