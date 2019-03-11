package interpreter.bytecode;
import java.util.ArrayList;

public abstract class ByteCode {

    // method used to grab the arglist and change it
    public abstract String getName();
    public abstract String getBranchName();
    public abstract ArrayList<String> getArgs();

    /**
     * this class will only be used to re-set the arglist of the bytecode after changes
     * since resolveaddrs() only changes the arglist, no re-adding of bytecodes into program needs to occur
     */
    public abstract void setArgs(ArrayList<String> myList);

    /**
     * this abstract function is only used by:
     * FALSEBRANCH, GOTO, CALL
     * all other implementations will be intentionally left blank.
     * @param i location of a branch in program ArrayList
     */
    public abstract void setLocation(int i);

    public abstract void init(ArrayList<String> arglist, String className);
    public abstract void execute();
}
