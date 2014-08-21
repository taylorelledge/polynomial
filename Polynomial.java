
import java.util.Scanner;
import java.lang.Math.*;
import java.io.*;
/**
 * Class Polynomial contains all functionality for program as specified per lab assignment.
 */
public class Polynomial
{
    // instance variables - replace the example below with your own
    private ObjectList listOne = new ObjectList();
    private ObjectList listTwo = new ObjectList();
    private ObjectList differenceList = new ObjectList();
    private StringBuffer operatorsOne;
    private StringBuffer operatorsTwo;
    private PrintWriter pw;
    /**
     * Constructor for objects of class polynomial
     */
    public Polynomial(PrintWriter pw)
    {
        this.pw = pw;
    }

    /**
     * getInfo() - method takes user input for polynomial and processes it accordingly into a linked list.
     * 
     * @param - none
     * @return - none
     */
    public void getInfo()
    {
        if(!listOne.isEmpty())
        {
            listOne.clear();
        }
        operatorsOne = new StringBuffer("");
        Scanner input = new Scanner(System.in);
        System.out.println("Please input polynomial.");
        pw.println("Please input polynomial.");
        Term derp = new Term();
        Term foo  = new Term();
        String reader = input.nextLine();
        String [] splitString = reader.split(" ");
        for(int i = 0; i < splitString.length; i++)
        {
            String temp = splitString[i];
            if(temp.equals("+") || temp.equals("*") || temp.equals("-") || temp.equals("/") )
            {
                operatorsOne.append(temp);
            }
            foo = derp.loadObject(temp);
            if(foo.getCoeff() != 0)
            {
                ObjectListNode node = new ObjectListNode();
                node.setInfo(foo);
                listOne.addLast(node);
            }
        }
    }

    /**
     * scalarMult() - multiplies the input polynomial by a scalar.
     * 
     * @param - none
     * @return - none
     */
    public void scalarMult()
    {
        System.out.println("Please input the scalar you wish to multiply the polynomial by.");
        pw.println("Please input the scalar you wish to multiply the polynomial by.");
        Scanner input = new Scanner(System.in);
        int scalar = input.nextInt();
        ObjectList tempList = listOne.copyList();
        listOne.clear();
        ObjectListNode node = (ObjectListNode) tempList.getFirstNode();
        while(node != null)
        {
            Term foo = new Term();
            foo = (Term)node.getInfo();
            int tempCoeff = foo.getCoeff();
            int newCoeff = tempCoeff * scalar;
            foo.setCoeff(newCoeff);
            ObjectListNode temp = new ObjectListNode();
            temp.setInfo(foo);
            listOne.addLast(temp);
            node = node.getNext();
        }
    }

    /**
     * printPoly() - a uniform print method for the class variables that outputs the polynomial with all of it's
     * terms and operators in the proper position.
     * 
     * @param - none
     * @return - none
     */
    public void printPoly()
    {
        ObjectListNode node = (ObjectListNode) listOne.getFirstNode();
        int degree = listOne.size();
        int sbIndex = 0;
        while(node != null)
        {
            Term foo = new Term();
            foo = (Term)node.getInfo();
            int tempCoeff = foo.getCoeff();
            int tempExp = foo.getExp();
            if(tempExp == 1 && degree == 1)
            {
                System.out.print(tempCoeff);
                pw.print(tempCoeff);
            }
            else if(tempExp <= 1)
            {
                System.out.print(tempCoeff + "x " + operatorsOne.charAt(sbIndex) + " ");
                pw.print(tempCoeff + "x " + operatorsOne.charAt(sbIndex) + " ");
            }
            else if(tempExp > 1)
            {
                System.out.print(tempCoeff + "x^" + tempExp + " " + operatorsOne.charAt(sbIndex) + " ");
                pw.print(tempCoeff + "x^" + tempExp + " " + operatorsOne.charAt(sbIndex) + " ");
            }
            degree--;
            sbIndex++;
            node = node.getNext();
        }
    }

    /**
     * evaluatePoly() - processes the linked list given an integer provided by the user and finds the final value
     * of the polynomial.
     * 
     * @param - none
     * @return - none
     */
    public void evaluatePoly()
    {
        System.out.println("Please input the integer you wish to represent X");
        pw.println("Please input the integer you wish to represent X");
        Scanner input = new Scanner(System.in);
        int variable = input.nextInt();
        int finalValue = 0;
        int sbIndex = 0;
        int [] termArray = new int [listOne.size()];
        int i = 0;
        int degree = listOne.size();
        ObjectListNode node = (ObjectListNode) listOne.getFirstNode();
        while(node != null)
        {
            Term term = new Term();
            term = (Term)node.getInfo();
            int tempCoeff = term.getCoeff();
            int tempExp = term.getExp();
            double tempTerm = 0;
            if(degree > 1)
            {
                tempTerm = tempCoeff * Math.pow(variable, tempExp);
            }
            else if(degree == 1)
            {
                tempTerm = tempCoeff;
            }

            int termValue = (int)tempTerm;
            termArray [i] = termValue;
            i++;
            degree--;
            node = node.getNext();
        }

        for(int j = 0; j < termArray.length; j++)
        {
            int term = termArray[j];
            char operator = operatorsOne.charAt(sbIndex);
            if(j == 0)
            {
                finalValue += term;
            }
            else if(operator == '+')
            {
                finalValue += term;
                sbIndex++;
            }
            else if(operator == '*')
            {
                finalValue *= term;
                sbIndex++;
            }
            else if(operator == '-')
            {
                finalValue -= term;
                sbIndex++;
            }
            else if(operator == '/')
            {
                finalValue /= term;
                sbIndex++;
            }
        }
        System.out.println("polynomial value= " + finalValue);
        pw.println("polynomial value= " + finalValue);
    }

    /**
     * differenceOfPolynomials() - finds the difference of two polynomials that are provided by the user.
     * 
     * @param - none
     * @ return - none
     */
    public void differenceOfPolynomials()
    {
        if(!listTwo.isEmpty())
        {
            listTwo.clear();
        }
        operatorsTwo = new StringBuffer("");
        System.out.println("Please input polynomial.");
        pw.println("Please input polynomial.");
        Scanner input = new Scanner(System.in);
        Term derp = new Term();
        Term foo  = new Term();
        String reader = input.nextLine();
        String [] splitString = reader.split(" ");
        int listCount = 0;
        for(int i = 0; i < splitString.length; i++)
        {
            String temp = splitString[i];
            if(temp.equals("+") || temp.equals("*") || temp.equals("-") || temp.equals("/") )
            {
                operatorsTwo.append(temp);
            }
            foo = derp.loadObject(temp);
            if(foo.getCoeff() != 0)
            {
                ObjectListNode node = new ObjectListNode();
                node.setInfo(foo);
                listTwo.addLast(node);
            }
        }

        ObjectListNode nodeOne = (ObjectListNode)listOne.getFirstNode();
        ObjectListNode nodeTwo = (ObjectListNode)listTwo.getFirstNode();
        int count = 0;
        int coeff = 0;
        int i = 0;
        while(nodeOne != null && nodeTwo != null)
        {
            Term termOne = (Term)nodeOne.getInfo();
            Term termTwo = (Term)nodeTwo.getInfo();
            if(termOne.getExp() == termTwo.getExp())
            {
                int exp = termOne.getExp();
                if(count == 0)
                {
                    coeff = termOne.getCoeff() - termTwo.getCoeff();
                }
                else if(count >= 1 && (operatorsTwo.charAt(i) == '-'))
                {
                    coeff = termOne.getCoeff() + termTwo.getCoeff();
                    i++;
                }
                else if(count >= 1 && (operatorsTwo.charAt(i) == '+'))
                {
                    coeff = termOne.getCoeff() - termTwo.getCoeff();
                    i++;
                }
                Term diff = new Term(coeff, exp);
                ObjectListNode node = new ObjectListNode();
                node.setInfo(diff);
                differenceList.addLast(node);
            }
            count++;
            nodeOne = nodeOne.getNext();
            nodeTwo = nodeTwo.getNext();
        }
        ObjectListNode node = (ObjectListNode) differenceList.getFirstNode();
        count = 0;
        int degree = differenceList.size();
        while(node != null)
        {
            Term term = new Term();
            term = (Term)node.getInfo();
            int tempCoeff = term.getCoeff();
            int tempExp = term.getExp();

            if(tempExp <= 1 && tempCoeff >= 1 && degree == 1)
            {
                System.out.print("+ " + tempCoeff);
                pw.print("+ " + tempCoeff);
            }
            else if(tempExp <= 1 && tempCoeff >= 1)
            {
                System.out.print(" + " + tempCoeff + "x ");
                pw.print(" + " + tempCoeff + "x ");
            }
            else if(tempExp > 1 && tempCoeff >= 1 && count == 0)
            {
                System.out.print(tempCoeff + "x^" + tempExp);
                pw.print(tempCoeff + "x^" + tempExp);
            }
            else if(tempExp > 1 && tempCoeff >= 1)
            {
                System.out.print(" + " + tempCoeff + "x^" + tempExp);
                pw.print(" + " + tempCoeff + "x^" + tempExp);
            }
            else if(tempExp <= 1 && tempCoeff < 0)
            {
                System.out.print(" + " + tempCoeff + "x ");
                pw.print(" + " + tempCoeff + "x ");
            }
            else if(tempExp > 1 && tempCoeff < 0)
            {
                System.out.print(tempCoeff + "x^" + tempExp);
                pw.print(tempCoeff + "x^" + tempExp);
            }
            count++;
            degree--;
            node = node.getNext();
        }
    }

    /**
     * derivative() - calculates the first three derivatives of class variable listOne.
     * 
     * @param - none
     * @return - none
     */
    public void derivative()
    {
        int loopCount = 0;
        while(loopCount < 3)
        {
            ObjectList tempList = listOne.copyList();
            int degree = tempList.size();
            listOne.clear();
            ObjectListNode node = (ObjectListNode) tempList.getFirstNode();
            for(int i = degree; i > 1; i--)
            {
                Term term = new Term();
                term = (Term)node.getInfo();
                int tempCoeff = term.getCoeff();
                int tempExp = term.getExp();
                if(tempExp > 1)
                {
                    int coeff = tempCoeff * tempExp;
                    tempExp--;
                    term.setCoeff(coeff);
                    term.setExp(tempExp);
                    ObjectListNode foo = new ObjectListNode();
                    foo.setInfo(term);
                    listOne.addLast(foo);
                    degree--;
                }
                else if(tempExp == 1 && degree > 1)
                {
                    term.setCoeff(tempCoeff);
                    node.setInfo(term);
                    listOne.addLast(node);
                    degree--;
                }
                node = node.getNext();
            }
            node = (ObjectListNode)listOne.getFirstNode();
            int sbIndex = 0;
            degree = listOne.size();
            if(loopCount == 0)
            {
                System.out.println();
                pw.println();
                System.out.println("---First Derivative---");
                System.out.println();
                pw.println();
                pw.println("---First Derivative---");
                pw.println();
            }
            else if(loopCount == 1)
            {
                System.out.println();
                pw.println();
                System.out.println("---Second Derivative---");
                System.out.println();
                pw.println();
                pw.println("---Second Derivative---");
                pw.println();
            }
            else if(loopCount == 2)
            {
                System.out.println();
                pw.println();
                System.out.println("---Third Derivative---");
                System.out.println();
                pw.println();
                pw.println("---Third Derivative---");
                pw.println();
            }
            while(node != null)
            {
                Term foo = new Term();
                foo = (Term)node.getInfo();
                int tempCoeff = foo.getCoeff();
                int tempExp = foo.getExp();
                if(degree == 1)
                {
                    System.out.print(tempCoeff);
                    pw.print(tempCoeff);
                }
                else if(tempExp <= 1)
                {
                    System.out.print(tempCoeff + "x " + operatorsOne.charAt(sbIndex) + " ");
                    pw.print(tempCoeff + "x " + operatorsOne.charAt(sbIndex) + " ");
                }
                else if(tempExp > 1)
                {
                    System.out.print(tempCoeff + "x^" + tempExp + " " + operatorsOne.charAt(sbIndex) + " ");
                    pw.print(tempCoeff + "x^" + tempExp + " " + operatorsOne.charAt(sbIndex) + " ");
                }
                degree--;
                sbIndex++;
                node = node.getNext();

            }
            System.out.println();
            loopCount++;
        }
    }
}
