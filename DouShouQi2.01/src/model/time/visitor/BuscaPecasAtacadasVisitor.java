package model.time.visitor;

import java.util.ArrayList;
import java.util.List;
import model.Peca;

/**
 *
 * @author Avell
 */
public class BuscaPecasAtacadasVisitor implements VisitorTime<List<Peca>> {

    private List<Peca> pecasAtacadas = new ArrayList<>();

    @Override
    public void visit(Peca peca) {
        for (Peca pecaMorta : peca.getPecasAtacadas()) {
            pecasAtacadas.add(pecaMorta);
        }
    }

    @Override
    public List<Peca> getValue() {
        return pecasAtacadas;
    }

}
