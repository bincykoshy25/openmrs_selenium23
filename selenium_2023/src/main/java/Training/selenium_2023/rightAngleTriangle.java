package Training.selenium_2023;

public class rightAngleTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1; i<10; i++)
		{
			{
				if(i%2!=0)
				{
					for(int j=1; j<=i; j++)
					{
						System.out.print("*");
					}
					System.out.println();
				}
			}
		}
	}
}