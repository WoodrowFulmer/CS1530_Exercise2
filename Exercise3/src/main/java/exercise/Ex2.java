package exercise;
public class Ex2
{
	public static int lazy(int in)
	{
		return (int)((Math.pow(in,2) + in + 2) / 2);
	}
	
	public static int triangle(int in)
	{
		if(in == 1)
			return in;
		else
			return in + triangle(in - 1);
	}
	
	public static void main(String[] args)
	{
		if(args.length < 2)
		{
			System.out.println("Please enter 2 arguments");
			System.exit(1);
		}
		int x = 0;
		try 
		{
			x = Integer.parseInt(args[1]);
		} catch (NumberFormatException ex) 
		{
			System.out.println("Argument 2: should be an integer");
			System.exit(2);
		}
		
		if(args[0].toLowerCase().equals("lazy"))
		{
			System.out.print("Lazy(" + x + ") = ");
			x = lazy(x);
		}
		else if(args[0].toLowerCase().equals("triangle"))
		{
			System.out.print("Tri(" + x + ") = ");
			x = triangle(x);
		}
		else
		{
			System.out.println("Argument 1: should be 'lazy' or 'triangle'");
			System.exit(1);
		}
		System.out.println(x);
	}
}