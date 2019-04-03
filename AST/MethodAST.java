
class MethodAST extends SimpleMethods implements AST{
    ArgdeclsAST arglist;
    OptionalsemiAST semi;
    FielddeclsAST fields;
    StatementlistAST statelist;
    public MethodAST(ArgdeclsAST arglist, FielddeclsAST fields, StatementlistAST sl, OptionalsemiAST sem){
        this.semi = sem;
        this.arglist = arglist;
        this.fields = fields;
        this.statelist = sl;
    }

    public String toString(){
        return("" + String.format("( %s ) { %s %s }%s", this.arglist, this.fields, this.statelist,  this.semi));
    }

    public String toString(int indent){
        return(""
                + String.format("( %s ) {\n", this.arglist)
                + String.format("%s", this.fields.toString(indent+1))
                + String.format("%s", this.statelist.toString(indent+1))
                + getBase(indent) + String.format("}%s",this.semi)
                );
    }
}
