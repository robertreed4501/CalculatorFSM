import Model.ElementStack;
import State.CalculateState;
import State.OperandState;
import State.OperatorState;
import State.State;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        State.operand = new OperandState();
        State.operator = new OperatorState();
        State.calculate = new CalculateState();
        State.current = State.operand;

        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a mathematical expression in the form of \"1 + 2 =\"");
            String statement = scanner.nextLine();
            int index = 0;
            while (State.current != State.calculate){
                index = State.current.read(statement, index);
                State.current.updateState(statement, index);
            }

            String answer = ElementStack.getInstance().calculate();

            System.out.println(statement + " " + answer);


            System.out.print("\nEnter 1 for Yes\nEnter 2 for No\nWould you like to enter another expression? ");
            switch(scanner.nextLine().trim()){
                case "1" : break;
                case "2" : return;
                default:
                    System.out.println("Invalid Entry");
            }
            State.current = State.operand;




        }

    }
}
