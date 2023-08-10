import java.util.ArrayList;
import java.util.List;

public final class Edge {
    private final String originNode;
    private final String destinationNode;
    private final String answer;
    
    public static List<Edge> edgeList = new ArrayList<>();

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
        for (Edge edge : edgeList) {
            destinationNodes.add(edge.destinationNode);
        }
        return destinationNodes;
    }

    public static List<String> getAllOriginNodes() {
        List<String> originNodes = new ArrayList<>();
        for (Edge edge : edgeList) {
            originNodes.add(edge.originNode);
        }
        return originNodes;
    }

    public String getDestinationNode() {
        return destinationNode;
    }

    public String getAnswer() {
        return answer;
    }

    public String getOriginNode() {
        return originNode;
    }
}
