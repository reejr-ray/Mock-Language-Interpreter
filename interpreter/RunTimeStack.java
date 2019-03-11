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

    public void dump(){} // TODO
    public int peek(){
        if(!runTimeStack.isEmpty())
            return runTimeStack.get(runTimeStack.size() - 1);
        else
            return -1;

    }
    public int pop(){
        if(!runTimeStack.isEmpty()) {
            int index = runTimeStack.size() - 1;
            int top = runTimeStack.get(index);
            runTimeStack.remove(index);
            return top;
        } else {
            return -1;
        }
    }

    public void newFrameAt(int offset){
        int index = ((runTimeStack.size() - 1) - offset);
        framePointer.add(index);
    }

    public void popFrame(){
        if(!framePointer.isEmpty() && framePointer.peek() != 0) {
            // store top of RTS
            int topRTS = peek();
            int currentFPS = framePointer.pop();
            int nextFPS = framePointer.peek();

            // pop all of RTS up until next FP
            while (currentFPS < nextFPS){
                pop();
                currentFPS -= 1;
            }
            push(topRTS);
            // add stored value onto RTS
        } else if(framePointer.peek() == 0){ // if its the last frame, return
            int topRTS = peek();
            while(!runTimeStack.isEmpty()){
                pop();
            }
            push(topRTS);
        }
    }

    public int store(int offset){
        int result = pop();
        if(!framePointer.isEmpty()) {
            int index = framePointer.peek() + offset;
            runTimeStack.set(index, result);
            return result;
        } else
            return -1;
    }

    public int load(int offset){
        if(!framePointer.isEmpty()){
            int index = framePointer.peek() + offset;
            int var = runTimeStack.get(index);
            return push(var);
        } else {
            return -1;
        }
    }
    public int push(int val){
        runTimeStack.add(val);
        return val;
    }
    public int getStackSize(){
        return runTimeStack.size();
    }


    
}