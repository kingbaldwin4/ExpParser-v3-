    interface Visitor 
  {
    public Object visit(Exp e);
    public Object visit(Plus e);
    public Object visit(Minus e);
    public Object visit(Times e); 
    public Object visit(Power e);
    public Object visit(ID e);
    public Object visit(Num e);
  }
