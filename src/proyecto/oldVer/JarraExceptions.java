package proyecto.oldVer;

public class JarraExceptions {

    static class JarraLlenaE extends Exception {

        public JarraLlenaE(String mensaje) {
            super(mensaje);
        }

        public JarraLlenaE() {
        }
    }

    static class JarraVaciaE extends Exception {

        public JarraVaciaE() {
        }

        public JarraVaciaE(String message) {
            super(message);
        }
    }
}
