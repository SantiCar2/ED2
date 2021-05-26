package proyecto.v3;

import java.util.Iterator;

public class BinaryTree {

    private final BinaryNode root;

    /**
     * Constructor, recive un Arbol({@code Tree})
     *
     * @param tree Arbol n, para convertir a binario
     */
    public BinaryTree(Tree tree) {
        this.root = new BinaryNode(tree.getRoot());
        fillLeft(root, tree.getRoot().getChildren().listIterator());
    }

    /**
     * Llena el lado izquierdo del nodo binario con los hijos del nodo-n correspondiente
     *
     * @param nodeA      NodoBinario
     * @param hijosNodeA Hijos del Nodo n correspondiente al {@code nodeA}
     */
    private void fillLeft(BinaryNode nodeA, Iterator<Tree.Node> hijosNodeA) {
        // Condición de retorno para recursividad
        if (!hijosNodeA.hasNext()) {
            return;
        }
        // Nodo-n temporal, Se retira del iterator
        Tree.Node nodTemp = hijosNodeA.next();
        // Conversión de Nodo-n temporal a Nodo Binario
        BinaryNode nodeB = new BinaryNode(nodTemp);
        // Establecer nodeB como hijo izquierdo de nodeA
        nodeA.setLeft(nodeB);
        // Llenar el lado derecho de nodeB con los hijos del nodo-n Correspondiente
        fillLeft(nodeB, nodTemp.getChildren().listIterator());
        // Si nodeB tiene hermanos, llenar el lado derecho
        if (hijosNodeA.hasNext()) {
            // Llenar el lado derecho de nodeB con los hermanos del nodo-n correspondiente
            fillRight(nodeB, hijosNodeA);
        }
    }

    /**
     * Llena el lado derecho del nodo binario con los hermanos del nodo-n correspondientes
     *
     * @param node     NodoBinario
     * @param iterator Los hermanos del nodo-n Correspondiente al NodoBinario
     */
    private void fillRight(BinaryNode node, Iterator<Tree.Node> iterator) {
        // Condición de retorno para recursividad
        if (!iterator.hasNext()) {
            return;
        }
        // Nodo-n temporal, se retira del iterator
        Tree.Node nodTemp = iterator.next();
        // Conversión de Nodo-n temporal a Nodo Binario
        BinaryNode nodeF = new BinaryNode(nodTemp);
        // Establecer nodoF como hijo derecho de node
        node.setRight(nodeF);
        // Llenar el lado izquierdo de nodeF con los hijos del nodo-n correspondiente
        fillLeft(nodeF, nodTemp.getChildren().listIterator());
        // Llenar el lado derecho de nodeF con los hermanos del nodo-n correspondiente
        fillRight(nodeF, iterator);
    }

    public BinaryNode getRoot() {
        return root;
    }

    public static class BinaryNode {

        private final String state;
        private final boolean answer;
        private final int n;

        private BinaryNode left, right, parent;

        /**
         * Constructor, crea un Nodo Binario a partir de un nodo-n
         *
         * @param node nodo-n para Convertir a Nodo Binario
         */
        public BinaryNode(Tree.Node node) {
            this.state = node.getState();
            this.answer = node.isAnswer();
            this.n = node.getN();
        }

        /**
         * Navegar el sub arbol Binario en order
         * @return
         */
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

        public String getState() {
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
            left.setParent(this);
        }

        public BinaryNode getRight() {
            return right;
        }

        public void setRight(BinaryNode right) {
            this.right = right;
            right.setParent(this);
        }

        public BinaryNode getParent() {
            return parent;
        }

        public void setParent(BinaryNode parent) {
            this.parent = parent;
        }

        public int getN() {
            return n;
        }
    }

}



