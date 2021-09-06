import java.util.*;
class RandomizedQuickSort {
  private static int partition(int[] arr, int p, int r) {
    int x = arr[r];
    int i = p - 1;
    for(int j = p; j <= r - 1; j++) {
      if(arr[j] <= x) {
        i++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    int temp = arr[i + 1];
    arr[i + 1] = arr[r];
    arr[r] = temp;
    return i + 1;
  }
  private static int randomizedPartition(int[] arr, int p, int r) {
    int i = (int) Math.ceil(Math.random() * (r - p) + p);
    int temp = arr[r];
    arr[r] = arr[i];
    arr[i] = temp;
    return partition(arr, p, r);
  }
  private static void randomizedQuickSort(int[] arr, int p, int r) {
    if(p < r) {
      int q = randomizedPartition(arr, p, r);
      randomizedQuickSort(arr, p, q - 1);
      randomizedQuickSort(arr, q + 1, r);
    }
  }
  public static void main(String[] args) {
    int[] arr = new int[5];
    Scanner sc = new Scanner(System.in);
    for(int i = 0; i < 5; i++) {
      arr[i] = sc.nextInt();
    }
    randomizedQuickSort(arr, 0, arr.length - 1);
    for(int i : arr) {
      System.out.print(i + ", ");
    }
  }
}
