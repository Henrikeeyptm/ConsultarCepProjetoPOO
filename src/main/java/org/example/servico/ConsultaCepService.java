package org.example.servico;

import org.example.modelo.Endereco;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCepService {

  private HttpClient client = HttpClient.newHttpClient();
  private Gson gson = new Gson();

  /**
   * [REQUISITO DE SOBRECARGA DE MÉTODO]
   * Busca um endereço recebendo o CEP como uma String.
   */
  public Endereco buscarEndereco(String cep) {
    // Remove traços e pontos do CEP, caso existam
    String cepTratado = cep.replaceAll("[^0-9]", "");
    URI url = URI.create("https://viacep.com.br/ws/" + cepTratado + "/json/");

    HttpRequest request = HttpRequest.newBuilder().uri(url).build();

    try {
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());



        if (response.statusCode() == 200) {
        // Usa a biblioteca Gson para converter o JSON em um objeto Endereco
        return gson.fromJson(response.body(), Endereco.class);
      } else {
        throw new RuntimeException("Falha ao buscar CEP. Código: " + response.statusCode());
      }
    } catch (Exception e) {
      throw new RuntimeException("Não foi possível obter o endereço para o CEP: " + cep, e);
    }
  }

  /**
   * [REQUISITO DE SOBRECARGA DE MÉTODO]
   * Versão que busca um endereço recebendo o CEP como um número inteiro.
   */
  public Endereco buscarEndereco(int cep) {
    // Converte o int para String e chama o outro método
    return buscarEndereco(String.valueOf(cep));
  }
}
