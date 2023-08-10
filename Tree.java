import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Tree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.setUpTree("decision-tree-data.txt");

        List<String> nodeNames = Node.getAllNodeNames();
        List<String> destinationNodes = Edge.getAllDestinationNodes();

        String firstNode = findFirstNode(nodeNames, destinationNodes);

        String currentNode = firstNode;
        Scanner userInput = new Scanner(System.in);
        runTree(nodeNames, destinationNodes, currentNode, userInput);
    }

    public void setUpTree(String filename) {
        try {
            File decisionTree = new File(filename);
            Scanner treeScanner = new Scanner(decisionTree);
            while (treeScanner.hasNextLine()) {
                String treeData = treeScanner.nextLine();
                setEdgesOrNodes(treeData);
            }
            treeScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String[] splitTreeData(String treeData) {
        return treeData.split(",");
    }

    public void setEdgesOrNodes(String treeData) {
        String[] items = splitTreeData(treeData);
        if (items.length == 2) {
            Node.createNode(items[0], items[1]);
        } else if (items.length == 3) {
            Edge.createEdge(items[0], items[1], items[2]);
        }
    }

    public static String findFirstNode(List<String> nodeNames, List<String> destinationNodes) {
        for (String nodeName : nodeNames) {
            if (!destinationNodes.contains(nodeName)) {
                return nodeName;
            }
        }
        return null;
    }

    public static void runTree(List<String> nodeNames, List<String> destinationNodes, String currentNode, Scanner userInput) {
        String currentQuestionOrAnswer = Node.findQuestionOrAnswerByNodeName(currentNode);

        String jaOfNee;

        while (isNodeQuestion(currentQuestionOrAnswer)) {
            System.out.println("Vraag: " + currentQuestionOrAnswer + "\nAntwoord met Ja of Nee:");

            jaOfNee = userInput.nextLine();

            jaOfNee = repeatUntilValidAnswer(jaOfNee, userInput);

            currentNode = findNextNode(jaOfNee, currentNode, Edge.edgeList);
            currentQuestionOrAnswer = Node.findQuestionOrAnswerByNodeName(currentNode);
        }
        finalAnswer(currentQuestionOrAnswer);
    }

    public static boolean isNodeQuestion(String currentQuestionOrAnswer) {
        if (currentQuestionOrAnswer.charAt(currentQuestionOrAnswer.length() - 1) == '?') {
            return true;
        }
        return false;
    }

    public static boolean validAnswer(String jaOfNee) {
        if (jaOfNee.equalsIgnoreCase("Ja") || jaOfNee.equalsIgnoreCase("Nee")) {
            return true;
        }
        return false;
    }

    public static void invalidAnswer(String jaOfNee) {
        System.out.println("Ongeldig antwoord! Antwoord met Ja of Nee:");
    }

    public static String repeatUntilValidAnswer(String jaOfNee, Scanner userInput) {
        while (!validAnswer(jaOfNee)) {
            invalidAnswer(jaOfNee);
            jaOfNee = userInput.nextLine();
        }
        return jaOfNee;
    }

    public static String findNextNode(String jaOfNee, String currentNode, List<Edge> edgeList) {
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            if (edge.getOriginNode().equals(currentNode) && edge.getAnswer().equalsIgnoreCase(jaOfNee)) {
                return edge.getDestinationNode();
            }
        }
        return null;
    }

    public static void finalAnswer(String currentQuestionOrAnswer) {
        System.out.println("\nHet blad wat je zoekt is van een " + currentQuestionOrAnswer.toLowerCase() + "!");
    }
}
