
class Solution {

    private Node head;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public void removeDuplicates() {
        Node current = head;

        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (current.value == runner.next.value) {
                    runner.next = runner.next.next;
                } else {

                    runner = runner.next;
                }

            }

            current = current.next;
        }

    }

}
