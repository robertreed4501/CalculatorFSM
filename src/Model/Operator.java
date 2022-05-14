package Model;

public class Operator extends CalcElement{
    public OperatorType opType;
    public int precedence;

    public OperatorType getOpType() {
        return opType;
    }

    public int getPrecedence() {
        return precedence;
    }

    public Operator (OperatorType operator){
        this.opType = operator;
        switch(operator){
            case PLUS:
            case MINUS:
                precedence = 1;
                break;
            case TIMES:
            case DIVIDED_BY:
                precedence = 2;
                break;
            case NOT_OP: precedence = -1;
                break;
        }


    }
}

