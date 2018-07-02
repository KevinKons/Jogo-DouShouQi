package model.time.strategy;

import model.time.Time;

/**
 *
 * @author Avell
 */
public interface StrategyTime<T> {
    
    public T calcular(Time time);
    
}
