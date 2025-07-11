package org.example.modelo;

import com.google.gson.annotations.SerializedName;

// Herda de uma classe abstrata para cumprir o requisito de sobreposição
public class Endereco extends Localizacao {

  // Não precisa de @SerializedName se os nomes forem iguais ao JSON
  private String cep;
  private String logradouro;
  private String complemento;
  private String bairro;

  @SerializedName("localidade") // No JSON o campo é "localidade"
  private String cidade;

  @SerializedName("uf") // No JSON o campo é "uf"
  private String estado;

  // Construtor, Getters...

  /**
   * [REQUISITO DE SOBREPOSIÇÃO - IMPLEMENTAÇÃO]
   * Implementa o método da classe pai para exibir um resumo formatado.
   */
  @Override
  public void exibirResumo() {
    System.out.println("CEP: " + this.cep);
    System.out.println("Endereço: " + this.logradouro + ", " + this.bairro);
    System.out.println("Cidade: " + this.cidade + " - " + this.estado);
  }

  @Override
  public String toString() {
    return "Endereco{" +
            "cep='" + cep + '\'' +
            ", logradouro='" + logradouro + '\'' +
            ", cidade='" + cidade + '\'' +
            ", estado='" + estado + '\'' +
            '}';
  }
}