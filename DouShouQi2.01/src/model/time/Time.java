package model.time;

import java.util.ArrayList;
import java.util.List;
import model.Peca;
import model.terrenos.Terreno;
import model.time.strategy.StrategyTime;
import model.time.visitor.VisitorTime;

/**
 *
 * @author Avell
 */
public class Time {
    
    private List<Peca> pecas = new ArrayList<>();
    private List<Terreno> terrenos = new ArrayList<>(); //Armadilhas e Toca pertencem a um time;
    private String nome;
    private StrategyTime strategy;
    
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

    public void accept(VisitorTime visitor) {
        for(Peca peca : pecas) {
            visitor.visit(peca);
        }
    }

    public void setStrategy(StrategyTime strategy) {
        this.strategy = strategy;
    }
    
    public Object calcularStrategy() {
        return strategy.calcular(this);
    }

    public Peca removerPeca(Peca pecaMorta) {
        for(int i = 0; i < pecas.size(); i++) {
            Peca peca = pecas.get(i);
            if(peca.getNome().equalsIgnoreCase(pecaMorta.getNome())) {
                return pecas.remove(i);
            }
        }
        throw new NullPointerException("Peca atacada não encontrada");
    }
    
    
    
}
