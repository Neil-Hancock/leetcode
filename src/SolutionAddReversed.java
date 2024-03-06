import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class SolutionAddReversed {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger result = reverseListToLong(l1).add(reverseListToLong(l2));
        String s = String.valueOf(result);
        ListNode answer = new ListNode(s.charAt(s.length() - 1) - '0');
        if (s.length() > 1) {
            ListNode current = answer;
            for (int i = s.length()-2; i >= 0; i--) {
                ListNode next = new ListNode(s.charAt(i) - '0');
                current.next = next;
                current = next;
            }
        }
        return answer;
    }

    private BigInteger reverseListToLong(ListNode node) {
        List<Integer> list = new ArrayList<>();

        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        String s = list.stream()
                .map(Object::toString)
                .collect(Collectors.joining());

        return new BigInteger(new StringBuilder(s).reverse().toString());

    }

    public static void main (String[] args) {
        SolutionAddReversed solution = new SolutionAddReversed();
        solution.test();
    }

    public void test() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        addTwoNumbers(l1, l2);
        addTwoNumbers(l1, l2);
    }


    
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}