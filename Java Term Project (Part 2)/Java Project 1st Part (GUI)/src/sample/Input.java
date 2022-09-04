package sample;
import java.util.Scanner;

public class Input {
    String name;
    int integer;
    Double dbl;
    Scanner sc = new Scanner(System.in);

    public Input(){

    }

    public String getString()
    {
        sc = new Scanner(System.in);
        name = sc.nextLine();
        return name;
    }

    public int getInteger()
    {
        sc = new Scanner(System.in);
        integer = sc.nextInt();
        return integer;
    }

    public Double getDouble()
    {
        sc = new Scanner(System.in);
        dbl = sc.nextDouble();
        return dbl;
    }

}
