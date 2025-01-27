public class Main {
    public static void main(String[] args) {
        BonusService bonusService = new BonusService();

        //shouldCalculateForRegisteredAndOverLimit
        long expected = 500;
        long actual = bonusService.calculate(1_000_000, true);
        System.out.println("1. " + expected + " == ? == " + actual);

        //shouldCalculateForRegisteredAndUnderLimit
        expected = 30;
        actual = bonusService.calculate(1_000, true);
        System.out.println("2. " + expected + " == ? == " + actual);
    }
}