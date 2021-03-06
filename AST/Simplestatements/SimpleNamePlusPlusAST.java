class SimpleNamePlusPlusAST extends SimplestateAST implements AST{
    public NameAST name;
    public SimpleNamePlusPlusAST(NameAST n){
        this.name = n;
    }

    public void accept(Visitor v){
        this.name.accept(v);
        v.visit(this);
    }

    public String toString(){
        return(""+ String.format("%s ++",this.name));
    }

    public String toString(int indent){
        return(getBase(indent)+ String.format("%s ++;", this.name));
    }
    public String getType(Visitor e) throws TypeConflictException{
        if(this.name.getType(e).equals("float") || this.name.getType(e).equals("int")){
            //return this.name.getType(e);
            return "";
        }
        throw new TypeConflictException(String.format(
            "Cannot ++ type %s", this.name.getType(e)
        ));
    }
    public Object getValue(Visitor v){
        SymTableEntry e = v.lookup(this.name.id.name);
        if(e.type.type.equals("int"))
            v.updateEntry(this.name.id.name, ((Integer) e.type.getValue())+1);
        else
            v.updateEntry(this.name.id.name, ((Float) e.type.getValue())+1);
        return null;
    }
}
