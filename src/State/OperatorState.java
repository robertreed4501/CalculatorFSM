package State;

import Model.ElementStack;
import Model.Operator;
import Model.OperatorType;

public class OperatorState extends State{

    @Override
    public int read(String statement, int index) {
        int nextSpace = findNextWhitespace(statement, index);
        String nextSegment = statement.substring(index, nextSpace);
        ElementStack.getInstance().add(new Operator(OperatorType.parseOperator(nextSegment)));
        return nextSpace + 1;
    }


}
