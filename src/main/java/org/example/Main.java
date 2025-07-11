import org.example.modelo.Endereco;
import org.example.servico.ConsultaCepService;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("🔎 Bem-vindo ao Consulta CEP! 🔎");
    System.out.println("---------------------------------");

    ConsultaCepService servico = new ConsultaCepService();
    Scanner scanner = new Scanner(System.in);

    System.out.print("Digite um CEP para consulta (apenas números): ");
    String cep = scanner.nextLine();

    try {

      Endereco endereco = servico.buscarEndereco(cep);

      System.out.println("\n✅ Endereço encontrado! ✅");


      endereco.exibirResumo();


      System.out.println("\n--- Testando sobrecarga com CEP 89300-000 ---");
      Endereco outroEndereco = servico.buscarEndereco(89300000);
      outroEndereco.exibirResumo();

    } catch (RuntimeException e) {
      System.err.println("\n❌ Erro ao consultar o CEP: " + e.getMessage());
    }

    scanner.close();
  }
}