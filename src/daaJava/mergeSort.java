import java.util.*;
class mergeSort {
  static void merge(int arr[], int m, int l, int u) {
    int L = m - l + 1;
    int U = u - m;
    int temp1[] = new int[L];
    int temp2[] = new int[U];

    for(int i = 0; i < L; i++) {
      temp1[i] = arr[l + i];
    }
    for(int j = 0; j < U; j++) {
      temp2[j] = arr[m + 1 + j];
    }

    int i = 0, j = 0;

    int k = l;

    while(i < L && j < U) {
      if(temp1[i] <= temp2[j]) {
        arr[k] = temp1[i];
        i++;
      } else {
        arr[k] = temp2[j];
        j++;
      }
      k++;
    }

    while(i < L) {
      arr[k] = temp1[i];
      i++;
      k++;
    }
    while(j < U) {
      arr[k] = temp2[j];
      j++;
      k++;
    }
  }
  static int[] sort(int arr[], int l, int r) {
    if(l < r) {
      int m = l + (r - l)/2;

      sort(arr, l, m);
      sort(arr, m + 1, r);

      merge(arr, m, l, r);
    }
    return arr;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter array length : ");
    int len = sc.nextInt();
    if(len > 0 && len < 1000) {
      int arr[] = new int[len];
      System.out.println("Enter elements : ");
      for(int i = 0; i < len; i++) {
         arr[i] = sc.nextInt();
      }
      int sorted[] = sort(arr, 0, len - 1);
      System.out.print("Sorted array : ");
      for(int i : sorted) {
        System.out.print(i + " ");
      }
   } else {
      System.out.println("No. should be in range 0-1000");
   }
 }
}

