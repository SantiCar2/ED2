package proyecto.v3;

import java.util.Iterator;

public class BinaryTree {

    private final BinaryNode root;

    public BinaryTree(Tree tree) {
        this.root = new BinaryNode(tree.getRoot());
        fillLeft(root, tree.getRoot().getChildren().listIterator());
    }

    private void fillLeft(BinaryNode nodeA, Iterator<Tree.Node> hijosNodeA){
        if (!hijosNodeA.hasNext()) {
            return;
        }

        Tree.Node nodTemp = hijosNodeA.next();
        BinaryNode nodeB = new BinaryNode(nodTemp);

        nodeA.setLeft(nodeB);

        fillLeft(nodeB, nodTemp.getChildren().listIterator());

        if (hijosNodeA.hasNext()) {
            fillRight(nodeB, hijosNodeA);
        }
    }

    private void fillRight(BinaryNode node, Iterator<Tree.Node> iterator) {
        if (!iterator.hasNext()) {
            return;
        }

        Tree.Node nodTemp = iterator.next();
        BinaryNode nodeF = new BinaryNode(nodTemp);

        node.setRight(nodeF);

        fillLeft(nodeF, nodTemp.getChildren().listIterator());
        fillRight(nodeF, iterator);
    }

}

class BinaryNode {

    private final String state;
    private final boolean answer;
    private final int n;

    private BinaryNode left, right;

    public BinaryNode(Tree.Node node) {
        this.state = node.getState();
        this.answer = node.isAnswer();
        this.n = node.getN();
    }

    public String getState() {
        return state;
    }

    public String inOrder() {
        String s = "";
        if (left != null) {
            s += left.inOrder();
        }
        s += " , ";
        System.out.println(state + " , ");
        if (right != null) {
            s += right.inOrder();
        }
        return s;
    }

    @Override
    public String toString() {
        return state;
    }

    public boolean isAnswer() {
        return answer;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public int getN() {
        return n;
    }
}


