package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class GotoCode extends ByteCode {

    private String name;
    private String branchName;
    private int location;

    @Override
    public void init(ArrayList<String> arglist, String className){
        this.name  = className;
        this.branchName = arglist.get(0);
    }

    @Override
    public String getName(){return this.name;}
    @Override
    public String getBranchName(){ return this.branchName; }
    @Override
    public void setLocation(int i){ this.location = i; }

    @Override
    public void execute(VirtualMachine vm){
        vm.changePc(location);
    }
}
