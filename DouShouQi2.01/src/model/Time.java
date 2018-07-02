package model;

import java.util.ArrayList;
import java.util.List;
import model.terrenos.Terreno;

/**
 *
 * @author Avell
 */
public class Time {
    
    private List<Peca> pecas = new ArrayList<>();
    private List<Terreno> terrenos = new ArrayList<>(); //Armadilhas e Toca pertencem a um time;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    public List<Peca> getPecas() {
        return pecas;
    }

    public void addPecas(Peca peca) {
        this.pecas.add(peca);
    }
    
    public Peca getPeca(String nome) {
        for(Peca p : pecas) {
            if(p.getNome().equalsIgnoreCase(nome))
                return p;
        }
        throw new NullPointerException("Peça não existente");
    }

    public List<Terreno> getTerrenos() {
        return terrenos;
    }
    
    
    public Terreno getTerreno(int y, int x) {
        for(Terreno t : terrenos) {
            if(t.getPosX() == x && t.getPosY() == y)
                return t;
        }
        
        throw new NullPointerException("Terreno não existente");
    }

    public Terreno getToca() {
        for(Terreno t : terrenos) {
            if(t.getNome().equalsIgnoreCase("TocaA") || t.getNome().equalsIgnoreCase("TocaB"))
                return t;
        }
        
        throw new NullPointerException("Terreno não existente");
    }
    
    public void addTerreno(Terreno terreno) {
        this.terrenos.add(terreno);
    }
    
    
}
