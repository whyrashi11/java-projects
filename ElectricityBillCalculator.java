import java.util.Scanner;

public class ElectricityBillCalculator{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of electricity units consumed: ");
        String unitsStr = scanner.nextLine();

        
        int units = Integer.parseInt(unitsStr);
        double bill = 0.0;

        // Calculate bill according to slabs
        if (units <= 100) {
            bill = units * 5.0;
        } else if (units <= 200) {
            bill = (100 * 5.0) + ((units - 100) * 7.0);
        } else if (units <= 300) {
            bill = (100 * 5.0) + (100 * 7.0) + ((units - 200) * 10.0);
        } else {
            bill = (100 * 5.0) + (100 * 7.0) + (100 * 10.0) + ((units - 300) * 15.0);
        }

        
        double surcharge = bill * 0.125; 
        double finalBill = bill + surcharge;

        // Display Output
        System.out.println("\n========== ELECTRICITY BILL ==========");
        System.out.println("Units       : " + units);
        System.out.println("Bill Amount : " + bill);
        System.out.println("Surcharge   : " + surcharge);
        System.out.println("Final Bill  : " + finalBill);
        System.out.println("======================================");

        scanner.close();
    }
}