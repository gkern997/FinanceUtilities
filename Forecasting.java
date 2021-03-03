public class Forecasting
{
	private static double simpleMovingAvg(double pastSales[])
	{
		int i;
		double totalPastSales = 0;
		
		for(i = 0; i < pastSales.length; ++i)
		{
			totalPastSales += pastSales[i];
		}
		
		return totalPastSales / pastSales.length;
	}
	
	private static double weightedMovingAvg(int weights[], double pastSales[]) throws IllegalArgumentException
	{
		double weightAvg = 0;
		int i, weightSum = 0;
		
		for(i = 0; i < weights.length; ++i)
		{
			weightSum += weights[i];
		}
		
		if(weightSum != 100)
		{
			throw new IllegalArgumentException("Weight Percentages Do Not Summate To 100\n");
		}
		
		for(i = 0; i < pastSales.length; ++i)
		{
			weightAvg += ( (double) weights[i] / 100) * pastSales[i];
		}
		
		return weightAvg;
	}
	
	private static double expSmoothNoTrend(double priorForecast, double priorDemand, double a)
	{
		//TODO
		return 0;
	}
	
	private static double expSmoothTrend(double priorTrendForecast, double a, double priorDemand, double priorTrend, double d)
	{
		//TODO
		return 0;
	}
	
	public static void main(String args[])
	{
		// TODO: Loop to parse user inputs
		
		double sales1[] = {800, 1400, 1000}; // Values taken from slides
		double sales2[] = {95, 105, 90, 100}; // Most Recent period first
		int weights[] = {40, 30, 20, 10};
		System.out.println("Simple 3 Week Moving Average: " + simpleMovingAvg(sales1));
		System.out.println("4 Month Weighted Moving Average: " + weightedMovingAvg(weights, sales2));
	}
}