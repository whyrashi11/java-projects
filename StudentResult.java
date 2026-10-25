import java.util.*;

public class Student {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // 1. Basic Student Info
        System.out.print("Enter the student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the Roll Number: ");
        String rollNumber = scanner.nextLine();

        // 2. Dynamic number of subjects and single maximum marks prompt
        System.out.print("Enter the total number of subjects: ");
        int numSubjects = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter the maximum marks for each subject: ");
        int maxMarksPerSubject = Integer.parseInt(scanner.nextLine());

        String[] subjectNames = new String[numSubjects];
        int[] subjectMarks = new int[numSubjects];
        int total = 0;

        // 3. Input subject names and marks with validation loop
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("\nEnter the name of Subject " + (i + 1) + ": ");
            subjectNames[i] = scanner.nextLine();

            while (true) {
                System.out.print("Enter marks for " + subjectNames[i] + " (Max " + maxMarksPerSubject + "): ");
                String marksStr = scanner.nextLine();
                int marks = Integer.parseInt(marksStr);

                // Validation check against the single max marks limit
                if (marks >= 0 && marks <= maxMarksPerSubject) {
                    subjectMarks[i] = marks;
                    total += marks;
                    break;
                } else {
                    System.out.println("❌ Invalid marks! Maximum marks is " + maxMarksPerSubject + " and minimum is 0. Please enter again.");
                }
            }
        }

        // Calculations
        double average = (double) total / numSubjects;
        int maxTotalMarks = numSubjects * maxMarksPerSubject;

        // 4. Display Final Report Card Base
        System.out.println("\n=================== RESULT ===================");
        System.out.println("Name of Student       : " + name);
        System.out.println("Roll of Student       : " + rollNumber);
        System.out.println("Total Marks Obtained  : " + total + " / " + maxTotalMarks);
        System.out.println("Average Marks         : " + average);

        // 5. Conditional Comparison Prompt
        System.out.print("\nDo you want to compare any two subjects? (y/n): ");
        String compareChoice = scanner.nextLine().trim();

        if (compareChoice.equalsIgnoreCase("y")) {
            System.out.println("\n--- Select Subjects to Compare ---");
            for (int i = 0; i < numSubjects; i++) {
                System.out.println((i + 1) + ". " + subjectNames[i]);
            }

            System.out.print("Enter the number of the 1st subject to compare: ");
            int sub1Index = Integer.parseInt(scanner.nextLine()) - 1;

            System.out.print("Enter the number of the 2nd subject to compare: ");
            int sub2Index = Integer.parseInt(scanner.nextLine()) - 1;

            // Using Integer.compare() as required
            int comparison = Integer.compare(subjectMarks[sub1Index], subjectMarks[sub2Index]);

            System.out.print("\nComparison (" + subjectNames[sub1Index] + " vs " + subjectNames[sub2Index] + ") : ");
            if (comparison > 0) {
                System.out.println(subjectNames[sub1Index] + " is higher than " + subjectNames[sub2Index]);
            } else if (comparison < 0) {
                System.out.println(subjectNames[sub1Index] + " is lower than " + subjectNames[sub2Index]);
            } else {
                System.out.println("Both subjects have equal marks.");
            }
            System.out.println("Integer.compare() result: " + comparison);
        } else {
            System.out.println("\nComparison skipped by user.");
        }
        
        System.out.println("==============================================");

        scanner.close();
    }
}