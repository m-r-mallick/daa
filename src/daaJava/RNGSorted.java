import java.util.*;
class RNGSorted {
  private static void swap(int a, int b) {
    int temp;
    temp = a;
    a = b;
    b = temp;
  }
  private static int generateRandomNumber(int range) {
    return (int) Math.ceil(Math.random() * range);
  }
  public static void main(String[] args) {
    System.out.println("inside main...");
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Range : ");
    int range = sc.nextInt();
    int[] arr = new int[range];
    for(int i = 0; i < range; i++) {
      int num = generateRandomNumber((int)Math.pow(range, 3));
      arr[i] = num;
      if (i > 0) {
        int j = i - 1;
        while(j >= 0 && arr[j] > num) {
          int temp = arr[j];
          arr[j] = num;
          arr[j + 1] = temp;
          j--;
        }
      }
    }
    for(int i : arr) {
      System.out.println(i);
    }
  }
}
