package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class LitCode extends ByteCode {
    // ------------ used types of the bytecode ------------------
    private String name;
    private int value;
    private String variable;

    @Override
    public void init(ArrayList<String> arglist, String className){
        this.name = className;
        String number = arglist.get(0);

        try {
            this.value = Integer.parseInt(number);
        } catch (NumberFormatException nfe){
            System.out.println(" Error: Cannot parse " + number + " as a number in LitCode.java. \n");
        }
        if(arglist.size() > 1){
            this.variable = arglist.get(1);
        } else {
            this.variable = "x";
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
        vm.pushRunStack(value);
    }
}
