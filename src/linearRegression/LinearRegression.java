package linearRegression;

public class LinearRegression {

    private double slope;
    private double intercept;

    public double getAverage(double[] yArray) {
        double sum = 0;
        for (int index = 0; index < yArray.length; index++) sum += yArray[index];
        return sum / yArray.length;
    }

    public double[] subtractMean(double[] array, double average) {
        double[] newArray = new double[array.length];
        for (int index = 0; index < array.length; index++) {
            newArray[index] = array[index] - average;
        }
        return newArray;
    }

    public double diffMeanSquared(double[] array, double average) {
        double[] newArray = new double[array.length];
        double sum = 0;
        for (int index = 0; index < array.length; index++) {
            double temp = array[index] - average;
            newArray[index] = Math.pow(temp, 2);
            sum += newArray[index];
        }
        return sum;
    }

    public double sumSubtractMeanXY(double[] xArray, double[] yArray) {
        double xAverage = getAverage(xArray);
        double yAverage = getAverage(yArray);
        double[] x = subtractMean(xArray, xAverage);
        double[] y = subtractMean(yArray, yAverage);
        double sum = 0;

        for (int index = 0; index < xArray.length; index++) {
            sum += x[index] * y[index];
        }

        return sum;
    }

    private void slope(double[] xArray, double[] yArray) {
        double xAverage = getAverage(xArray);

        double numerator = sumSubtractMeanXY(xArray, yArray);
        double denominator = diffMeanSquared(xArray, xAverage);
        slope = numerator / denominator;
    }

    private void intercept(double[] xArray, double[] yArray) {
        double xAverage = getAverage(xArray);
        double yAverage = getAverage(yArray);

        intercept = yAverage - slope * xAverage;
    }

    public double predict(double x, double[] xArray, double[] yArray) {

        slope(xArray, yArray);
        intercept(xArray, yArray);
        double prediction;
        prediction = intercept + (slope * x);


        return prediction;
    }
}