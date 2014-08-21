import java.util.Scanner;
import java.io.*;
/**
 * Taylor Elledge 007686183
 * 
 * Polynomial Extra Credit Lab
 */
public class Driver
{
    public static void main(String [] args)throws IOException
    {
        PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
        Polynomial foo = new Polynomial(pw);
        int choice = 0;
        do
        {
            System.out.println();
            System.out.println("Please make a selection. Input the corresponding menu number.");
            pw.println("Please make a selection. Input the corresponding menu number.");
            System.out.println("When inputting polynomials be sure to follow this input format");
            System.out.println("5x3 + 1x2 + 4x + 3");
            System.out.println("There must be spaces between all operators and and a leading coefficient for all terms.");
            pw.println("When inputting polynomials be sure to follow this input format");
            pw.println("5x3 + 1x2 + 4x + 3");
            pw.println("There must be spaces between all operators and and a leading coefficient for all terms.");
            System.out.println("1)Input and print polynomial.");
            pw.println("1)Input and print polynomial.");
            System.out.println("2)Find difference of two polynomials.");
            pw.println("2)Find difference of two polynomials.");
            System.out.println("3)Find scalar product of a polynomial.");
            pw.println("3)Find scalar product of a polynomial.");
            System.out.println("4)Evaluate polynomial given an integer.");
            pw.println("4)Evaluate polynomial given an integer.");
            System.out.println("5)Find first three derivatives");
            pw.println("5)Find first three derivatives");
            System.out.println("0)Exit Program");
            pw.println("0)Exit Program");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            switch(choice)
            {
                case 1: foo.getInfo();
                foo.printPoly();
                break;
                case 2: foo.getInfo();
                foo.differenceOfPolynomials();
                break;
                case 3: foo.getInfo();
                foo.scalarMult();
                foo.printPoly();
                break;
                case 4: foo.getInfo();
                foo.evaluatePoly();
                break;
                case 5: foo.getInfo();
                foo.derivative();
                break;
                case 0: System.out.println("Thank you for using the program :o)");
                pw.flush();
                pw.close();
                System.exit(0);
            }
        }while(choice != 0);

    }
}

