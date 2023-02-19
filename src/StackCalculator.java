import java.util.Scanner;

public class StackCalculator {
    int storageAmount, stackNumber, leftOver;
    public void run() {
        int blockNoInput;
        String storageTypeInput;
        String userIsGivingInput = "y";     //only takes the value of y(yes/true) or n(no/false). Did this so
                                            //there wouldn't be 2 variables 1 for checking if the user is still giving
                                            //input and 1 for the answer of the user to the question

        while(userIsGivingInput.equals("y")) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Please type in the number of blocks and the type of storage you're gonna be using(options available: chest, shulker):");
            blockNoInput = scanner.nextInt();
            storageTypeInput = scanner.next();

            StorageType storageType = StorageTypeFactory.createStorageType(storageTypeInput);

            if(storageType != null) {
                countStacks(blockNoInput);
                countStorageBlocks(storageType.getStorageAmount());

                displayResults(storageType.getStorageName());

                System.out.println("Do you want another request?(y/n)");
                userIsGivingInput = scanner.next();
                userIsGivingInput = convertAnswer(userIsGivingInput);
            } else {
                System.out.println("Ivalid type of storage!!!");
            }
        }
    }

    private String convertAnswer(String answer) {
        if(answer.contains("1")) {
            answer = "y";
        } else if(answer.contains("0")) {
            answer = "n";
        } else {
            answer = answer.toLowerCase().substring(0, 1);
        }

        return answer;
    }

    private void countStacks(int blockInput) {
         this.stackNumber = 0;

        while(blockInput >= 64) {
            this.stackNumber++;
            blockInput -= 64;
        }

        this.leftOver = blockInput;
    }

    private void countStorageBlocks(int storageAmount) {
        this.storageAmount = 0;

        while(this.stackNumber >= storageAmount) {
            this.storageAmount++;
            this.stackNumber -= storageAmount;
        }
    }

    private void displayResults(String storageType) {
        System.out.println("The following input can be converted to:");

        if(this.storageAmount != 0) {
            System.out.print(this.storageAmount + " " + storageType + " ");
        }

        if(this.stackNumber != 0) {
            System.out.print(this.stackNumber + " stacks ");
        }

        if(this.leftOver != 0) {
            System.out.print(this.leftOver + " blocks left over");
        }
        System.out.println();
    }
}