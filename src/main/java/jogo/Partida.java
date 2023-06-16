/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author gfsan
 */
public class Partida {
    private Scanner scan = new Scanner(System.in);
    public Partida() {

    }
    
    public void iniciarPartida() throws SQLException {
        Connection con = Conexao.getConexao();
        String sql = "UPDATE personagem SET status = 'false'";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.execute();
        stm.close();
        sql = "UPDATE pergunta SET isUsada = 'false'";
        stm = con.prepareStatement(sql);
        stm.execute();
        stm.close();
        con.close();
    }

    public void mostrarPersonagens() throws SQLException {
        // buscar e exibir personagens disponiveis
        Connection con = Conexao.getConexao();
        String sql = "SELECT * FROM personagem WHERE status = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, "false");
        ResultSet rs = stm.executeQuery();
        
        ArrayList<Personagem> personagens = new ArrayList<Personagem>();
        while (rs.next()) {
            Personagem person = new Personagem(rs.getInt(1), rs.getString(2));
            personagens.add(person);
            System.out.println(person.getId() + " - " + person.getNome());
        }
        System.out.println();
        stm.close();
        con.close();
        rs.close();
    }

    public Jogador selecionarPersonagem(int primeiroEscolhido, int personagem) throws SQLException {
        while ((personagem > 4 || personagem < 1) || primeiroEscolhido == personagem) {
            System.out.println("Escolha uma opção válida!");
            System.out.print("Resposta: ");
            personagem = scan.nextInt();
        }
        // funcao de escolha de personagem
        Jogador person = null;
        // marcar que o personagem esta sendo usado no banco de dados
        Connection con = Conexao.getConexao();
        String sql = "UPDATE personagem SET status = 'true' WHERE id = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, personagem);
        stm.execute();
        stm.close();
        // pegar personagem escolhido
        sql = "SELECT * FROM personagem WHERE id = ?";
        stm = con.prepareStatement(sql);
        stm.setInt(1, personagem);
        ResultSet rs = stm.executeQuery();
        
        if (rs.next()) {
            person = new Jogador(rs.getInt(1), rs.getString(2));
            System.out.println("Personagem Escolhido: "+ person.getNome() +" \n");
        }
        stm.close();
        con.close();
        rs.close();
        return person;
    }

    public ArrayList<Jogador> ordemJogadores(ArrayList<Jogador> jogadores) {
      // funcao de escolha de personagem
      Random gerador = new Random();
      int[] numGerado = new int[2];

      for (int i = 0; i < 2; i++) {
        System.out.println("Rodando um dado para jogador " + (i + 1));
        numGerado[i] = gerador.nextInt(6) + 1;
        if (i > 0) {
          while (numGerado[0] == numGerado[1]) {
            numGerado[i] = gerador.nextInt(6) + 1;
          }
        }
        System.out.println("Valor sorteado: " + numGerado[i] + "\n");
      }
      ArrayList<Jogador> players = new ArrayList<Jogador>();
      
      System.out.println("O primeiro a jogar será: ");
      if (numGerado[0] > numGerado[1]) {
        System.out.println("Jogador 1 - " + jogadores.get(0).getNome());
        players.add(jogadores.get(0));
        players.add(jogadores.get(1));
      } else {
        System.out.println("Jogador 2 - " + jogadores.get(1).getNome());
        players.add(jogadores.get(1));
        players.add(jogadores.get(0));
      }
      return players;
    }

    public void exibirDadosJogadores(ArrayList<Jogador> jogadores) {
      // exibir nome e vida dos personagens
      for (Jogador j : jogadores) {
          System.out.println(j.getNome() + " - vida: " + j.getVida() + "%");
      }
    }
    
    public void exibirResultadoPartida(ArrayList<Jogador> jogadores) {
        System.out.println();
        this.exibirDadosJogadores(jogadores);
        if (jogadores.get(0).getVida() > jogadores.get(1).getVida()) {
            System.out.println("\nO Vencedor foi " + jogadores.get(0).getNome());
        } else if (jogadores.get(0).getVida() < jogadores.get(1).getVida()) {
            System.out.println("\nO Vencedor foi " + jogadores.get(1).getNome());
        } else {
            System.out.println("\nHouve um Empate!");
        }
        System.out.println("\n Fim de Jogo!");
    }
}
