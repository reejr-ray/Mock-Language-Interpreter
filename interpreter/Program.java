package interpreter;

import interpreter.bytecode.ByteCode;
import java.util.ArrayList;

public class Program {

    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }

    public void addByteCode(ByteCode code){ this.program.add(code); }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs() {

        // scan through program and look for labels
        // take note of the location of the label
        // if the bytecode is a label, scan through program again and look for the same string that is "labeled"
        // anything that has an argument that is the same as what is "labeled", replace that string with the location of label
        if(!program.isEmpty()) {
            for (int i = 0; i <= program.size(); i++) {
                if (program.get(i).getName().equals("LABEL")) {

                    int location = i;
                    String label = program.get(i).getBranchName();
                    for (ByteCode code2 : program) {
                        String name2 = code2.getName(); // saves 2 getName() calls per iteration
                        if(name2.equals("FALSEBRANCH") ||
                                name2.equals("GOTO") ||
                                name2.equals("CALL") ||
                                name2.equals("RETURN")){
                            String label2 = code2.getBranchName();
                            if(label2 == label){
                                code2.setLocation(i);
                            }
                        }
                    }
                }
            }
        }
    }

}
