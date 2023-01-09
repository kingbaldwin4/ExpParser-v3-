    import  java.util.*;

    class SymTable
  {
    Hashtable table;
    public SymTable()
  {
    table=new Hashtable();
  }
	
    public void put(String id, Object o)
  {		 
    table.put(id,o); 
  }
	 
    public Object get(String id)
  {
    return table.get(id); 
  }		
  }