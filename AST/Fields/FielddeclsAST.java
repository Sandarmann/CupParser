class FielddeclsAST extends SimpleMethods implements AST{
    OptionalfinalAST fin;
    FieldAST field;
    FielddeclsAST field_decls;
    TypeAST type;
    IdentAST ident;
    int indent;
    public FielddeclsAST(){}

    public FielddeclsAST( FieldAST field, FielddeclsAST decls){
        this.field = field;
        this.field_decls= decls;
    }

    public FielddeclsAST(OptionalfinalAST fin, TypeAST type, IdentAST id, FieldAST field, FielddeclsAST decls){
        this.fin = fin;
        this.type = type;
        this.ident = id;
        this.field = field;
        this.field_decls= decls;
    }


    public void accept(Visitor v){
        if(this.field != null){
            this.fin.accept(v);
            this.type.accept(v);
            this.field.accept(v);
            v.visit(this);
        }
        if(this.field_decls != null)
            this.field_decls.accept(v);
    }

    public String toString(){
        if(this.field_decls == null){
            return "";
        }
        return("" + String.format("%s%s %s %s\n%s", this.fin, this.type, this.ident, this.field, this.field_decls));
    }

    public String toString(int indent){
        if(this.field_decls == null){
            return "";
        }
        String field = "";
        if(this.field != null){
            field = this.field.toString();
        }
        return("" + String.format("%s", this.field_decls.toString(indent))
                + getBase(indent) + String.format("%s%s %s %s\n", this.fin, this.type, this.ident, field));

    }
}