/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo;

/**
 *
 * @author gfsan
 */
public class Pergunta {
    private int id;
    private String pergunta;
    private String isUsada;

    public Pergunta(int id, String pergunta, String usada) {
      this.id = id;
      this.pergunta = pergunta;
      this.isUsada = usada;
    }

    public int getIdPergunta(){
      return this.id;
    }
    public void setIdPergunta(int id){
      this.id = id;
    }
    public String getPergunta(){
      return this.pergunta;
    }
    public void setPergunta(String pergunta){
      this.pergunta = pergunta;
    }
    public String getIsUsada(){
      return this.isUsada;
    }
    public void setIsUsada(String usada){
      this.isUsada = usada;
    }
}
