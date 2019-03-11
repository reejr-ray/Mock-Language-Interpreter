package interpreter.bytecode;
import java.util.ArrayList;
import interpreter.VirtualMachine;

public abstract class ByteCode {

    // method used to grab the arglist and change it
    public abstract String getName();
    public abstract String getBranchName();

    /**
     * this abstract function is only used by:
     * FALSEBRANCH, GOTO, CALL
     * all other implementations will be intentionally left blank.
     * @param i location of a branch in program ArrayList
     */
    public abstract void setLocation(int i);

    public abstract void init(ArrayList<String> arglist, String className);
    public abstract void execute(VirtualMachine vm);
}
