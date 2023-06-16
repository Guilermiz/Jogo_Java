/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo;

/**
 *
 * @author gfsan
 */
public class Jogador extends Personagem {
    private int vida = 100;
    private String alternativaEscolhida;
    
    public Jogador(int id_personagem, String nome_personagem) {
        super(id_personagem, nome_personagem);
    }
    
    public int getVida() {
      return this.vida;
    }

    public void setVida(int vida) {
      this.vida = vida;
    }
    
    public String getAlternativaEscolhida() {
      return this.alternativaEscolhida;
    }

    public void setAlternativaEscolhida(String alternativa) {
      this.alternativaEscolhida = alternativa;
    }

    public void reduzVida() {
      this.vida -= 10;
    }
}
