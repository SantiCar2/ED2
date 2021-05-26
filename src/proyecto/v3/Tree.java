package proyecto.v3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Tree {
    public final Set<String> set = new HashSet<>();
    public final int objective;
    private final int xCapacity;
    private final int yCapacity;
    private final int limit;

    private Node root;

    public Tree(int objective, int xCapacity, int yCapacity) {
        this.objective = objective;
        this.xCapacity = xCapacity;
        this.yCapacity = yCapacity;
        this.limit = 2*(xCapacity * yCapacity);

        start();
    }


    private void start() {
        root = new Node(0, 0, -1, "Root", 0);
    }


    class Node {
        private final String state;// representation of node
        private final boolean answer;
        private final LinkedList<Node> children = new LinkedList<>();
        private final int x, y;// current 'water' levels
        private final int n;

        public Node(int x, int y, int operation, String fatherState, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
            this.state = "(" + x + " , " + y + ")";


            if (n < limit && set.add(state)) { //state: es para que no se quede en un ciclo haciendo las mismas operaciones
                if (!(x == objective || y == objective)) { //Evaluar cuando se llegue al objetivo
                    answer = false;
                    createChildren(operation); //se crea un hijo
                } else {
                    answer = true;
                }
            } else {
                answer = false; //Si no se logró llegar al objetivo
            }
        }

        private void createChildren(int operation) {

            // createFilledX();
            // createFilledY();
            // createXtoY();
            // createYtoX();
            // createEmptyX();
            // createEmptyY();

            /*NO MODIFICAR*/
            switch (operation) {
                case -1 -> {
                    createFilledX();
                    createFilledY();
                    createXtoY();
                    createYtoX();
                    createEmptyX();
                    createEmptyY();
                }
                // filled x
                case 0 -> {
                    createFilledY();
                    createXtoY();
                    createYtoX();
                    createEmptyX();
                    createEmptyY();
                }
                // filled y
                case 1 -> {
                    createFilledX();
                    createXtoY();
                    createYtoX();
                    createEmptyX();
                    createEmptyY();
                }
                // x to y
                case 2 -> {
                    createFilledX();
                    createFilledY();
                    createYtoX();
                    createEmptyX();
                    createEmptyY();
                }
                // y to x
                case 3 -> {
                    createFilledX();
                    createFilledY();
                    createXtoY();
                    createEmptyX();
                    createEmptyY();
                }
                // empty x
                case 4 -> {
                    createFilledX();
                    createFilledY();
                    createXtoY();
                    createYtoX();
                    createEmptyY();
                }
                // empty y
                case 5 -> {
                    createFilledX();
                    createFilledY();
                    createXtoY();
                    createYtoX();
                    createEmptyX();
                }
                default -> throw new UnsupportedOperationException("Value " + operation + "not recognized. Default switch operation not supported");
            }
        }

        //OPERACIONES
        private void createFilledX() { //Llenar x
            final int op = 0;
            if (x <= xCapacity) {
                children.offer(new Node(xCapacity, y, op, state, n + 1)); //Para crear un hijo en la LinkedList
            }
        }

        private void createFilledY() { //Llenar y
            final int op = 1;
            if (y <= yCapacity) {
                children.offer(new Node(x, yCapacity, op, state, n + 1)); //Para crear un hijo en la LinkedList
            }
        }

        private void createXtoY() { // De x a y
            final int op = 2;
            // x - d >= 0
            // y + d <= Cy
            /*
            (1) => yf = Cy ---> (y0 + d) = Cy
            {
            y0 + d = Cy --> d = Cy - y0
            x0 - d = xf >= 0 --> xf = x0 - d = x0 - (Cy - y0)
            :: yf = Cy, xf = x0 - (Cy - y0)
            }
            (2) => xf = 0 ---> (x0 - d) = 0
            {
            x0 - d = 0 --> d = x0
            y0 + d <= Cy --> y0 + d = yf <= Cy --> yf = y0 + x0
            :: xf = 0, yF = y0 + x0
            }
            */
            final int tX, tY;
            if (x != 0 && y != yCapacity) {
                if (x + y >= yCapacity) {
                    // (1)
                    tX = x - (yCapacity - y);
                    tY = yCapacity;
                } else {
                    // (2)
                    tX = 0;
                    tY = y + x;
                }

                children.offer(new Node(tX, tY, op, state, n + 1)); //Para crear un hijo en la LinkedList
            }
        }

        private void createYtoX() { //De Y a X
            final int op = 3;
            // x + d <= Cx
            // y - d >= 0
            /*
            (1) => xf = Cx ---> (x0 + d) = Cx
            x0 + d = Cx --> d = Cx - x0
            y0 - d = yf --> yf = y0 - (Cx - x0)
            :: xf = Cx, yf = y0 - (Cx - x0)
            (2) => yf = 0 --> y0 - d = 0
            y0 - d = 0 --> d = y0
            x0 + d = xf --> xf = x0 + y0
            :: yf = 0, xF = x0 + y0
             */
            final int tX, tY;

            if (y != 0 && x != xCapacity) {
                if (x + y > xCapacity) {
                    // (1)
                    tX = xCapacity;
                    tY = y - (xCapacity - x);
                } else {
                    // (2)
                    tY = 0;
                    tX = x + y;
                }
                children.offer(new Node(tX, tY, op, state, n + 1)); //Para crear un hijo en la LinkedList
            }

        }

        private void createEmptyX() { //Crear la jarra X
            final int op = 4;
            if (x != 0) {
                children.offer(new Node(0, y, op, state, n + 1)); //Para crear un hijo en la LinkedList
            }
        }

        private void createEmptyY() { //Crear la jarra Y
            final int op = 5;
            if (y != 0) {
                children.offer(new Node(x, 0, op, state, n + 1)); //Para crear un hijo en la LinkedList
            }
        }

        public void preOrder() {
            System.out.print("{ " + state);
            for (Node child : children) {
                preOrder();
            }
            System.out.print(" }");
        }

        // Getters
        public String getState() {
            return state;
        }

        public LinkedList<Node> getChildren() {
            return children;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean isAnswer() {
            return answer;
        }

        public int getN() {
            return n;
        }

        @Override
        public String toString() {
            return state;
        }
    }

    public Set<String> getSet() {
        return set;
    }

    public int getObjective() {
        return objective;
    }

    public int getxCapacity() {
        return xCapacity;
    }

    public int getyCapacity() {
        return yCapacity;
    }

    public int getLimit() {
        return limit;
    }

    public Node getRoot() {
        return root;
    }

}

