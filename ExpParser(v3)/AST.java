    abstract class Exp 
  {
    public abstract Object accept(Visitor v);
  }

    class YeniExp extends Exp
  {
    Exp e1,e2;
    public YeniExp(Exp a, Exp b)
  {	
    e1=a;
    e2=b;
  }

    public Object accept(Visitor v) 
  {
    return v.visit(this);
  }
  }

    class Plus extends Exp
  {
    Exp e1,e2;	
    public Plus(Exp a, Exp b)
  {	
    e1=a;
    e2=b;	
  }

    public String toString()
  {
    return "Plus(" +e1+","+e2+")";
  }

    public Object accept(Visitor v) 
  {
    return v.visit(this);
  }	
  }

    class Minus extends Exp
  {
    Exp e1,e2;
    public Minus(Exp a, Exp b)
  {	
    e1=a;
    e2=b;	
  }

    public String toString()
  {
    return "Minus(" +e1+","+e2+")";
  }

    public Object accept(Visitor v) 
  {
    return v.visit(this);
  }	
  }

    class Times extends Exp
  {
    Exp e1,e2;
    public Times(Exp a, Exp b)
  {	
    e1=a;
    e2=b;	
  }

    public String toString()
  {
    return "Times(" +e1+","+e2+")";
  }

    public Object accept(Visitor v) 
  {
    return v.visit(this);
  }	
  }

    class Power extends Exp
  {
    Exp e1,e2;
    public Power(Exp a, Exp b)
  {	
    e1=a;
    e2=b;	
  }

    public String toString()
  {
    return "Power(" +e1+","+e2+")";
  }

    public Object accept(Visitor v) 
  {
    return v.visit(this);
  }	
  }

    class ID extends Exp
  {
    String id;
	
    public ID(String a)
  {	
    id=a;	
  }
	
    public String toString()
  {
    return "ID(" +id+")";
  }

    public Object accept(Visitor v) 
  {
    return v.visit(this);
  }	
  }

    class Num extends Exp
  {
    int n;

    public Num(int a)
  {		
    n=a;
  }

    public String toString()
  {
    return "Num(" +n+")";
  }
	
    public Object accept(Visitor v) 
  {
    return v.visit(this);
  }
  }
