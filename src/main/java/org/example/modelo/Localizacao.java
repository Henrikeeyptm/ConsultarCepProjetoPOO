// Verifique se o nome do pacote está correto!
// Pela sua imagem, o pacote é "org.example.modelo"
package org.example.modelo;

/**
 * [REQUISITO DE SOBREPOSIÇÃO - CLASSE PAI]
 * Classe base para qualquer tipo de localização.
 * Deve ser abstrata porque tem um método abstrato.
 */
public abstract class Localizacao {

  /**
   * Este é o método abstrato que FORÇA as classes filhas
   * (como Endereco) a implementarem sua própria versão.
   * Note que ele termina com ponto e vírgula, sem chaves {}.
   */
  public abstract void exibirResumo();
}