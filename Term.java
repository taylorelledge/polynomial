
/**
 * Class Term loads term objects for use in Polynomial class.
 */
public class Term
{
    private int coeff;
    private int exp;

    public Term()
    {
        //default constructor
    }

    /**
     * Constructor for objects of class LoadObject
     */
    public Term(int c, int e)
    {
        coeff = c;
        exp = e;
    }

    /**
     * setCoeff() - sets coefficient variable for term objects.
     * 
     * @param - int
     * @return - none
     */
    public void setCoeff(int inCoeff)
    {
        coeff = inCoeff;
    }

    /**
     * getCoeff() - gets coefficient variable for term objects.
     * 
     * @param - none
     * @return - int
     */
    public int getCoeff()
    {
        return coeff;
    }

    /**
     * setExp() - sets exponent variable for term objects
     * 
     * @param - int
     * @return - none
     */
    public void setExp(int inExp)
    {
        exp = inExp;
    }

    /**
     * getExp() - gets exponent variable for term objects
     * 
     * @param - none
     * @return - int
     */
    public int getExp()
    {
        return exp;
    }

    /**
     * loadObject() - takes a String argument as parameter and splits it around x to obtain the 
     * needed info for Term object which is then loaded into object and returned to Polynomial class
     * 
     * @param - String
     * @return - Term
     */
    public Term loadObject(String arg)
    {
        boolean coeffSet = false;
        boolean objectLoaded = false;
        Term foo = new Term(0,0);

        for(String tempString: arg.split("x"))
        {
            if(foo.isInteger(tempString) && coeffSet == false && tempString != "0")
            {
                coeff = Integer.parseInt(tempString);
                coeffSet = true;
            }
            else if(foo.isInteger(tempString) && tempString != "0")
            {
                if(tempString.equals("0"))
                    exp = 1;
                else
                    exp = Integer.parseInt(tempString);
                objectLoaded = true;
            }
            if(arg.length() <= 2 && coeffSet == true)
            {
                exp = 1;
                objectLoaded = true;
            }
            if(objectLoaded == true)
            {
                Term derp = new Term(coeff, exp);
                coeffSet = false;
                objectLoaded = false;
                return derp;
            }
        }

        return foo;
    }

    /**
     * isInteger() - helper method for checking if Strings being passed to Term class qualify as integers
     * 
     * @param - String
     * @return - boolean
     */
    public static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        }
        return true;
    }
}
