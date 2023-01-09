
    class PrintVisitor implements Visitor 
{	
    double x = 0;
    public PrintVisitor(double a)
  {
    x = a;
  }

    public Object visit(Exp e) {
    return e.accept(this);
  }

    public Object visit(Plus e) 
  {
    String a = (String)e.e1.accept(this);
    String b = (String)e.e2.accept(this);
    System.out.println("plus");
    System.out.print("a------>");System.out.println(a);
    System.out.print("b------>");System.out.println(b);
    return a + "+" +b;
  }

    public Object visit(Minus e) 
  {
    String a = (String)(e.e1.accept(this));
    String b = (String)(e.e2.accept(this));
    System.out.println("minus");
    System.out.print("a------>");System.out.println(a);
    System.out.print("b------>");System.out.println(b);
    return a + "-("+ b +")";
  }

    public Object visit(Times e) 
  {
    String a = (String)(e.e1.accept(this));
    String b = (String)(e.e2.accept(this));
    System.out.println("Times");
    System.out.print("a------>");System.out.println(a);
    System.out.print("b------>");System.out.println(b);	
    return "(" + a + ")*(" +b +")";
  }

    public Object visit(Power e) 
  {
    String a = (String)(e.e1.accept(this));
    String b = (String)(e.e2.accept(this));
    System.out.println("Power");
    System.out.print("a------>");System.out.println(a);
    System.out.print("b------>");System.out.println(b);

    return "("+ a + ")^(" + b + ")";
  }
 
    public Object visit(ID e) 
  {
    return  "x";
  }

    public Object visit(Num e) 
  {
    return ""+e.n;
  }
}