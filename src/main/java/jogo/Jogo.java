/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package jogo;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author gfsan
 */
public class Jogo {

    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        Menu menu = new Menu();

        // Título do jogo
        System.out.println("Responderar (O jogo) \n");
        // Mostrar menu
        menu.mostrarMenu();

        // Receber e tratar opção escolhida
        System.out.print("Selecione uma opção: ");
        menu.setOpcaoEscolhida(scan.nextInt());
        System.out.print("\n");
        while (menu.getOpcaoEscolhida() != 4) {
          switch(menu.getOpcaoEscolhida()) {
            case 1:
              // iniciar o jogo

              Partida partida = new Partida();
              partida.iniciarPartida();

              ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
              // seleção de personagens dos jogadores
              int primeiroEscolhido = 0;
              for (int i = 1; i <= 2; i++) {
                System.out.println("Jogador " + i + " escolha seu personagem: \n");
                partida.mostrarPersonagens();
                System.out.print("Resposta: ");
                Jogador player = partida.selecionarPersonagem(primeiroEscolhido, scan.nextInt());
                primeiroEscolhido = player.getId();
                jogadores.add(player);
              }

              // decisao de quem joga primeiro
              jogadores = partida.ordemJogadores(jogadores);
              System.out.println("\nIniciando partida... ");

              int qtdRodadas = 1;
              Integer[] perguntasFeitas = new Integer[30];
              // fazer perguntas
              while (((jogadores.get(0).getVida() > 0) && (jogadores.get(1).getVida() > 0)) && (qtdRodadas <= 30)) {
                  
                  System.out.println("\nIniciando Rodada " + qtdRodadas + " \n");
                  
                  partida.exibirDadosJogadores(jogadores);  
                  // chamar rodada
                  Rodada round = new Rodada(perguntasFeitas);
                  perguntasFeitas[qtdRodadas - 1] = round.getIdPergunta();
                  // fazer pergunta
                  round.buscarPergunta();
                  // pegar resposta dos jogadores
                  for (Jogador player : jogadores) {
                      round.escolherAlternativa(player);
                  }
                  System.out.println();
                  round.resultadoRodada(jogadores);
                  
                  qtdRodadas ++;
              }
              
              // resultado
              partida.exibirResultadoPartida(jogadores);

              break;
            case 2:
              // mostrar explicações do jogo
              menu.mostrarExplicacao();
              break;
            case 3:
              // mostrar informações dos devs
              menu.informacaoDevs();
              break;
            default:
              menu.opcaoInvalida();
          }
          System.out.print("\n");
          System.out.print("Selecione uma opção do menu: ");
          menu.setOpcaoEscolhida(scan.nextInt());
          System.out.print("\n");
        }
    }
}
