package proyecto;

import java.util.Iterator;
import java.util.LinkedList;

public class ArbolB {
//
//    private short objetivo;
//
//    private proyecto_solo.NodoB root;
//
//    public ArbolB(Arbol tree) {
//        objetivo = tree.getObjetivo();
//
//        root = new proyecto_solo.NodoB(tree.getRoot());
//        fillLeft(root,tree.getRoot().getHijos().listIterator());
//    }
//    private void fillLeft(proyecto_solo.NodoB nodeA, Iterator<proyecto_solo.Nodo> hijosNodeA) {
//        if (!hijosNodeA.hasNext()) {
//            return;
//        }
//        var nodTemp = hijosNodeA.next();
//        var nodoB = new proyecto_solo.NodoB(nodTemp);
//        // son el 'mismo' Nodo
//
//        nodeA.setNodoIzquierda(nodoB);
//
//        fillLeft(nodoB, nodTemp.getHijos().listIterator());
//
//        if (hijosNodeA.hasNext()) {
//            fillRight(nodoB, hijosNodeA);
//        }
//    }
//
//    private void fillRight(proyecto_solo.NodoB node, Iterator<Nodo> iterator) {
//        if (!iterator.hasNext()){
//            return;
//        }
//        var nodTemp = iterator.next();
//        var nodeF = new NodoB(nodTemp);
//
//        node.setNodoDerecha(nodeF);
//
//        fillLeft(nodeF, nodTemp.getHijos().listIterator());
//        fillRight(nodeF, iterator);
//
//    }

    private static class Prueba<E> {

        public static void main(String[] args) {
            var A = new Node<>("A");
            var B = new Node<>("B");
            var C = new Node<>("C");
            var D = new Node<>("D");
            var E = new Node<>("E");
            var F = new Node<>("F");
            var G = new Node<>("G");
            var H = new Node<>("H");
            var I = new Node<>("I");
            var J = new Node<>("J");
            var K = new Node<>("K");
            var L = new Node<>("L");
            var M = new Node<>("M");

            A.add(B).add(C).add(D);
            B.add(E).add(F).add(G);
            C.add(H).add(I).add(J);
            D.add(K).add(L).add(M);

            var tree = new Tree<>(A);

            var bTree = new Prueba<>(tree);
            bTree.inOrder();


        }

        private NodeB<E> root;

        public Prueba(Tree<E> tree) {
            root = new NodeB<>(tree.getRoot());
            fillLeft(root, tree.getRoot().getHijos().listIterator());
        }

        private void fillLeft(NodeB<E> nodeA, Iterator<Node<E>> hijosNodeA) {
            if (!hijosNodeA.hasNext()) {
                return;
            }

            var nodTemp = hijosNodeA.next();
            var nodeB = new NodeB<>(nodTemp);

            nodeA.setLeft(nodeB);

            fillLeft(nodeB, nodTemp.getHijos().listIterator());

            if (hijosNodeA.hasNext()) {
                fillRight(nodeB, hijosNodeA);
            }
        }

        private void fillRight(NodeB<E> node, Iterator<Node<E>> iterator) {
            if (!iterator.hasNext()) {
                return;
            }
            var nodTemp = iterator.next();
            var nodeF = new NodeB<>(nodTemp);

            node.setRight(nodeF);

            fillLeft(nodeF, nodTemp.getHijos().listIterator());
            fillRight(nodeF, iterator);
        }

        public void inOrder() {
            if (root != null) {
                root.inOrder();
            }
        }

        @Override
        public String toString() {
            return root.toString();
        }

        static class NodeB<E> {

            private E e;

            private NodeB<E> left, right;

            public NodeB(Node<E> node) {
                this.e = node.getE();
            }

            public E getE() {
                return e;
            }

            public void setE(E e) {
                this.e = e;
            }

            public NodeB<E> getLeft() {
                return left;
            }

            public void setLeft(NodeB<E> left) {
                this.left = left;
            }

            public NodeB<E> getRight() {
                return right;
            }

            public void setRight(NodeB<E> right) {
                this.right = right;
            }

            public void inOrder() {
                if (left != null) {
                    left.inOrder();
                }
                System.out.print(e + " , ");
                if (right != null) {
                    right.inOrder();
                }
            }

            @Override
            public String toString() {
                return e.toString();
            }
        }

        static class Tree<E> {

            private Node<E> root;

            public Tree(Node<E> root) {
                this.root = root;
            }

            public Node<E> getRoot() {
                return root;
            }

            public void setRoot(Node<E> root) {
                this.root = root;
            }

            @Override
            public String toString() {
                return root.toString();
            }
        }

        static class Node<E> {

            private E e;
            private final LinkedList<Node<E>> hijos;

            public Node(E e) {
                this.e = e;
                hijos = new LinkedList<>();
            }

            public Node<E> add(Node<E> nodo) {
                hijos.add(nodo);
                return this;
            }


            public LinkedList<Node<E>> getHijos() {
                return hijos;
            }

            public E getE() {
                return e;
            }

            public void setE(E e) {
                this.e = e;
            }

            @Override
            public String toString() {
                return e.toString();
            }
        }

    }
}

