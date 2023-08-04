public class Lists {
    public static void main(String[] args) {
        int[] randomNumbers = new int[10];
        randomNumbers[0] = (int) (Math.random() * 101);
        randomNumbers[1] = (int) (Math.random() * 101);
        randomNumbers[2] = (int) (Math.random() * 101);
        randomNumbers[3] = (int) (Math.random() * 101);
        randomNumbers[4] = (int) (Math.random() * 101);
        randomNumbers[5] = (int) (Math.random() * 101);
        randomNumbers[6] = (int) (Math.random() * 101);
        randomNumbers[7] = (int) (Math.random() * 101);
        randomNumbers[8] = (int) (Math.random() * 101);
        randomNumbers[9] = (int) (Math.random() * 101);

        printRandomArray(randomNumbers);
        
        int largestNumber = findLargestNumber(randomNumbers);
        System.out.println(largestNumber + " is the largest number");
        int[] twoSmallestNumbers = findTwoSmallestNumbers(randomNumbers);
        int sumSmallestNumbers = twoSmallestNumbers[0] + twoSmallestNumbers[1];
        System.out.println("The sum of the two smallest numbers is " + twoSmallestNumbers[0] + " + " + twoSmallestNumbers[1] + " = " + sumSmallestNumbers);
        for (int number : twoSmallestNumbers) {
            System.out.println(number);
        }
        
        printEvenNumbers(randomNumbers);
        printDivisibleByThree(randomNumbers);
        printDivisibleByFive(randomNumbers);
        printNotDivisibleByTwoThreeFive(randomNumbers);
        
        bubbleSort(randomNumbers);
        System.out.println("Sorted Array:");
        for (int i : randomNumbers) {
            System.out.println(i);
        }
    }

    public static void printRandomArray(int[] randomNumbers) {
        for (int i : randomNumbers) {
            System.out.println(i + " ");
        }
    }

    public static int findLargestNumber(int[] randomNumbers) {
        int largestNumber = randomNumbers[0];
        for (int i = 1; i < randomNumbers.length; i++) {
            if (randomNumbers[i] > largestNumber) {
                largestNumber = randomNumbers[i];
            }
        }
        return largestNumber;
    }

    public static int[] findTwoSmallestNumbers(int[] randomNumbers) {
        int[] twoSmallestNumbers = new int[2];
        int smallestNumber = Math.min(randomNumbers[0], randomNumbers[1]);
        int secondSmallestNumber = Math.max(randomNumbers[0], randomNumbers[1]);

        for (int i = 2; i < randomNumbers.length; i++) {
            int currentNumber = randomNumbers[i];

            if (currentNumber < smallestNumber) {
                secondSmallestNumber = smallestNumber;
                smallestNumber = currentNumber;
            } else if (currentNumber < secondSmallestNumber) {
                secondSmallestNumber = currentNumber;
            }
        }

        twoSmallestNumbers[0] = smallestNumber;
        twoSmallestNumbers[1] = secondSmallestNumber;

        return twoSmallestNumbers;
    }

    public static void printEvenNumbers(int[] randomNumbers) {
        for (int number : randomNumbers) {
            if (number % 2 == 0) {
                System.out.println(number + " can be divided by 2");
            }
        }
    }

    public static void printDivisibleByThree(int[] randomNumbers) {
        for (int number : randomNumbers) {
            if (number % 3 == 0) {
                System.out.println(number + " can be divided by 3");
            }
        }
    }

    public static void printDivisibleByFive(int[] randomNumbers) {
        for (int number : randomNumbers) {
            if (number % 5 == 0) {
                System.out.println(number + " can be divided by 5");
            }
        }
    }

    public static void printNotDivisibleByTwoThreeFive(int[] randomNumbers) {
        for (int number : randomNumbers) {
            if (number % 2 != 0 && number % 3 != 0 && number % 5 != 0) {
                System.out.println(number + " can not be divided by 2, 3, or 5");
            }
        }
    }

    public static void bubbleSort(int[] randomNumbers) {
        for (int i = 0; i < randomNumbers.length - 1; i++) {
            for (int j = 0; j < randomNumbers.length - i - 1; j++) {
                if (randomNumbers[j] > randomNumbers[j + 1]) {
                    int temp = randomNumbers[j];
                    randomNumbers[j] = randomNumbers[j + 1];
                    randomNumbers[j + 1] = temp;
                }
            }
        }
    }
}
