/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo;

import java.util.Random;
import java.util.ArrayList;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author gfsan
 */
public class Rodada {
    private int id_pergunta;
    private String alternativaCorreta;
    private Random sorteador = new Random();
    private Scanner scan = new Scanner(System.in);
    
    public int getIdPergunta() {
        return this.id_pergunta;
    }
    
    public Rodada(Integer[] perguntasFeitas) {
        this.id_pergunta = sorteador.nextInt(30) + 1;
        boolean teste = Arrays.asList(perguntasFeitas).contains(this.id_pergunta);
        while (teste) {
            this.id_pergunta = sorteador.nextInt(30) + 1;
            teste = Arrays.asList(perguntasFeitas).contains(this.id_pergunta);
        }
    }
    
    public void buscarPergunta() throws SQLException {
        Pergunta questao = null;
        
        Connection con = Conexao.getConexao();
        String sql = "SELECT * FROM pergunta WHERE id = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, this.id_pergunta);
        ResultSet rs = stm.executeQuery();

        if (rs.next()) {
            questao = new Pergunta(rs.getInt(1), rs.getString(2), rs.getString(3));
        }
        stm.close();
        con.close();
        rs.close();
        
        System.out.println("\n" + questao.getPergunta());
        this.buscarAlternativas();
        this.marcarPerguntaUsada();
    }
    
    public void marcarPerguntaUsada() throws SQLException {
        Connection con = Conexao.getConexao();
        String sql = "UPDATE pergunta SET isUsada = 'true' WHERE id = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, this.id_pergunta);
        stm.execute();
        stm.close();
        con.close();
    }
    
    public void buscarAlternativas() throws SQLException {
        Connection con = Conexao.getConexao();
        String sql = "SELECT * FROM alternativa WHERE id_pergunta = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, this.id_pergunta);
        ResultSet rs = stm.executeQuery();
        
        ArrayList<Alternativa> alternativas = new ArrayList<Alternativa>();
        while (rs.next()) {
            Alternativa opcao = new Alternativa();
            opcao.setId(rs.getInt(1));
            opcao.setAlternativa(rs.getString(2));
            opcao.setIsCorreta(rs.getString(3));
            opcao.setIdPergunta(rs.getInt(4));
            alternativas.add(opcao);
            if ("true".equals(opcao.getIsCorreta())) {
                this.alternativaCorreta = opcao.getAlternativa().substring(0, 1);
            }
        }
        
        for (Alternativa opcao : alternativas) {
            System.out.println(opcao.getAlternativa());
        }
        stm.close();
        con.close();
        rs.close();
    }

    public void escolherAlternativa(Jogador jogador) {
        //
        String[] valoresValidos = {"A", "B", "C", "D", "a", "b", "c", "d"};
        String confirmar = "";
        
        while (!"sim".equals(confirmar)) {
            
            System.out.print("\n" + jogador.getNome() + " escolha sua resposta: ");
            jogador.setAlternativaEscolhida(scan.next().toLowerCase());

            boolean teste = Arrays.asList(valoresValidos).contains(jogador.getAlternativaEscolhida());
            while (teste == false) {
                System.out.println("Escolha uma alternativa válida!");
                System.out.print(jogador.getNome() + " escolha sua resposta: ");
                jogador.setAlternativaEscolhida(scan.next().toLowerCase());
                teste = Arrays.asList(valoresValidos).contains(jogador.getAlternativaEscolhida());
            }
            
            // confirmar escolha
            System.out.print("Confirmar escolha alternativa " + jogador.getAlternativaEscolhida() + "? ");
            confirmar = scan.next().toLowerCase();
        }
    }
    
    public void resultadoRodada(ArrayList<Jogador> players) {
      // mostrar resultado da rodada (quem acertou e errou)
      System.out.println("A resposta correta é Alternativa " + this.alternativaCorreta + "\n");
      
      for (Jogador player : players) {
          if (player.getAlternativaEscolhida().equals(this.alternativaCorreta)) {
              System.out.println("Parabéns " + player.getNome() + " você acertou!");
          } else {
              System.out.println("Sinto muito " + player.getNome() + " você errou!");
              player.reduzVida();
          }
      }
    }
}
