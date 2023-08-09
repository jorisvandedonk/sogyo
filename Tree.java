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
        while (currentQuestionOrAnswer.charAt(currentQuestionOrAnswer.length() - 1) == '?') {
            System.out.println("Vraag: " + currentQuestionOrAnswer + "\nAntwoord met Ja of Nee:");
            String jaOfNee = userInput.nextLine();
            //while (!validAnswer(jaOfNee)) {
                
            //}

}

    }


}

// Check of input valide is (bvb Ja of ja, Nee ( input van user standaard converteren naar lower case in de vorige stap)).
// Check welke Edges de origin node (Edge[0]) bij de vraag bevatten.
// Check welke destination node bij het gegeven antwoord hoort.
// Kies nieuwe node om weer te geven, einde loop.

// Wanneer de node geen "?" als laatste karakter heeft, geef antwoord (bvb System.out.println("Het blad wat je zoekt is van een " + Node[1] + "boom!"))