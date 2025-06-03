import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class NumberOfRecentCalls {

    public static void main(String[] args) {
        RecentCounter obj = new RecentCounter();
        int param_1 = obj.ping(1);
        int param_2 = obj.ping(100);
        int param_3 = obj.ping(3001);
        int param_4 = obj.ping(3002);
        var res = Stream.of(param_1, param_2, param_3, param_4)
                .map(Object::toString)
                .reduce("", (x, y) -> x + " " + y);
        System.out.println("Expected : 1 2 3 3");
        System.out.println("Actual : " + res);
    }

}

class RecentCounter {

    List<Integer> requests;

    public RecentCounter() {
        this.requests = new LinkedList<>();
    }

    public int ping(int t) {
        int counter = 0, lowerEnd = t - 3000;

        requests.add(t);
        var it = requests.reversed().iterator();
        while (it.hasNext() && it.next() >= lowerEnd) {
            counter++;
        }

        return counter;
    }
}