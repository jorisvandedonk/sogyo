import java.util.ArrayList;
import java.util.List;

public final class Edge {
    private final String originNode;
    private final String destinationNode;
    private final String answer;
    
    private static List<Edge> edgeList = new ArrayList<>();

    public Edge(String originNode, String destinationNode, String answer) {
        this.originNode = originNode;
        this.destinationNode = destinationNode;
        this.answer = answer;
        edgeList.add(this);
    }

    public static void createEdge(String originNode, String destinationNode, String answer) {
        Edge newEdge = new Edge(originNode.trim(), destinationNode.trim(), answer.trim());
    }

    public static List<String> getAllDestinationNodes() {
        List<String> destinationNodes = new ArrayList<>();
        for (int i = 0; i < edgeList.size(); i++) {
            destinationNodes.add(edgeList.get(i).destinationNode);
        }
        return destinationNodes;
    }
}
