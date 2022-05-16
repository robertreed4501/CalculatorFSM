package Model;

public class Operand extends CalcElement{
    private Double number;

    public Double getNumber() {
        return number;
    }

    public Operand(Double number) {
        this.number = number;
    }
}
