package controller.state;

import controller.Command.CommandInvoker;
import controller.Controller;

/**
 *
 * @author Avell
 */
public abstract class State {
    
    protected Controller controller;
    protected CommandInvoker ci = CommandInvoker.getInstance();

    public State(Controller controller) {
        this.controller = controller;
    }
    
    public abstract void proxEstado(int y, int x) throws Exception;
    
    
}
