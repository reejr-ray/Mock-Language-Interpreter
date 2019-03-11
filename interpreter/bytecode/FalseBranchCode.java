package interpreter.bytecode;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode {

    private String name;
    private String branchName;
    private int location;
    private ArrayList<String> arglist;

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
