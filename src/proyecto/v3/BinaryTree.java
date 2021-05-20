package proyecto.v3;

public class BinaryTree {

}

class BinaryNode {

    private final String state;
    private final boolean answer;

    private BinaryNode left, right;

    public BinaryNode(Tree.Node node) {
        this.state = node.getState();
        this.answer = node.isAnswer();
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
}


