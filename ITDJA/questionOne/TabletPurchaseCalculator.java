
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

/**
 *
 * @author simte
 */
public class TabletPurchaseCalculator {

    // variables, declare, initilise,
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###.##", new DecimalFormatSymbols(Locale.ENGLISH));
    private static final Scanner USER_INPUT = new Scanner(System.in);
    private static final double SMALL_PRICE = 5799.00;
    private static final double MEDIUM_PRICE = 7999.00;
    private static final double LARGE_PRICE = 10099.00;
    private static final double INTEREST_RATE = 85.4;
    private static final int NUMBER_OF_MONTHS = 24;
    private static String UserChoice = "";
    private static double MonthlyCredit = 0;
    private static double TotalCredit = 0;

    // constructor, default,
    public TabletPurchaseCalculator() {

    }

    // void, print menu,
    public void SetMenuPrinter() {
        System.out.println("""
                           \tSelect a Tablet
                           S - 64GB Tablet\t\tPrice: R""" + DECIMAL_FORMAT.format(SMALL_PRICE) + "\n"
                + "M - 128GB Tablet" + "\tPrice: R" + DECIMAL_FORMAT.format(MEDIUM_PRICE) + "\n"
                + "L - 256GB Tablet" + "\tPrice: R" + DECIMAL_FORMAT.format(LARGE_PRICE) + "\n"
                + "\n");

    }

    // method (mutator), capture & validate user input
    public void SetUserInput() {
        System.out.print("Enter your choice: ");
        UserChoice = USER_INPUT.next().toUpperCase();

        if (UserChoice.equals("S")) {
            SetCalculatedCredit(SMALL_PRICE);
            GetPaymentInformation();
        }
        if (UserChoice.equals("M")) {
            SetCalculatedCredit(MEDIUM_PRICE);
            GetPaymentInformation();
        }
        if (UserChoice.equals("L")) {
            SetCalculatedCredit(LARGE_PRICE);
            GetPaymentInformation();
        } else if (!UserChoice.equals("S")
                && !UserChoice.equals("M")
                && !UserChoice.equals("L")) {
            SetErrorMesagePrinter(UserChoice);
        }
    }

    // method (mutator), build & print error message
    public void SetErrorMesagePrinter(String UserChoice) {
        System.out.println("\nInvalid choice! Option '" + UserChoice + "' does not exist.");
    }

    // method (mutator), calculate credit payments
    public void SetCalculatedCredit(double ChosenPrice) {
        TotalCredit = ChosenPrice + (ChosenPrice * (INTEREST_RATE / 100));
        MonthlyCredit = TotalCredit / NUMBER_OF_MONTHS;
    }

    // method (accessor) build & print credit payment information
    public void GetPaymentInformation() {
        System.out.println("\nPay as little as: R" + DECIMAL_FORMAT.format(MonthlyCredit) + " pm x 24 months\n"
                + "========================================\n"
                + "\n"
                + "***Credit Price: R" + DECIMAL_FORMAT.format(TotalCredit));
    }
}
