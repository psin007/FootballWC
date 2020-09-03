/**
 * generates random class
 *
 * @author (Pooja)
 * @version (1)
 */
public class RandomGoalsGenerator
{
    private double min;
    private double max;

    /**
     * default constructor
     */
    RandomGoalsGenerator()
    {
        min = 0;
        max = 0;
    }

    /**
     * non default constructor
     */
    RandomGoalsGenerator(double minimum,double maximum)
    {
        min = minimum;
        max = maximum;
    }

    /**
     * getter fo min
     */
    public double getMin()
    {
        return min;
    }

    /**
     * getter for max
     */
    public double getMax()
    {
        return max;
    }

    /**
     * generates random number
     */
    public double randomNumber()
    {
        double number = getMin() + (Math.random() * ((getMax() - getMin())+1));
        if (number > getMax())
        {
            number = Math.floor(number);
        }
        return number;
    }

    /**
     * setter for min
     */
    public void setMin(double newMin)
    {
        min = newMin;
    }

    /**
     * setter for max
     */
    public void setMax(double newMax)
    {
        max = newMax;
    }
}