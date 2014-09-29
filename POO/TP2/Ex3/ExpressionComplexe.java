public class ExpressionComplexe extends Expression
{
	private Expression a;
	private Expression b;
	private char op;
	public float evaluer()
	{
		switch (op)
		{
			case '+' :
				return a.evaluer() + b.evaluer();
			case '-' :
				return a.evaluer() - b.evaluer();
			case '/' :
				return a.evaluer() / b.evaluer();
			case '*' :
				return a.evaluer() * b.evaluer();
			default :
				System.out.println("Erreur sur l'opérateur");
				return 0;
		}
	}
	public ExpressionComplexe(Expression a, char op, Expression b)
	{
		this.a = a;
		this.b = b;
		this.op = op;
	}
}
