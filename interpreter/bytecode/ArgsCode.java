package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class ArgsCode extends ByteCode {

    // ------------ used types of the bytecode ------------------
    private String name;
    private int numArgs;



    @Override
    public void init(ArrayList<String> arglist, String className){
        this.name  = className;
        String number = arglist.get(0);
        try {
            this.numArgs = Integer.parseInt(number);
        } catch (NumberFormatException nfe){
            System.out.println(" Error: Cannot parse " + number + " as a number in ArgsCode.java. \n");
        }

    }

    @Override
    public String getName(){ return this.name; }
    @Override
    public String getBranchName(){return "ERROR-CALLING-BRANCHNAME-OF-NON-BRANCH-BYTECODE";}
    @Override
    public void setLocation(int i){} //intentionally blank. see ByteCode.java for more info

    @Override
    public void execute(VirtualMachine vm){
        vm.newFramePointer(numArgs);
    }
}
