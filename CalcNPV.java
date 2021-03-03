import java.text.DecimalFormat;
import java.util.Scanner;
import java.lang.Math;
import java.lang.Double;

public class CalcNPV
{	
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.####");
		boolean isDone = false;
		while(!isDone)
		{
			int discountPercent = 0, lifetime = 0;
			double PVF = 0, d2 = 0, discountRate = 0, investment = 0, salvageValue = 0, cashFlow = 0, NPV = 0;
			String s = "";
		
			System.out.print("Initial Investment: ");
			investment = scan.nextDouble();
			System.out.print("Estimated lifetime: ");
			lifetime = scan.nextInt();
			System.out.print("Estimated Salvage Value: ");
			salvageValue = scan.nextDouble();
			System.out.print("Discount/Return Rate(%): ");
			discountPercent = scan.nextInt();
			discountRate = (double) discountPercent / 100;
		
		
			for(int i = 1; i<= lifetime; ++i)
			{
				System.out.print("Estimated cash flow for period " + i + ": ");
				cashFlow = scan.nextDouble();
			
				if(i == lifetime)
				{
					cashFlow += salvageValue;
				}
			
				PVF = 1 / Math.pow((1 + discountRate), i);
				s = df.format(PVF);
				d2 = Double.parseDouble(s);
				NPV += cashFlow * d2;
			}
		
			NPV -= investment;
			System.out.println("Net Present Value: " + NPV);
			System.out.println();
			System.out.print("1. Continue\n");
			System.out.print("2. Quit\n");
			System.out.print("Input: ");
			int choice = scan.nextInt();
			
			if(choice == 1)
			{
				isDone = false;
				System.out.println();
			}
			else if(choice == 2)
			{
				isDone = true;
			}
			else
			{
				System.out.println("ERROR: Unsupported Input(s)");
				isDone = true;
			}
		}
		
		scan.close();
	}
}