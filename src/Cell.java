public class Cell {
    private int value;
    private boolean isGiven;

    public Cell() {
        value = 0;
        isGiven = false;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isGiven() {
        return isGiven;
    }

    public void setGiven(boolean given) {
        isGiven = given;
    }
}
