import java.util.*;
class sortingPhoneNo {
  private static long getMax(long[] arr) {
    long max = arr[0];
    for(int i = 0; i < arr.length; i++) {
      if(arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }
  private static void countingSort(long[] arr, long[] sorted, int divisor) {
    int[] temp = new int[10];
    for(int i = 0; i < 10; i++) {
      temp[i] = 0;
    }
    for(int i = 0; i < arr.length; i++) {
      temp[(int)(arr[i] / divisor) % 10]++;
    }
    for(int i = 1; i < 10; i++) {
      temp[i] = temp[i] + temp[i - 1];
    }
    for(int i = arr.length - 1; i >= 0; i--) {
      sorted[temp[(int)(arr[i] / divisor) % 10] - 1] = arr[i];
      temp[(int)(arr[i] / divisor) % 10]--;
    }
  }
  private static void radixSort(long arr[], long sorted[]) {
    long max = getMax(arr);

    for(int divisor = 1; max / divisor > 0; max = max * 10) {
      countingSort(arr, sorted, divisor);
    }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter no. of elements : ");
    int n = sc.nextInt();
    long[] arr = new long[n];
    long[] sorted = new long[n];
    System.out.println("Enter elements : ");
    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    radixSort(arr, sorted);
    for(long i : sorted) {
      System.out.print(i + ", ");
    }
  }
}
