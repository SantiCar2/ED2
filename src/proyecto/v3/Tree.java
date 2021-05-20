package proyecto.v3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Tree {
    public final Set<String> set = new HashSet<>();
    public final int objective;
    private final int xCapacity;
    private final int yCapacity;

    private Node root;

    public Tree(int objective, int xCapacity, int yCapacity) {
        this.objective = objective;
        this.xCapacity = xCapacity;
        this.yCapacity = yCapacity;
    }

    public static void main(String[] args) {
        Tree t = new Tree(0, 0, 0);

        t.start();
    }

    private void start() {
        root = new Node(0, 0, -1, "Root");
    }

    class Node {
        private final String state;// representation of node
        private final boolean answer;
        private final LinkedList<Node> children = new LinkedList<>();
        private final int x, y;// current 'water' levels

        public Node(int x, int y, int operation, String fatherState) {
            this.x = x;
            this.y = y;
            this.state = "(" + x + " , " + y + ")";

            if (set.add(state + "," + fatherState)) {
                if (!(x == objective || y == objective)) {
                    answer = false;
                    createChildren(operation);
                } else {
                    answer = true;
                }
            } else {
                answer = false;
            }
        }

        private void createChildren(int operation) {
            // createFilledX();
            // createFilledY();
            // createXtoY();
            // createYtoX();
            // createEmptyX();
            // createEmptyY();
            // TODO: Replace Switch statement with enhanced 'switch'
            switch (operation) {
                case -1:
                    createFilledX();
                    createFilledY();
                    createXtoY();
                    createYtoX();
                    createEmptyX();
                    createEmptyY();
                    break;
                case 0: // filled x
                    createFilledY();
                    createXtoY();
                    createYtoX();
                    createEmptyX();
                    createEmptyY();
                    break;
                case 1: // filled y
                    createFilledX();
                    createXtoY();
                    createYtoX();
                    createEmptyX();
                    createEmptyY();
                    break;
                case 2: // x to y
                    createFilledX();
                    createFilledY();
                    createYtoX();
                    createEmptyX();
                    createEmptyY();
                    break;
                case 3: // y to x
                    createFilledX();
                    createFilledY();
                    createXtoY();
                    createEmptyX();
                    createEmptyY();
                    break;
                case 4: // empty x
                    createFilledX();
                    createFilledY();
                    createXtoY();
                    createYtoX();
                    createEmptyY();
                    break;
                case 5: // empty y
                    createFilledX();
                    createFilledY();
                    createXtoY();
                    createYtoX();
                    createEmptyX();
                    break;
                default:
                    throw new UnsupportedOperationException("Value " + operation + "not recognized. Default switch operation not supported");
            }
        }


        private void createFilledX() {
            final int op = 0;
            if (x != xCapacity) {
                children.offer(new Node(xCapacity, y, op, state));
            }
        }

        private void createFilledY() {
            final int op = 1;
            if (y != yCapacity) {
                children.offer(new Node(x, yCapacity, op, state));
            }
        }

        private void createXtoY() {
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
                if (y + y >= yCapacity) {
                    // (1)
                    tX = x - (yCapacity - y);
                    tY = yCapacity;
                } else {
                    // (2)
                    tX = 0;
                    tY = y + x;
                }

                children.offer(new Node(tX, tY, op, state));
            }
        }

        private void createYtoX() {
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
                children.offer(new Node(tX, tY, op, state));
            }

        }

        private void createEmptyX() {
            final int op = 4;
            if (x != 0) {
                children.offer(new Node(0, y, op, state));
            }
        }

        private void createEmptyY() {
            final int op = 5;
            if (y != 0) {
                children.offer(new Node(x, 0, op, state));
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

        @Override
        public String toString() {
            return state;
        }
    }

}

