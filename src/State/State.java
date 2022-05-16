package State;

public abstract class State {

    public static State operand, operator, calculate, current;



    public int read(String statement, int index){return index;}


    public void updateState(String statement, int index) {
        if (statement.substring(index).trim().equals("=")){
            current = calculate;
            return;
        }
        int nextSpace = findNextWhitespace(statement, index);
        if (nextSpace == -1) {
            current = calculate;
            return;
        }

        char charAtIndex = statement.charAt(index);
        if (charAtIndex == '-'){
            if (statement.charAt(index + 1) == ' '){
                current = operator;
            }else current = operand;
            return;
        }
        if (charAtIndex == '+' || charAtIndex == '-' || charAtIndex == '*' || charAtIndex == '/') current = operator;
        else if (statement.charAt(index) == '=') current = calculate;
        else current = operand;
        return;
    }

    int findNextWhitespace(String statement, int index) {
        for (int i = index; i < statement.length(); i++){
            if (statement.charAt(i) == ' ') return i;
        }
        return -1;
    }
}

