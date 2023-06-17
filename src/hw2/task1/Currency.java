package hw2.task1;

public enum Currency {

    USDtoUAH(37.45),
    EURtoUAH (40.48);

    private double value;
    public double getValue(){
        return this.value;
    }
    private Currency (double value){
        this.value = value;
    }

}
