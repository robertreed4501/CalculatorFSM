package Model;

import java.util.List;

public class Operand extends CalcElement{
    private Double number;
    private int precedence;

    public Double getNumber() {
        return number;
    }

    public Operand(Double number) {
        this.number = number;
        this.precedence = 0;
    }
}
