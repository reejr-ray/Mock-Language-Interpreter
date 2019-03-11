package interpreter.bytecode;

import java.util.ArrayList;

public class LoadCode extends ByteCode {
    // ------------ used types of the bytecode ------------------
    private String name;


    // ------------- LOG OF ARGS -----------------------
    // keeping a log of args allows for generalized code, even if each init function stores the correct values in their
    // correct types as seen above. Might be null if bytecode doesnt take arguments. easy checking for labels.
    private ArrayList<String> arglist;

    @Override
    public void init(ArrayList<String> arglist, String className){
        this.name  = className;
        this.arglist.addAll(arglist);
    }

    @Override
    public String getName(){ return this.name; }
    @Override
    public String getBranchName(){return "ERROR-CALLING-BRANCHNAME-OF-NON-BRANCH-BYTECODE";}
    @Override
    public void setLocation(int i){} //intentionally blank. see ByteCode.java for more info

    @Override
    public ArrayList<String> getArgs(){ return this.arglist; }
    @Override
    public void setArgs(ArrayList<String> myList){
        // is this a problem? shallow copy or works fine?
        this.arglist = myList;
    }

    @Override
    public void execute(){
        /**
         * REEEEEEEE
         */
    }
}
