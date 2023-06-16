/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo;

/**
 *
 * @author gfsan
 */
public class Alternativa {
    private int id;
    private String alternativa;
    private String isCorreta;
    private int id_pergunta;

    public Alternativa() {
        
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getAlternativa() {
        return this.alternativa;
    }
    
    public String getIsCorreta() {
        return this.isCorreta;
    }
    
    public int getIdPergunta() {
        return this.id_pergunta;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setAlternativa(String alternativa) {
        this.alternativa = alternativa;
    }
    
    public void setIsCorreta(String isCorreta) {
        this.isCorreta = isCorreta;
    }
    
    public void setIdPergunta(int id) {
        this.id_pergunta = id;
    }
}
