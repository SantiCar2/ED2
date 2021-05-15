package proyecto;

public class NodoB {

    private Jarra jar1;
    private Jarra jar2;

    private short objetivo;

    private NodoB left, right;

    public NodoB(Nodo node) {
        // TODO: info del nodo
    }

    public void setLeft(NodoB left) {
        this.left = left;
    }

    public void setRight(NodoB right) {
        this.right = right;
    }

//    public void inOrder() {
//        if (left != null) {
//            left.inOrder();
//        }
//        System.out.print(e + " , ");
//        if (right != null) {
//            right.inOrder();
//        }
//    }
//
//    @Override
//    public String toString() {
//        return e.toString();
//    }
}