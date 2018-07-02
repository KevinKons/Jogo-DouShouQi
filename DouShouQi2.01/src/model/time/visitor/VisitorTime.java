package model.time.visitor;

import model.Peca;

/**
 *
 * @author Avell
 */
public interface VisitorTime<T> {
    
    void visit(Peca peca);
    
    T getValue();
}
