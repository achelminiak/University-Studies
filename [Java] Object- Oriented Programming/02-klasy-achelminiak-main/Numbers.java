public class Numbers {
    private int num1;
    private int num2;
    private int num3;

    public Numbers(int num1, int num2, int num3) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }

    public int sum() {
        return num1 + num2 + num3;
    }

    public double average() {
        return sum() / 3.0;
    }

    public int min() {
        return Math.min(Math.min(num1, num2), num3);
    }

    public int max() {
        return Math.max(Math.max(num1, num2), num3);
    }

    public double geometric() {
        return Math.pow(num1 * num2 * num3, 1.0 / 3.0);
    }
}
