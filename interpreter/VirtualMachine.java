package interpreter;

import java.util.Stack;
import interpreter.bytecode.ByteCode;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram(){
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
        while(isRunning){
            ByteCode code = program.getCode(pc);
            code.execute(this);
            //runStack.dump(); // Used to dump runstack state.
            pc++;
        }
    }

    // ---------- RUNTIME STACK FUNCTIONS --------------------
    public void dumpRunStack(){runStack.dump();}
    public int peekRunStack(){ return runStack.peek();}
    public int popRunStack(){ return runStack.pop();}
    public void newFramePointer(int offset){runStack.newFrameAt(offset);}
    public void popFramePointer(){runStack.popFrame();}
    public int storeRunStack(int offset){ return runStack.store(offset);}
    public int loadRunStack(int offset){ return runStack.load(offset);}
    public int pushRunStack(int val){return runStack.push(val);}
    public int getRunStackSize(){return runStack.getStackSize();}
    // ----------- ENDOF RUNTIME STACK FUNCTIONS --------------

    // ------------ VIRTUAL MACHINE MANIPULATORS -------------
    public void endProgram(){isRunning = false;}
    public void pushReturnAddr(int addr){ returnAddrs.push(addr);}
    public int popReturnAddr(){
        if(!returnAddrs.isEmpty()) {
            return (int)returnAddrs.pop();
        } else
            return -1;
    }
    public int peekReturnAddr(){
        if(!returnAddrs.isEmpty()){
            return (int)returnAddrs.peek();
        } else {
            return -1;
        }
    }
    public boolean returnAddrIsEmpty(){
        return returnAddrs.isEmpty();
    }
    public int getCurrentLocation(){ return program.getSize();}
    public void changePc(int i){ this.pc = i;}
    // ------------- ENDOF VIRTUAL MACHINE MANIPULATORS ----------







}
