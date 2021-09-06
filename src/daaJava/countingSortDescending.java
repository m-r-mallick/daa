import java.util.*;
class countingSortDescending {
  private static void countingSort(int[] arr, int[] result, int k) {
    int[] temp = new int[k];
    for(int i = 0; i < k; i++) {
      temp[i] = 0;
    }
    for(int j = 0; j < arr.length; j++) {
      temp[arr[j]] = temp[arr[j]] + 1;
    }
    for(int i = k - 1; i > 0; i--) {
      temp[i - 1] = temp[i - 1] + temp[i];
    }
    for(int j = arr.length - 1; j >= 0; j--) {
      result[temp[arr[j]] - 1] = arr[j];
      temp[arr[j]] = temp[arr[j]] - 1;
    }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter no. of elements : ");
    int n = sc.nextInt();
    int[] arr = new int[n];
    int[] sorted = new int[n];
    System.out.println("Enter elements : ");
    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int max = arr[0];
    for(int i = 0; i < n; i++) {
      if(arr[i] >= max) {
        max = arr[i];
      }
    }
    System.out.println("Max Element : " + max);
    System.out.println("Sorted array : ");
    countingSort(arr, sorted, max + 1);
    for(int i : sorted) {
      System.out.print(i + ", ");
    }
  }
}
