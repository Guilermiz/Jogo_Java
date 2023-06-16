/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo;

/**
 *
 * @author gfsan
 */
public class Menu {
    private int opcaoEscolhida;
    
    public Menu() {

    }

    public int getOpcaoEscolhida() {
      return this.opcaoEscolhida;
    }

    public void setOpcaoEscolhida(int opcaoEscolhida) {
      this.opcaoEscolhida = opcaoEscolhida;
    }

    public void mostrarMenu() {
      System.out.println(
        "Menu: \n\n" +
        "1 - Iniciar jogo \n" + 
        "2 - Como jogar \n" + 
        "3 - Informações dos desenvolvedores \n" +
        "4 - Sair \n"
      );
    }

    public void opcaoInvalida(){
      System.out.println("Opção Inválida \n");
    }

    public void informacaoDevs() {
      System.out.println(
        "Os desenvolvedores são: \n" +
        "Guilherme Ferreira Santos - RA:12311222 \n" +
        "Eduardo Correa Lima Silva - RA:12319848 \n" + 
        "Julia Rodrigues da Silva  - RA:123116906 \n" + 
        "Rafael Parreira S. Inacio - RA:123113366 "
      );
    }

    public void mostrarExplicacao() {
      System.out.println(
        "Como Jogar: \n" +
        "\n- Cada jogador deve escolher um personagem. \n" +
        "- Será sorteada uma pergunta por rodada, a qual ambos os jogadores deverão responder. \n" + 
        "- Após selecionar uma alternativa, as respostas serão computadas e o resultado dos jogadores será apresentado. \n" + 
        "- A vida dos jogadores se inicia em 100%, cada erro resulta na perda de 10% de vida. O jogo acabará quando a vida de um deles for igual a zero."
      );
    }
}
