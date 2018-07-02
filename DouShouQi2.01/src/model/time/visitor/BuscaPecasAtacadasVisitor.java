package model.time.visitor;

import java.util.ArrayList;
import java.util.List;
import model.Peca;

/**
 *
 * @author Avell
 */
public class BuscaPecasAtacadasVisitor implements VisitorTime {

    private List<Peca> pecasAtacadas = new ArrayList<>();

    @Override
    public void visit(Peca peca) {
        for (Peca pecaMorta : peca.getPecasAtacadas()) {
            pecasAtacadas.add(pecaMorta);
        }
    }

    @Override
    public Object getValue() {
        return pecasAtacadas;
    }

}
