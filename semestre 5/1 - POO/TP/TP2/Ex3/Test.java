public class Test
{
	public static void main(String[] args)
	{
		Constante a = new Constante (5);
		Constante b = new Constante (2);
		Constante c = new Constante (3);
		ExpressionComplexe e1 = new ExpressionComplexe (a, '+', b);
		ExpressionComplexe e2 = new ExpressionComplexe (e1, '*', c);
		ExpressionComplexe e3 = new ExpressionComplexe (new Constante(4), '*', e2);
		System.out.println(a.evaluer());
		System.out.println(e1.evaluer());
		System.out.println(e2.evaluer());
		System.out.println(e3.evaluer());
	}
}
