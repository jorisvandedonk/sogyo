import java.util.ArrayList;
import java.util.List;

public final class Node {
    private final String nodeName;
    private final String questionOrAnswer;

    private static List<Node> nodeList = new ArrayList<>();

    public Node(String nodeName, String questionOrAnswer) {
        this.nodeName = nodeName;
        this.questionOrAnswer = questionOrAnswer;
        nodeList.add(this);
    }

    public static void createNode(String nodeName, String questionOrAnswer) {
        Node newNode = new Node(nodeName.trim(), questionOrAnswer.trim());
    }

    public static List<String> getAllNodeNames() {
        List<String> nodeNames = new ArrayList<>();
        for (Node node : nodeList) {
            nodeNames.add(node.nodeName);
        }
        return nodeNames;
    }

    public static String findQuestionOrAnswerByNodeName(String nodeName) {
        for (Node node : nodeList) {
            if (node.nodeName.equals(nodeName)) {
                return node.questionOrAnswer;
            }
        }
        return null;
    }
}
