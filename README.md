Documentação do Projeto: Consulta de Endereço por CEP



Data: 11 de julho de 2025


Autor: Henrique José De Souza Nogueira e Romeu Pacheco


1. Visão Geral
Este projeto é uma aplicação simples em Java que consulta e exibe informações de endereço a partir de um CEP (Código de Endereçamento Postal). O objetivo principal é demonstrar na prática os conceitos fundamentais de Programação Orientada a Objetos (POO) — como Herança, Sobreposição e Encapsulamento — em um cenário real que envolve a integração com uma API externa e o gerenciamento de dependências com Maven.

O programa solicita um CEP ao usuário, comunica-se com a API pública ViaCEP, processa a resposta em formato JSON e exibe os dados do endereço de forma estruturada no console.

2. Estrutura do Projeto
O código foi desenvolvido utilizando a estrutura padrão do Maven, que organiza o projeto de forma clara e facilita a automação de compilação e gerenciamento de bibliotecas.

.
├── pom.xml     // Arquivo de configuração do Maven


└── src/


    └── main/

    
        └── java/

        
            └── org/

            
                └── example/

                
                    ├── modelo/     // Pacote para as classes de "domínio"

                    
                    │   ├── Localizacao.java

                    
                    │   └── Endereco.java

                    
                    ├── servico/    // Pacote para a lógica de negócio e API

                    
                    │   └── ConsultaCepService.java

                    
                    └── Main.java   // Classe principal para executar o programa

                    
pom.xml: O coração do projeto Maven. Define as informações do projeto e, mais importante, suas dependências, como a biblioteca Gson.

modelo: Agrupa as classes que representam os dados do nosso sistema (Localizacao, Endereco).

servico: Contém as classes responsáveis pela lógica de negócio, como a comunicação com a API ViaCEP.

Main.java: O ponto de entrada da aplicação, responsável por orquestrar as chamadas e interagir com o usuário.

3. Componentes Principais
3.1. As Classes de Modelo (Herança e Sobreposição)
O núcleo do nosso modelo de dados é construído sobre o conceito de herança para criar uma base comum e extensível.

A Classe Abstrata Localizacao
Este é o "molde" genérico para qualquer tipo de localização em nosso sistema.

Arquivo: src/main/java/org/example/modelo/Localizacao.java

Java

public abstract class Localizacao {
    public abstract void exibirResumo();
}
Propósito: Definir um contrato comum (exibirResumo) que todas as classes filhas são obrigadas a implementar. Por conter um método abstrato, a classe também é abstrata.

A Classe Concreta Endereco
Esta classe representa um endereço real e herda da nossa base Localizacao.

Arquivo: src/main/java/org/example/modelo/Endereco.java

Java

public class Endereco extends Localizacao {
    private String cep;
    private String logradouro;
    // ... outros atributos

    @Override
    public void exibirResumo() {
        System.out.println("CEP: " + this.cep);
        System.out.println("Endereço: " + this.logradouro + ", " + this.bairro);
        // ...
    }
}
Análise da Estrutura:

extends Localizacao: Estabelece a relação de herança. Endereco é um tipo de Localizacao.

@Override: Indica que o método exibirResumo está sobrepondo a implementação da classe-pai, cumprindo o contrato definido.

3.2. A Classe de Serviço ConsultaCepService (Encapsulamento)
Esta classe encapsula toda a complexidade de se comunicar com a API ViaCEP.

Arquivo: src/main/java/org/example/servico/ConsultaCepService.java

Propósito: Servir como uma "fachada" simples para o resto do programa. A classe Main não precisa saber como fazer uma requisição HTTP ou como decodificar um JSON; ela simplesmente chama o método buscarEndereco. Isso é encapsulamento.

Tecnologias Internas: Utiliza o HttpClient nativo do Java para a comunicação e a biblioteca Gson para converter a resposta JSON em um objeto Endereco.

3.3. A Classe Principal Main
Esta classe orquestra a execução da aplicação.

Arquivo: src/main/java/org/example/Main.java

Java

public class Main {
    public static void main(String[] args) {
        ConsultaCepService servico = new ConsultaCepService();
        // ... lógica para pegar o CEP do usuário

        try {
            Endereco endereco = servico.buscarEndereco(cep);
            endereco.exibirResumo();
        } catch (RuntimeException e) {
            System.err.println("❌ Erro: " + e.getMessage());
        }
    }
}
Análise da Execução:

Cria uma instância da classe de serviço.

Pede a entrada do usuário.

Chama o serviço para buscar os dados.

Chama o método sobreposto exibirResumo() do objeto Endereco retornado.

Utiliza um bloco try-catch para lidar com possíveis erros (CEP não encontrado, falha de conexão), tornando a aplicação mais robusta.

4. Tecnologias e Bibliotecas
Java (JDK 17 ou superior): Linguagem de programação principal.

Apache Maven: Ferramenta para automação de build e gerenciamento de dependências.

Gson: Biblioteca do Google utilizada para a conversão (parsing) de JSON para objetos Java.

ViaCEP API: Serviço web público para consulta de CEPs no Brasil.

5. Como Compilar e Executar
Pré-requisitos:

Ter o JDK (Java Development Kit) instalado.

Ter o Apache Maven instalado e configurado nas variáveis de ambiente.

Passos via linha de comando:
Navegue até a pasta raiz do projeto (onde o arquivo pom.xml está localizado) e execute os seguintes comandos:

Compilar o projeto:

Bash

mvn compile
Executar a aplicação:

Bash

mvn exec:java -Dexec.mainClass="org.example.Main"
O programa solicitará a digitação de um CEP, e a saída será exibida no terminal.

6. Conclusão
Este projeto demonstra com sucesso a aplicação de conceitos essenciais de POO em um contexto prático e útil. Através da herança, da sobreposição de métodos e do encapsulamento de lógicas complexas, o sistema se torna limpo, coeso e de fácil manutenção. Além disso, a utilização do Maven para gerenciar dependências externas, como a biblioteca Gson, reflete as práticas modernas de desenvolvimento de software em Java.
