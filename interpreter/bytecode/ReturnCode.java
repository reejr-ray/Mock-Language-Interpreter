package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class ReturnCode extends ByteCode {
    // ------------ used types of the bytecode ------------------
    private String name;
    private String branchName;
    private int location;

    @Override
    public void init(ArrayList<String> arglist, String className){
        this.name  = className;
        if(!arglist.isEmpty()){
            this.branchName = arglist.get(0);
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
        if(!vm.returnAddrIsEmpty()){
            int returnAddr = vm.popReturnAddr();
        }
    }
}
