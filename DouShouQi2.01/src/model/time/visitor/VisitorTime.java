package model.time.visitor;

import model.Peca;

/**
 *
 * @author Avell
 */
public interface VisitorTime {
    
    void visit(Peca peca);
    
    Object getValue();
}
