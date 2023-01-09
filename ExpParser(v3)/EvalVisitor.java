    import java.util.HashMap;
    class EvalVisitor implements Visitor 
{
	
    HashMap<String, Integer> m = new HashMap();

    public Object visit(Exp e) 
  {
    m.put("tamSayi",0);		
    Object a=e.accept(this);

    if(a instanceof  Num)
  {
    System.out.println(((Num)e).n);
  }

    else if(a instanceof Times)
  {
    int katSayi=((Num)((Times)a).e1).n;
    int us =((Num)((Power)((Times)a).e2).e2).n;
		
    System.out.println(katSayi +"x^"+us);
  }
		
    else if(a instanceof ID)
  {			
    int katSayi=((Num)((Times)a).e1).n;
    System.out.println(katSayi +"x^");			 
  }

    else if(a instanceof Power)
  {					
    int us =((Num)  ((Power)a).e2).n;		
    System.out.println( "x^"+us);			 
  }
		
    else
  {
    int durum=0;
    if(m.get("tamSayi")==0)
  {
    m.remove("tamSayi");
  }

    for (Object objectName : m.keySet()) 
  {				
    if(objectName!="tamSayi" && m.get(objectName)<0) 
  {
    if(m.get(objectName)!=-1)
  {
    System.out.print(m.get(objectName));
    System.out.print(objectName);
  }

    else
  {
    System.out.print("-"+objectName); 							  
  }
  }

    if(objectName!="tamSayi" && m.get(objectName)>0 && durum!=0) 
  {
    if(m.get(objectName)!=1)
  {
    System.out.print("+"+m.get(objectName));
    System.out.print(objectName);
  }

    else
  {
    System.out.print("+"+objectName); 							  
  }
  }

    if(objectName!="tamSayi" && m.get(objectName)>0 && durum==0) 
  {
    if(m.get(objectName)!=1)
  {
    System.out.print(m.get(objectName));
    System.out.print(objectName);
  }

    else
  {
    System.out.print(objectName); 
  }
  }

    if(objectName=="tamSayi" && m.get(objectName)<0) 
  {
    System.out.print( m.get(objectName));					
  }

    if(objectName=="tamSayi" && m.get(objectName)>0 && durum!=0) 
  {
    System.out.print("+" + m.get(objectName));					
  }

    if(objectName=="tamSayi" && m.get(objectName)>0 && durum==0)
  {
    System.out.print( m.get(objectName));					
  }				
    durum=1;					
  }				   
  }
    return null;
  }
   
    public Object visit(Plus e)
  {
    Object  a = e.e1.accept(this);
    Object  b = e.e2.accept(this);
    int tamSayi;
    int katSayi;
    int us;	

    if( a instanceof Times)
  {
    if(((Times)a).e2 instanceof Num)
  {
    int x1=((Num)((Times)a).e1).n;
    int x2=((Num)((Times)a).e2).n;
    int value=m.get("tamSayi") + x1*x2;
    m.put("tamSayi",value);
  }  
  }
	
    if( a instanceof Power)
  {			
    us =((Num)((Power)a).e2).n;
    String key="x^"+Integer.toString(us);
			
    if(us!=0)
  {
    if(m.get(key)!=null)
  {
    int value=m.get(key) + 1;
    m.put(key,value);
  }

    else
  {
    m.put(key,1);
  }
  }
    else
  {
    int value=m.get("tamSayi") + 1;
    m.put("tamSayi",value);
  }			
  }
    if( b instanceof Power)
  {		
    us =((Num)((Power)b).e2).n;
    String key="x^"+Integer.toString(us);

    if(us!=0)
  {
    if(m.get(key)!=null)
  {
    int value=m.get(key) + 1;
    m.put(key,value);
  }

    else
  {
    m.put(key,1);
  }
  }

    else
  {
    int value=m.get("tamSayi") + 1;
    m.put("tamSayi",value);
  }			 
  }
	
    if(a instanceof Times && ((Times)a).e2 instanceof ID)
  {	
    katSayi=((Num)((Times)a).e1).n;
    if(m.get("x")!=null)
  {
    int value=m.get("x") + katSayi;
    m.put("x",value);
  }

    else
  {
    m.put("x",katSayi);
  }		
  }

    if(b instanceof Times && ((Times)b).e2 instanceof ID)
  {		
    katSayi=((Num)((Times)b).e1).n;		
    if(m.get("x")!=null)
  {
    int value=m.get("x") + katSayi;
    m.put("x",value);
  }

    else
  {
    m.put("x",katSayi);
  }		
  }
	
    if(a instanceof Times && ((Times)a).e2 instanceof Power)
  {
    katSayi=((Num)((Times)a).e1).n;
    us =((Num)((Power)((Times)a).e2).e2).n;
    String key="x^"+Integer.toString(us);
	
    if(us!=0)
  {
    if(m.get(key)!=null)
  {	
    int value=m.get(key) + katSayi;
    m.put(key,value);
  }

    else
  { 		
    m.put(key,katSayi);
  }
  }

    else
  {
    int value=m.get("tamSayi") + katSayi;
    m.put("tamSayi",value);		
  }	
  }

    if(b instanceof Times && ((Times)b).e2 instanceof Power)
  {
    katSayi = ((Num)((Times)b).e1).n;	
    us = ((Num)((Power)((Times)b).e2).e2).n;
    String key="x^"+Integer.toString(us);

    if(us!=0)
  {
    if(m.get(key)!=null)
  {
    int value=m.get(key) + katSayi;
    m.put(key,value);
  }

    else
  { 		
    m.put(key,katSayi);
  }
  }

    else
  {
    int value=m.get("tamSayi") + katSayi;
    m.put("tamSayi",value);		
  }	
  }

    if(a instanceof Num )
  {	
    tamSayi=((Num)a).n;
    String key="tamSayi";
    
    if(m.get(key)!=null)
  {
    int value=m.get(key) + tamSayi;
    m.put(key,value);
  }	 
  }

    if(b instanceof Num )
  {
    tamSayi=((Num)b).n;
    String key="tamSayi";

    if(m.get(key)!=null)
  {
    int value=m.get(key) + tamSayi;
    m.put(key,value);
  }	
  }

    if(a instanceof ID)
  {	
    if(m.get("x")!=null)
  {
    int value=m.get("x") + 1;
    m.put("x",value);
  }

    else
  {
    m.put("x",1);
  }
  }

    if(b instanceof ID)
  {
    if(m.get("x")!=null)
  {	
    int value=m.get("x") + 1;
    m.put("x",value);
  }

    else
  {
    m.put("x",1);
  }
  }	
    return  null; 
  }

    public Object visit(Minus e) 
  {
    Object  a = e.e1.accept(this);
    Object  b = e.e2.accept(this);
    int tamSayi;
    int katSayi;
    int us;

    if( a instanceof Times)
  {
    if(((Times)a).e2 instanceof Num)
  {
    int x1=((Num)((Times)a).e1).n;
    int x2=((Num)((Times)a).e2).n;
    int value=m.get("tamSayi") + x1*x2;
    m.put("tamSayi",value);
  }		  
  }
	
    if( a instanceof Power)
  {		
    us =((Num)((Power)a).e2).n;
    String key="x^"+Integer.toString(us);
			
    if(us!=0)
  {
    if(m.get(key)!=null)
  {
    int value=m.get(key) + 1;
    m.put(key,value);
  }

    else
  {
    m.put(key,1);
  }
  }

    else
  {
    int value=m.get("tamSayi") + 1;
    m.put("tamSayi",value);
  }			
  }

    if( b instanceof Power)
  {			
    us =((Num)((Power)b).e2).n;
    String key="x^"+Integer.toString(us);

    if(us!=0)
  {
    if(m.get(key)!=null)
  {	
    int value=m.get(key) - 1;
    m.put(key,value);
  }

    else
  {
    m.put(key,-1);
  }
  }

    else
  {
    int value=m.get("tamSayi") - 1;
    m.put("tamSayi",value);
  }						 
  }

    if(a instanceof Times && ((Times)a).e2 instanceof ID)
  {	
    katSayi=((Num)((Times)a).e1).n;
		
    if(m.get("x")!=null)
  {
    int value=m.get("x") + katSayi;
    m.put("x",value);
  }

    else
  {
    m.put("x",katSayi);
  }		
  }

    if(b instanceof Times && ((Times)b).e2 instanceof ID)
  {	
    katSayi=((Num)((Times)b).e1).n;  
    if(m.get("x")!=null)		
  {
    int value=m.get("x") - katSayi;
    m.put("x",value);
  }

    else
  {
    m.put("x",0 - katSayi);
  }		
  }
	
    if(a instanceof Times && ((Times)a).e2 instanceof Power)
  {
    katSayi=((Num)((Times)a).e1).n;
    us =((Num)((Power)((Times)a).e2).e2).n;
    String key="x^"+Integer.toString(us);
	
    if(us!=0)
  {
    if(m.get(key)!=null)
  {	
    int value=m.get(key) + katSayi;
    m.put(key,value);
  }

    else
  { 	
    m.put(key,katSayi);
  }
  }

    else
  {
    int value=m.get("tamSayi") + katSayi;
    m.put("tamSayi",value);		
  }	
  }

    if(b instanceof Times && ((Times)b).e2 instanceof Power)
  {
    katSayi = ((Num)((Times)b).e1).n;	
    us = ((Num)((Power)((Times)b).e2).e2).n;
    String key="x^"+Integer.toString(us);
		
    if(us!=0)
  {
    if(m.get(key)!=null)
  {
    int value=m.get(key) - katSayi;
    m.put(key,value);
  }

    else
  { 					
    m.put(key,0-katSayi);
  }
  }

    else
  {
    int value=m.get("tamSayi") - katSayi;
    m.put("tamSayi",value);				
  }
  }

    if(a instanceof Num)
  {	
    tamSayi=((Num)a).n;
    String key="tamSayi";
    
    if(m.get(key)!=null)
  {
    int value=m.get(key) + tamSayi;
    m.put(key,value);
  }	 
  }

    if(b instanceof Num)
  {
    tamSayi=((Num)b).n;
    String key="tamSayi";

    if(m.get(key)!=null)
  {
    int value=m.get(key) - tamSayi;
    m.put(key,value);
  }	
  }

    if(a instanceof ID)
  {	
    if(m.get("x")!=null)		
  {	
    int value=m.get("x") + 1;
    m.put("x",value);
  }

    else
  {
    m.put("x",1);
  }
  }

    if(b instanceof ID)
  {
    if(m.get("x")!=null)
  {	
    int value=m.get("x") - 1;
    m.put("x",value);
  }

    else
  {
    m.put("x",-1);
  }
  }
    return  null;		
  }

  public Object visit(Times e) {

    Object  a = e.e1.accept(this);
    Object  b = e.e2.accept(this);
    return e;	
  }

  public Object visit(Power e) {

    Object a = e.e1.accept(this);
    Object b = e.e2.accept(this);
    return e;
	
  }
 
  public Object visit(Num e) {
    return e;
  }
  public Object visit(ID e) {
    return e;
  }
	
}