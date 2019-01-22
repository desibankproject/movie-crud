package oppo;

public class EffectiveFinalVariable {
	
	public static void main(String[] args) {
		final int x=100;
		//Local variable oo defined in an enclosing scope must be final or effectively final
		int oo=200;
		//oo=90;
		//Local anonymous classs
		Runnable runnable=()->System.out.println("x  = "+x);
	
	}
}
