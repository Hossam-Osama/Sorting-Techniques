import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            System.out.println("Please provide the path of the input file.");
            Scanner input=new Scanner(System.in);
            String filePath =input.nextLine();
            SortArray sortArray = new SortArray(filePath);

            // Main menu
            while (true) {
                System.out.println("\n--- Sorting Algorithms Menu ---");
                System.out.println("1. Simple Sort (O(n^2))");
                System.out.println("2. Efficient Sort (O(n log n))");
                System.out.println("3. Non-Comparison Sort (O(n))");
                System.out.println("4. Exit");
                System.out.flush();

                System.out.println("Enter your choice: ");

                int choice = 0;
                while (true) {
                    try {
                        choice = Integer.parseInt(input.nextLine());
                        if (choice >= 1 && choice <= 4) {
                            break;
                        } else {
                            System.out.println("Invalid choice. Please enter a valid option.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid choice (1-4).");
                    }
                }
                int[] sortedArray;
                switch (choice) {
                    case 1:
                        int choice2=0;
                        while(choice2!=1||choice2!=2||choice2!=3){
                            System.out.println("1. Final sorted array");
                            System.out.println("2. intermediate arrays");
                            System.out.println("3. Both");
                            System.out.println("4. Exit");
                            while (true) {
                                try {
                                    choice2 = Integer.parseInt(input.nextLine());
                                    if (choice2 >= 1 && choice2 <= 4) {
                                        break;
                                    } else {
                                        System.out.println("Invalid choice. Please enter a valid option (1-4).");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input. Please enter a valid choice (1-4).");
                                }
                            }
                            switch (choice2) {
                                case 1:
                                    sortedArray = sortArray.simpleSort(1);
                                    sortArray.printArray(sortedArray);
                                    break;

                                case 2:
                                    sortedArray = sortArray.simpleSort(2);
                                    break;
                                case 3:
                                    sortedArray = sortArray.simpleSort(3);
                                    sortArray.printArray(sortedArray);
                                    break;
                                case 4:
                                    return;
                                default:
                                    System.out.println("Invalid choice. Please enter a valid option.");
                            }
                        }
                    case 2:


                        int choice3=0;
                        while(choice3!=1||choice3!=2||choice3!=3){
                            System.out.println("1. Final sorted array");
                            System.out.println("2. intermediate arrays");
                            System.out.println("3. Both");
                            while (true) {
                                try {
                                    choice3 = Integer.parseInt(input.nextLine());
                                    if (choice3 >= 1 && choice3 <= 4) {
                                        break;
                                    } else {
                                        System.out.println("Invalid choice. Please enter a valid option (1-4).");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input. Please enter a valid choice (1-4).");
                                }
                            }
                            switch (choice3) {
                                case 1:
                                    sortedArray = sortArray.efficientSort(1);
                                    sortArray.printArray(sortedArray);
                                    break;

                                case 2:
                                    sortedArray = sortArray.efficientSort(2);
                                    sortArray.printArray(sortedArray);
                                    break;
                                case 3:
                                    sortedArray = sortArray.efficientSort(3);
                                    sortArray.printArray(sortedArray);
                                    break;
                                case 4:
                                    return;
                                default:
                                    System.out.println("Invalid choice. Please enter a valid option.");
                            }
                        }

                    case 3:
                        int choice4=0;
                        while(choice4!=1||choice4!=2||choice4!=3){
                            System.out.println("1. Final sorted array");
                            System.out.println("2. intermediate arrays");
                            System.out.println("3. Both");
                            while (true) {
                                try {
                                    choice4 = Integer.parseInt(input.nextLine());
                                    if (choice4 >= 1 && choice4 <= 4) {
                                        break;
                                    } else {
                                        System.out.println("Invalid choice. Please enter a valid option (1-4).");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input. Please enter a valid choice (1-4).");
                                }
                            }
                            switch (choice4) {
                                case 1:
                                    sortedArray = sortArray.nonComparisonSort(1);
                                    sortArray.printArray(sortedArray);
                                    break;

                                case 2:
                                    sortedArray = sortArray.nonComparisonSort(2);
                                    break;
                                case 3:
                                    sortedArray = sortArray.nonComparisonSort(3);
                                    sortArray.printArray(sortedArray);
                                    break;
                                case 4:
                                    return;
                                default:
                                    System.out.println("Invalid choice. Please enter a valid option.");
                            }
                        }
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        }
}