package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() { // constructor
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump(){}
    public int peek(){ return 0;}
    public void newFrameAt(int offset){}
    public void popFrame(){}
    public int store(int offset){return 0;}
    public int load(int offset){return 0;}
    public int push(int val){return 0;}


    
}