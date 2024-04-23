
import java.util.*;
import java.util.stream.*;

public class Main {

  public static String ShortestPath(String[] strArr) {
    int n = Integer.parseInt(strArr[0]);
    String[] nodes = Arrays.copyOfRange(strArr, 1, n + 1);
    Map<String, List<String>> graph = buildGraph(strArr, n);

    Queue<String> queue = new LinkedList<>();
    Map<String, String> parent = new HashMap<>();
    Set<String> visited = new HashSet<>();

    queue.offer(nodes[0]);
    visited.add(nodes[0]);

    while (!queue.isEmpty()) {
      String node = queue.poll();
      List<String> neighbors = graph.getOrDefault(node, Collections.emptyList());

      neighbors.stream()
          .filter(neighbor -> !visited.contains(neighbor))
          .forEach(neighbor -> {
            queue.offer(neighbor);
            visited.add(neighbor);
            parent.put(neighbor, node);
          });
    }

    boolean hasNotVisited = !visited.contains(nodes[n - 1]);
    if (hasNotVisited) {
      return "-1";
    }

    StringBuilder pathBuilder = new StringBuilder();
    String current = nodes[n - 1];

    while (!current.equals(nodes[0])) {
      pathBuilder.insert(0, "-" + current);
      current = parent.get(current);
    }
    pathBuilder.insert(0, current);

    return pathBuilder.toString();
  }

  private static Map<String, List<String>> buildGraph(String[] strArr, int n) {
    return IntStream.range(n + 1, strArr.length)
        .mapToObj(i -> strArr[i].split("-"))
        .collect(Collectors.groupingBy(arr -> arr[0], Collectors.mapping(arr -> arr[1], Collectors.toList())));
  }

  public static void main(String[] args) {

    System.out.println(ShortestPath(new String[] { "5", "A", "B", "C", "D", "F", "A-B", "A-C", "B-C", "C-D", "D-F" }));

    System.out.println(ShortestPath(new String[] { "4", "X", "Y", "Z", "W", "X-Y", "Y-Z", "X-W" }));
  }

  
}
