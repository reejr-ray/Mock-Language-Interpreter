package interpreter.bytecode;

import java.io.IOException;
import java.util.ArrayList;
import interpreter.VirtualMachine;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReadCode extends ByteCode {
    // ------------ used types of the bytecode ------------------
    private String name;

    @Override
    public void init(ArrayList<String> arglist, String className){
        this.name  = className;
    }

    @Override
    public String getName(){ return this.name; }
    @Override
    public String getBranchName(){return "ERROR-CALLING-BRANCHNAME-OF-NON-BRANCH-BYTECODE";}
    @Override
    public void setLocation(int i){} //intentionally blank. see ByteCode.java for more info

    @Override
    public void execute(VirtualMachine vm){
       String str = "";
        try {
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           str = br.readLine();
           int i = Integer.parseInt(str);
           vm.pushRunStack(i);

       } catch (IOException ioe){
           System.out.println(" Error in input in ReadCode.java. ");
       } catch (NumberFormatException nfe){
           System.out.println(" Error: Cannot parse " + str + " as a number in ArgsCode.java. \n");
       }
    }
}
