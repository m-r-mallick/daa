import java.util.*;
class NonRedundantRNG {
  private static int generateRandomNumber(int range) {
    return (int) Math.ceil(Math.random() * range);
  }
  private static boolean isPresentInList(List<Integer> list, int num) {
    boolean available = false;
    for(int i = 0; i < list.size(); i++) {
      int element = list.get(i);
      if(element == num) {
        available = true;
        return available;
      }
    }
    return available;
  }
  public static void main(String[] args) {
    System.out.println("Inside main()...");
    List<Integer> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Range : ");
    int range = sc.nextInt();
    while(list.size() < range) {
      int num = generateRandomNumber((int)Math.pow(range, 3));
      if(!isPresentInList(list, num)) {
        list.add(num);
      }
    }
    System.out.println("List size = " + list.size());
    Collections.sort(list);
    list.forEach(System.out::println);
  }
}
