package model.time.strategy;

import java.util.List;
import model.Peca;
import model.time.Time;
import model.time.visitor.BuscaPecasAtacadasVisitor;
import model.time.visitor.VisitorTime;

/**
 *
 * @author Avell
 */
public class CalcPontuacaoStrategy implements StrategyTime{

    @Override
    public Object calcular(Time time) {
        VisitorTime buscaPecasAtacadas = new BuscaPecasAtacadasVisitor();
        time.accept(buscaPecasAtacadas);
        List<Peca> pecasAtacadas = (List<Peca>) buscaPecasAtacadas.getValue();
        
        int pontuacao = 0;
        for(Peca pecaAtacada : pecasAtacadas) {
            pontuacao += pecaAtacada.getForca();
        }
        
        return pontuacao;
    }
    
}
