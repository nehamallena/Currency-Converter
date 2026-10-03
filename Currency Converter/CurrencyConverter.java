import java.util.Scanner;

public class CurrencyConverter {

    // Exchange rates with respect to USD
    static double getRate(String currency) {
        switch (currency.toUpperCase()) {
            case "INR":
                return 1.0;
            case "USD":
                return 0.010;
            case "EUR":
                return 0.009;
            case "GBP":
                return 0.008;
            case "LKR":
                return 3.434;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("       CURRENCY CONVERTER");
        System.out.println("=================================");

        System.out.println("Supported currencies:");
        System.out.println("INR - Indian Rupee");
        System.out.println("USD - US Dollar");
        System.out.println("EUR - Euro");
        System.out.println("GBP - British Pound");
        System.out.println("LKR - Sri Lankan Rupee");

        System.out.print("\nEnter amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter source currency: ");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("Enter target currency: ");
        String toCurrency = scanner.next().toUpperCase();

        double fromRate = getRate(fromCurrency);
        double toRate = getRate(toCurrency);

        if (fromRate == -1 || toRate == -1) {
            System.out.println("Invalid currency!");
        } else {

            // Convert source currency to USD first,
            // then USD to target currency.
            double amountInUSD = amount / fromRate;
            double convertedAmount = amountInUSD * toRate;

            System.out.println("\n---------- RESULT ----------");
            System.out.printf("%.2f %s = %.2f %s%n",
                    amount,
                    fromCurrency,
                    convertedAmount,
                    toCurrency);
        }

        scanner.close();
    }
}