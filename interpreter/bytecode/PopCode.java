package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class PopCode extends ByteCode {
    // ------------ used types of the bytecode ------------------
    private String name;
    private int levels;

    @Override
    public void init(ArrayList<String> arglist, String className){
        this.name  = className;
        this.levels = Integer.parseInt(arglist.get(0));
    }

    @Override
    public String getName(){ return this.name; }
    @Override
    public String getBranchName(){return "ERROR-CALLING-BRANCHNAME-OF-NON-BRANCH-BYTECODE";}
    @Override
    public void setLocation(int i){} //intentionally blank. see ByteCode.java for more info

    @Override
    public void execute(VirtualMachine vm){
        /**
         * REEEEEEEE
         */
    }
}
