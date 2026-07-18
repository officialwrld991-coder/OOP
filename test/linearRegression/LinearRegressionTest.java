package linearRegression;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LinearRegressionTest {

    @Test
    public void testThatIEnterAnArrayOfNumbers_IGetAverage() {
        LinearRegression myLinearRegression = new LinearRegression();
        double[] Y = {2, 4, 6, 8, 10};
        double result = myLinearRegression.getAverage(Y);
        assertEquals(6, result);
    }


    @Test
    public void testThatIEnterAnArrayOfNumber_IGetArrayOfMeanMinusEachElement () {
        LinearRegression myLinearRegression = new LinearRegression();
        double[] yArray = {2, 4, 6, 8, 10};
        double[] expected = {-4, -2, 0, 2, 4};
        double average = myLinearRegression.getAverage(yArray);
        double[] result = myLinearRegression.subtractMean(yArray, average);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testThatIEnterTwoArraysOfNumber_IGetAnArrayOfTheSumOfMeanMinusEachElementPerIndex () {
        LinearRegression myLinearRegression = new LinearRegression();
        double[] xArray = {1, 3, 5, 7, 9};
        double[] yArray = {2, 4, 6, 8, 10};
        double result = myLinearRegression.sumSubtractMeanXY(xArray, yArray);
        assertEquals(40, result);
    }

    @Test
    public void testThatIEnterAnArrayOfNumber_IGetArrayOfMeanMinusEachElementSquared () {
        LinearRegression myLinearRegression = new LinearRegression();
        double[] yArray = {2, 4, 6, 8, 10};
        double expected = 40;
        double average = myLinearRegression.getAverage(yArray);
        double result = myLinearRegression.diffMeanSquared(yArray, average);
        assertEquals(expected, result);
    }


    @Test
    public void testThatIEnterTwoArraysOfNumber_IGetTheSlope() {
        LinearRegression myLinearRegression = new LinearRegression();
        double[] xArray = {1, 3, 5, 7, 9};
        double[] yArray = {2, 4, 6, 8, 10};

        double xAverage = myLinearRegression.getAverage(xArray);

        double numerator = myLinearRegression.sumSubtractMeanXY(xArray, yArray);
        double denominator = myLinearRegression.diffMeanSquared(xArray, xAverage);

        double slope = numerator/denominator;
        assertEquals(1, slope);
    }

    @Test
    public void testThatIEnterTwoArraysOfNumber_IGetTheIntercept() {
        LinearRegression myLinearRegression = new LinearRegression();
        double[] xArray = {1, 3, 5, 7, 9};
        double[] yArray = {2, 4, 6, 8, 10};

        double numerator = myLinearRegression.sumSubtractMeanXY(xArray, yArray);
        double denominator = myLinearRegression.diffMeanSquared(xArray, myLinearRegression.getAverage(xArray));
        double slope = numerator/denominator;
        double intercept = myLinearRegression.getAverage(yArray) - slope * myLinearRegression.getAverage(xArray);
        assertEquals(1, intercept);
    }
}