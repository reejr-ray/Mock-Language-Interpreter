package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;
import java.util.HashMap;

public class BopCode extends ByteCode {
    // ------------ used types of the bytecode ------------------
    private String name;
    private String operator;

    /*
    private static HashMap<String, String> bopHash;

    public static void populateBopHash(){
        bopHash = new HashMap<>();
        bopHash.put
    }
    */

    @Override
    public void init(ArrayList<String> arglist, String className){
        this.name  = className;
        this.operator = arglist.get(0);
    }

    @Override
    public String getName(){ return this.name; }
    @Override
    public String getBranchName(){return "ERROR-CALLING-BRANCHNAME-OF-NON-BRANCH-BYTECODE";}
    @Override
    public void setLocation(int i){} //intentionally blank. see ByteCode.java for more info

    @Override
    public void execute(VirtualMachine vm){
        // 12 Binary Operators, so 12 if statements
        // otherwise, a static hashtable is needed.
        int rhs = vm.popRunStack(); // top-level
        int lhs = vm.popRunStack(); // second-level
        int result;
        boolean condition;
        // if its a regular number op:
        if(operator == "+" || operator == "-" || operator == "/" || operator == "*"){
            if(operator == "+"){
                result = lhs + rhs;
            } else if(operator == "-"){
                result = lhs - rhs;
            }else if(operator == "/"){
                result = lhs / rhs;
            } else {
                result = lhs * rhs;
            }
            vm.pushRunStack(result);
        }
        // if its a conditional:
        else if (operator == "==" || operator == "!=" || operator == "<=" || operator == ">" || operator == ">="
                || operator == "<" || operator == "|" || operator == "&"){
            if (operator == "==") {
                condition = (lhs == rhs);
            } else if (operator == "!=") {
                condition = (lhs != rhs);
            } else if (operator == "<=") {
                condition = (lhs <= rhs);
            } else if (operator == ">") {
                condition = (lhs > rhs);
            } else if (operator == ">=") {
                condition = (lhs >= rhs);
            } else if (operator == "<") {
                condition = (lhs < rhs);
            } else if (operator == "|") {
                condition = ((lhs > 0) || (rhs > 0));
            } else {
                condition = ((lhs > 0) && (rhs > 0));
            }
            int val = (condition) ? 1 : 0;
            vm.pushRunStack(val);
        }
    }
}
