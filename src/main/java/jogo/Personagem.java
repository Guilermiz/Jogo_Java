/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo;

/**
 *
 * @author gfsan
 */
public class Personagem {
    private int id;
    private String nome;
    private String status;

    public Personagem(int id, String nome) {
      this.id = id;
      this.nome = nome;
    }

    public String getNome() {
      return this.nome;
    }
    

    public int getId() {
      return this.id;
    }

    public void setNome(String nome) {
      this.nome = nome;
    }

    public String getStatus() {
      return this.status;
    }

    public void setStatus(String status) {
      this.status = status;
    }
}
