
package interpreter;

import interpreter.bytecode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        Program program = new Program();
        try {

            String line = byteSource.readLine();
            while (line != null) { // until EOF
                String[] args = line.split("\\s+");
                try {

                    String className = CodeTable.getClassName(args[0]);
                    Class c = Class.forName("interpreter.bytecode." + className);
                    ByteCode bCode = (ByteCode) c.getDeclaredConstructor().newInstance();

                    // create arraylist of remaining arguments
                    ArrayList<String> arglist = new ArrayList<>();
                    for(int i = 1; i < args.length; i++){
                        arglist.add(args[i]);
                    }

                    // initialize the bytecode with the arguments
                    String bCodeName = args[0];
                    bCode.init(arglist, bCodeName);

                    // add initialized bytecode into the program
                    program.addByteCode(bCode);

                } catch (ClassNotFoundException cnf) {
                    System.out.println(" No such class exists for code " + args[0] + ". ");
                } catch (NoSuchMethodException nsm) {
                    System.out.println(" No such method exception. error at " + args[0] + ". ");
                } catch (InstantiationException ins) {
                     System.out.println(" Exception generated at instantiation of bytecode " + args[0] + ". ");
                } catch (IllegalAccessException iacess){
                    System.out.println(" Illegal access when creating bytecode " + args[0] + ". ");
                } catch (InvocationTargetException invtarg) {
                    System.out.println("Invocation Target invalid at bytecode " + args[0] + ". ");
                }
                // keeps while loop running until no more lines are able to be read
                line = byteSource.readLine();
            }

        } catch (IOException ie) {
            ie.printStackTrace();
        }

        program.resolveAddrs();
        return program; // remove once loadcodes is programmed
    }
}
