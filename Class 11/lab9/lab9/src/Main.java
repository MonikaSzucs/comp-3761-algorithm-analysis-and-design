public class Main {
    public static void main(String[] args) {

        DynamicFibonacci dynamicFibonacci = new DynamicFibonacci();
        // Test cases
        System.out.println("fibo(3) = " + dynamicFibonacci.fibo(3)); // Output: 2
        System.out.println("fibo(7) = " + dynamicFibonacci.fibo(7)); // Output: 13
        System.out.println("fibo(5) = " + dynamicFibonacci.fibo(5)); // Output: 5
    }
}