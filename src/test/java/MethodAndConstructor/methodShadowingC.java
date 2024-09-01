package MethodAndConstructor;

public class methodShadowingC extends methodShadowingP
{
	public static void m1()
	{
		System.out.println("This is child m1");
	}
	
	public static void main(String[] args)
	{
		methodShadowingC obj = new methodShadowingC();
		obj.m1();
	}
	
}
