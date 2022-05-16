package Model;

import java.util.ArrayList;
import java.util.List;

public class ElementStack {

    private static ElementStack stackInstance = null;

    private List<CalcElement> stack;


    private ElementStack(){
        stack = new ArrayList<>();
    }

    public static ElementStack getInstance(){
        if (stackInstance == null) stackInstance = new ElementStack();
        return stackInstance;
    }

    public void add(CalcElement element){
        stack.add(element);
    }

    public String calculate(){

        int maxPrec;
        int nextIndex;

        while(stack.size() > 1){
            maxPrec = getMaxPrec();
            nextIndex = nextIndex(maxPrec);
            operate(nextIndex);
        }
        String answer = ((Operand)stack.get(0)).getNumber().toString();
        if (answer.endsWith(".0")) answer = answer.substring(0, answer.length() - 2);
        stack.remove(0);
        return answer;


    }

    private int nextIndex(int maxPrec) {
        for (int i = 1; i < stack.size(); i += 2){
            if (((Operator)stack.get(i)).getPrecedence() == maxPrec){
                return i;
            }
        }
        return -1;
    }

    private void operate(int index) {
        switch (((Operator)stack.get(index)).getOpType()){
            case PLUS: plus(((Operand)stack.get(index - 1)).getNumber(), ((Operand)stack.get(index + 1)).getNumber(), index);
                break;
            case MINUS: minus(((Operand)stack.get(index - 1)).getNumber(), ((Operand)stack.get(index + 1)).getNumber(), index);
                break;
            case TIMES: times(((Operand)stack.get(index - 1)).getNumber(), ((Operand)stack.get(index + 1)).getNumber(), index);
                break;
            case DIVIDED_BY: dividedBy(((Operand)stack.get(index - 1)).getNumber(), ((Operand)stack.get(index + 1)).getNumber(), index);
                break;

        }


    }


    private void dividedBy(Double num1, Double num2, int index) {
        Double result = num1 / num2;
        stack.set(index, new Operand(result));
        stack.remove(index - 1);
        stack.remove(index);
    }

    private void times(Double num1, Double num2, int index) {
        Double result = num1 * num2;
        stack.set(index, new Operand(result));
        stack.remove(index - 1);
        stack.remove(index);
    }

    private void minus(Double num1, Double num2, int index) {
        Double result = num1 - num2;
        stack.set(index, new Operand(result));
        stack.remove(index - 1);
        stack.remove(index);
    }

    private void plus(Double num1, Double num2, int index) {
        Double result = num1 + num2;
        stack.set(index, new Operand(result));
        stack.remove(index - 1);
        stack.remove(index);
    }

    private int getMaxPrec(){
        int maxPrec = 0;
        for (int i = 0; i < stack.size(); i++){
            if (stack.get(i).getClass().equals(Operator.class)){
                int currPrec = ((Operator)stack.get(i)).getPrecedence();
                if (maxPrec < currPrec){
                    maxPrec = currPrec;
                }
            }
        }
        return maxPrec;
    }

    private int[] generateMap(int maxPrec){
        int[] map = new int[stack.size()/2];
        int count = 0;
        for (int i = maxPrec; i > 0; i--){
            for (int j = 1; j < stack.size(); j += 2){
                if (((Operator)stack.get(j)).getPrecedence() == i){
                    map[count++] = j;
                }
            }
        }
        return map;
    }

}
