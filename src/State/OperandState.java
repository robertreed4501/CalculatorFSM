package State;

import Model.ElementStack;
import Model.Operand;


public class OperandState extends State{



    @Override
    public int read(String statement, int index) {
        int nextSpace = findNextWhitespace(statement, index);
        String number = statement.substring(index, nextSpace).trim();

        ElementStack.getInstance().add(new Operand(Double.parseDouble(number)));
        return nextSpace + 1;
    }




}
