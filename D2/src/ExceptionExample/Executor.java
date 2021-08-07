package ExceptionExample;

public class Executor {
    public void exec() {
        try {
            Divider.divide();
        } catch (ArithmeticException ex) {
            System.out.println("Exception ocurred");
            throw new MyUncheckedException(ex);
        }
    }


}
