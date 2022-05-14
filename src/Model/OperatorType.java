package Model;

public enum OperatorType {
    PLUS,
    MINUS,
    TIMES,
    DIVIDED_BY,
    NOT_OP;

    public static OperatorType parseOperator(String str){
        switch(str.trim()){
            case "+" : return PLUS;
            case "-" : return MINUS;
            case "*" : return TIMES;
            case "/" : return DIVIDED_BY;
            default: return NOT_OP;
        }
    }
}
