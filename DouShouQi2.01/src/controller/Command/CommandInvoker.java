package controller.Command;

import controller.Controller;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import model.Peca;

/**
 *
 * @author Avell
 */
public class CommandInvoker {
    
    public static CommandInvoker getInstance() {
        if(instance == null) {
            instance = new CommandInvoker();
        }
        
        return instance;
    }
    
    private static CommandInvoker instance;

    private Map<Integer, Class<? extends Command>> comandos = new HashMap<>();

    private CommandInvoker() {
        comandos.put(1, Movimentar.class);
        comandos.put(2, SelecionarPeca.class);
        comandos.put(3, Atacar.class);
    }
    
    public void execute(int y, int x, int op, Object peca) throws Exception {
           Class<? extends Command> commClass = comandos.get(op);
           Constructor <? extends Command> constructor = null;
           Constructor<? extends Command>[] consts = (Constructor<? extends Command>[]) commClass.getConstructors();
            for (Constructor<? extends Command> cons:consts) {
                if (cons.getParameterCount() == 1) {
                    if (cons.getParameterTypes()[0].isAssignableFrom(peca.getClass())) {
                        constructor = cons;
                        break;
                    }
                }
            }
            
            Command comm;
            comm = (Command) constructor.newInstance(peca);
            
            comm.execute(y, x);
            
     }
}
