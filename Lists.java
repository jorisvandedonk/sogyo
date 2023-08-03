import java.util.Arrays;

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

for (int i: randomNumbers) {
    System.out.println(i + " ");  
        }
        
int largestNumber = randomNumbers[0];
    for (int i = 0; i < randomNumbers.length; i++) {
        if (randomNumbers[i] > largestNumber) {
            largestNumber = randomNumbers[i];
        }
        

    }
    
 System.out.println("The largest number is" + " " + largestNumber);  
 
  for (int number : randomNumbers) {
    if (number % 2 == 0) {
        System.out.println(number + " is an even number and can be divided by 2");
    }
}
    for (int number : randomNumbers) {
        if (number % 3 == 0) 
            System.out.println(number + " can be divided by 3");
        }
        
    for (int number : randomNumbers) {
        if (number % 5 == 0) 
            System.out.println(number + " can be divided by 5");
        }
        
    for (int number : randomNumbers) {
        if (number % 2 != 0 && number % 3 != 0 && number % 5 != 0) 
            System.out.println(number + " cannot be divided by 2, 3 or 5");
        }
    } 
}

