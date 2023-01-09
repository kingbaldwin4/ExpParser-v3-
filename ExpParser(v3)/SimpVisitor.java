    import java.util.HashMap;
    class SimpVisitor implements Visitor 
  {
    HashMap<String, Integer> m = new HashMap();

    public Object visit(Exp e) 
  {
    m.put("tamSayi",0);		
    return e.accept(this);
  }
	
    public Object visit(Plus e) 
  {
    Exp a = (Exp)e.e1.accept(this);
    Exp b = (Exp)e.e2.accept(this);
    return new Plus(a,b);
  }
  
    public Object visit(Minus e) 
  {
    Exp a = (Exp)(e.e1.accept(this));
    Exp b = (Exp)(e.e2.accept(this));
    return new Minus(a,b);
  }
  
    public Object visit(Times e) 
  {
    Exp a = (Exp)(e.e1.accept(this));
    Exp b = (Exp)(e.e2.accept(this));

    if(a instanceof Num &&  b instanceof Num )
  {
    int sayi1=((Num)a).n;
    int sayi2=((Num)b).n;
    return new Num(sayi1*sayi2);
  }
	
    else if(a instanceof Times && b instanceof Num)
  {
    int sayi2=((Num)b).n;
    if(((Times)a).e1 instanceof Num && ((Times)a).e2 instanceof ID )
  {
    sayi2=sayi2*((Num)((Times)a).e1).n;
    return new Times(new Num(sayi2),new ID("x"));
  }
		
    else if(((Times)a).e2 instanceof Num && ((Times)a).e1 instanceof ID )
  {
    sayi2=sayi2*((Num)((Times)a).e2).n;
    return new Times(new Num(sayi2),new ID("x"));
  }

    else if(((Times)a).e1 instanceof Times && ((Times)a).e2 instanceof Num )
  {
    sayi2=sayi2*((Num)((Times)a).e2).n;
    return new Times(new Num(sayi2),((Times)a).e1);
  }

    else if(((Times)a).e1 instanceof Num && ((Times)a).e2 instanceof Times )
  {				
    sayi2=sayi2*((Num)((Times)a).e1).n;
    return new Times(new Num(sayi2),((Times)a).e2);
  }

    else if(((Times)a).e1 instanceof Num && ((Times)a).e2 instanceof Power )
  {				
    sayi2=sayi2*((Num)((Times)a).e1).n;
    return new Times(new Num(sayi2),((Times)a).e2);
  }

    else if(((Times)a).e1 instanceof Power && ((Times)a).e2 instanceof Num )
  {
    sayi2=sayi2*((Num)((Times)a).e2).n;
    return new Times(new Num(sayi2),((Times)a).e1);
  }
					
    else
  {
    System.out.println(a);
    return new Times(a,new Num(sayi2));
  }
  }
	
    else
  {
    return new Times(a,b);
  }
  }

    public Object visit(Power e) 
  {
    Exp a = (Exp)(e.e1.accept(this));
    Exp b = (Exp)(e.e2.accept(this));
    
    if(a instanceof Num &&  b instanceof Num )
  {
    int sayi1=((Num)a).n;
    int sayi2=((Num)b).n;
    return new Num((int)Math.pow(sayi1,sayi2));
  }	

    else if(a instanceof ID &&  b instanceof Num )
  {	
    int sayi2=((Num)b).n;
    if(sayi2==0)
  {
    return new Num(1);
  }

    else if(sayi2==1)	
  {
    return new ID("x");
  }	

    else
  {
    return new Power(new ID("x"),new Num(sayi2));
  }
  }

    else
  {
    return null;
  }
  }
  
    public Object visit(ID e) 
  {
    return e ;
  }
  
    public Object visit(Num e) 
  {
    return e;
  }			
  }