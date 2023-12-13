import MaxSideLength.MaxSideLength;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        MaxSideLength m = new MaxSideLength();
        System.out.println(m.solve(System.getProperty("user.dir") + "\\src\\in.txt"));
    }
}