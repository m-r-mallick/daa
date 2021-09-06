import java.util.*;
class HireCandidate {
  private static Scanner sc = new Scanner(System.in);

  private static int[] copyArray(int[] arr) {
    int[] newArr = new int[arr.length];
    for(int i = 0; i < arr.length; i++) {
      newArr[i] = arr[i];
    }
    return newArr;
  }

  private static int[] getCandidates(int num) {
    int[] arr = new int[num];
    System.out.println("Enter Candidates : ");
    for(int i = 0; i < num; i++) {
      arr[i] = sc.nextInt();
    }
    return arr;
  }

  private static int rng(int range) {
    return (int) Math.ceil(Math.random() * range);
  }

  private static List<Integer> generateKeys(int num) {
    List<Integer> list = new ArrayList<>();
    while(list.size() < num) {
      int val = rng((int)Math.pow(num, 3));
      if(!list.contains(val)) {
        list.add(val);
      }
    }
    return list;
  }

  private static int[] randomizeArray(int[] arr, List<Integer> keys) {
    int len = arr.length;
    for(int i = 1; i < len; i++) {
      int key = keys.get(i);
      int temp = arr[i];
      int j = i - 1;
      while(j >= 0 && keys.get(j) > key) {
        arr[j + 1] = arr[j];
        keys.set(j + 1, keys.get(j));
        j--;
      }
      arr[j + 1] = temp;
      keys.set(j + 1, key);
    }
    return arr;
  }

  private static List<Integer> hireSequentially(int[] arr) {
    List<Integer> hired = new ArrayList<>();
    for(int i = 1; i < arr.length; i++) {
      int j = i - 1;
      if(j == 0) {
        hired.add(arr[j]);
      }
      if(arr[i] > arr[j]) {
        hired.add(arr[i]);
      }
    }
    return hired;
  }

  private static List<Integer> hireRandomly(int[] arr) {
    List<Integer> hired = new ArrayList<>();
    for(int i = 1; i < arr.length; i++) {
      int j = i - 1;
      if(j == 0) {
        hired.add(arr[j]);
      }
      if(arr[i] > arr[j]) {
        hired.add(arr[i]);
      }
    }
    return hired;
  }

  public static void main(String[] args) {
    System.out.println("inside main()...");
    System.out.print("Enter no. of candidates : ");
    int num = sc.nextInt();

    int[] candidates = getCandidates(num);
    List<Integer> keys = generateKeys(num);
    System.out.println("Keys (key  ∝  1/skills) : ");
    for(int i : keys) {
      System.out.println(i);
    }

    int[] copy = new int[candidates.length];
    copy = copyArray(candidates);
    int[] randomizedArray = randomizeArray(copy, keys);

    System.out.println("Candidates Array (skills ↑) : ");
    for(int i : randomizedArray) {
      System.out.println(i);
    }

    List<Integer> hiredSequentially = hireSequentially(candidates);
    List<Integer> hiredRandomly = hireRandomly(randomizedArray);

    System.out.println("No. of candidates hired (sequentially) : " + hiredSequentially.size());
    hiredSequentially.forEach(System.out::println);
    System.out.println("No. of candidates hired (randomly) : " + hiredRandomly.size());
    hiredRandomly.forEach(System.out::println);
  }
}
