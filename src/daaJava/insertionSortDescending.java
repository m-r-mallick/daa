import java.util.*;
class insertionSortDescending {
  static int[] sort(int arr[]) {
    int len = arr.length;
    for(int i = 1; i < len; i++) {
      int key = arr[i];
      int j = i - 1;
      while(j >= 0 && arr[j] < key) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
    return arr;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter array length : ");
    int n = sc.nextInt();
    if(n <= 1000) {
      int arr[] = new int[n];
      System.out.print("Enter array elements : ");
      for(int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int sorted[] = sort(arr);
      System.out.println("Sorted array (DESCENDING) : ");
      for(int i : sorted) {
        System.out.print(i + " ");
      }
    } else {
      System.out.println("No. must be in the 0-1000 range!");
    }
  }
}
