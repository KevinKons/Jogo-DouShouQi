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
public class IdentificaPecasAtacadas implements StrategyTime<String> {

    @Override
    public String calcular(Time time) {
        VisitorTime buscaPecasAtacadas = new BuscaPecasAtacadasVisitor();
        time.accept(buscaPecasAtacadas);
        List<Peca> pecasAtacadas = (List<Peca>) buscaPecasAtacadas.getValue();
        String retorno = "";
        for(Peca peca : pecasAtacadas) {
            retorno += peca.getNome() + "\n";
        }
        
        return retorno;
    }
    
}
