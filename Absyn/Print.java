package Absyn;

public class Print {

    java.io.PrintWriter out;

    public Print(java.io.PrintWriter o) {
        out = o;
    }

    void indent(int d) {
        for (int i = 0; i < d; i++)
            out.print(' ');
    }

    void say(String s) {
        out.print(s);
    }

    void say(int i) {
        out.print(i);
    }

    void say(boolean b) {
        out.print(b);
    }

    void sayln(String s) {
        out.println(s);
    }


    // Expression Prints
    public void prExp(Exp e, int d) {
        if (e instanceof ArgExpList) prExp((ArgExpList) e, d);
        else if (e instanceof ArrayExp) prExp((ArrayExp) e, d);
        else if (e instanceof AssignExp) prExp((AssignExp) e, d);
        else if (e instanceof BreakExp) prExp((BreakExp) e, d);
        else if (e instanceof CallExp) prExp((CallExp) e, d);
        else if (e instanceof CompoundStmt) prExp((CompoundStmt) e, d);
        else if (e instanceof DecList) prExp((DecList) e, d);
        else if (e instanceof ExpressionStmt) prExp((ExpressionStmt) e, d);
        else if (e instanceof ForStmt) prExp((ForStmt) e, d);
        else if (e instanceof IfExp) prExp((IfExp) e, d);
        else if (e instanceof InitializerList) prExp((InitializerList) e, d);
        else if (e instanceof IntExp) prExp((IntExp) e, d);
        else if (e instanceof IterationStmt) prExp((IterationStmt) e, d);
        else if (e instanceof JumpStmt) prExp((JumpStmt) e, d);
        else if (e instanceof LetExp) prExp((LetExp) e, d);
        else if (e instanceof NilExp) prExp((NilExp) e, d);
        else if (e instanceof OpExp) prExp((OpExp) e, d);
        else if (e instanceof PostfixExp) prExp((PostfixExp) e, d);
        else if (e instanceof PostfixExpLs) prExp((PostfixExpLs) e, d);
        else if (e instanceof RecordExp) prExp((RecordExp) e, d);
        else if (e instanceof SelectionStmt) prExp((SelectionStmt) e, d);
        else if (e instanceof SeqExp) prExp((SeqExp) e, d);
        else if (e instanceof SizeOfExp) prExp((SizeOfExp) e, d);
        else if (e instanceof StmtList) prExp((StmtList) e, d);
        else if (e instanceof StringExp) prExp((StringExp) e, d);
        else if (e instanceof StructExp) prExp((StructExp) e, d);
        else if (e instanceof UnaryExp) prExp((UnaryExp) e, d);
        else if (e instanceof VarExp) prExp((VarExp) e, d);
        else if (e instanceof WhileExp) prExp((WhileExp) e, d);
        else throw new Error("Print.prExp: " + e.getClass());
    }

    // Statement Types
    public void prStmt(Statement s, int d) {
        if (s instanceof CompoundStmt) {
            prExp((CompoundStmt) s, d);
        } else if (s instanceof StmtList) {
            prStmtList((StmtList) s, d);
        } else if (s instanceof JumpStmt) {
            prExp((JumpStmt) s, d);
        } else if (s instanceof SelectionStmt) {
            prExp((SelectionStmt) s, d);
        } else if (s instanceof ForStmt){
            prExp((ForStmt) s, d);
        } else if (s instanceof ExpressionStmt) {
            prExp((ExpressionStmt) s, d);
        } else if(s instanceof IterationStmt) {
            prExp((IterationStmt) s, d);
        }
          else {
            throw new Error("Print.prStmt: Unknown statement type " + s.getClass());
        }
    }

    // Iteration Types
    public void prExp(IterationStmt e, int d) {
        indent(d);
        sayln("IterationStmt(");
        if (e instanceof WhileStmt) {
            prExp((WhileStmt) e, d + 1);
        }
        else if (e instanceof  DoWhileStmt) {
            prExp((DoWhileStmt) e, d + 1);
        }
        else if (e instanceof ForStmt) {
            prExp((ForStmt) e, d + 1);
        }
        say(")");
    }

    // Expression Prints
    void prExp(ArgExpList e, int d) {
        indent(d);
        sayln("ArgExpList(");
        if (e.exp1 != null) {
            prExp(e.exp1, d + 1);
        }
        if (e.exp2 != null) {
            sayln(",");
            prExp(e.exp2, d + 1);
        }
        say(")");
    }

    void prExp(ArrayExp e, int d) {
        indent(d);
        say("ArrayExp(");
        say(e.typ.toString());
        sayln(",");
        prExp(e.size, d + 1);
        sayln(",");
        prExp(e.init, d + 1);
        say(")");
    }

    void prExp(AssignExp e, int d) {
        indent(d);
        sayln("AssignExp(");
        prExp(e.var, d + 1);
        sayln(","); /*changed from prVar to that */
        prExp(e.exp, d + 1);
        say(")");
    }

    void prExp(BreakExp e, int d) {
        indent(d);
        say("BreakExp()");
    }

    void prExp(CallExp e, int d) {
        indent(d);
        say("CallExp(");
        say(e.func.toString());
        sayln(",");
        prExplist(e.args, d + 1);
        say(")");
    }

    void prExp(CompoundStmt v, int d) {
        indent(d);
        sayln("CompoundStmt(");
        if (v != null) {
            prDecList(v.decLs, d + 1);
            sayln(",");
            prStmtList(v.stmtLs, d + 1);
        }
        say(")");
    }

    void prExp(DecList v, int d) {
        indent(d);
        say("DecList(");
        if (v != null) {
            sayln("");
            prDec(v.head, d + 1);
            if (v.tail != null) {
                sayln(",");
                prDecList(v.tail, d + 1);
            }
        }
        say(")");
    }

    void prExp(DoWhileStmt e, int d) {
        indent(d);
        sayln("DoWhileStmt(");
        prExp(e.stmt, d + 1);
        sayln(",");
        prExp(e.exp, d + 1);
        sayln(")");
    }

    void prExp(ExpressionStmt e, int d) {
        indent(d);
        sayln("ExpressionStmt(");
        prExp(e.exp, d + 1);
        say(")");
    }

    void prExp(ForExp e, int d) {
        indent(d);
        sayln("ForExp(");
        indent(d + 1);
        prDec(e.var, d + 1);
        sayln(",");
        prExp(e.hi, d + 1);
        sayln(",");
        prExp(e.body, d + 1);
        say(")");
    }

    void prExp(ForStmt e, int d) {
        indent(d);
        sayln("ForStmt(");
        prExp(e.exp1, d + 1);
        sayln(",");
        prExp(e.exp2, d + 1);
        sayln(",");
        prExp(e.exp3, d + 1);
        sayln(",");
        prStmt(e.stmt, d + 1);
        sayln(",");
        indent(d + 1);
        say(")");
    }

    void prExp(IfExp e, int d) {
        indent(d);
        sayln("IfExp(");
        prExp(e.test, d + 1);
        sayln(",");
        prExp(e.thenclause, d + 1);
        if (e.elseclause != null) { /* else is optional */
            sayln(",");
            prExp(e.elseclause, d + 1);
        }
        say(")");
    }

    void prExp(InitializerList v, int d) {
        indent(d);
        sayln("InitializerList(");
        if (v != null) {
            sayln("");
            prExp(v.assignExp, d + 1);
            if (v.initls != null) {
                sayln(",");
                prExp(v.initls, d + 1);
            }
        }
        say(")");
    }

    void prExp(IntExp e, int d) {
        indent(d);
        say("IntExp(");
        say(e.value);
        say(")");
    }

    void prExp(JumpStmt e, int d) {
        indent(d);
        say("JumpStmt(");
        if (e.returning) {
            say("return");
            if (e.exp != null) {
                sayln(",");
                prExp(e.exp, d + 1);
            }
        } else if (e.breaking) {
            say("break");
        } else if (e.continuing) {
            say("continue");
        } else if (e.gotoing) {
            say("goto ");
            sayln(",");
            prVar(e.var, d + 1);
        }
        say(")");
    }

    void prExp(LabeledStmt e, int d) {
        indent(d);
        sayln("LabeledStmt(");
        indent(d + 1);
        sayln(e.label + ":");
        prExp(e.stmt, d +1);
        say(")");
    }

    void prExp(LetExp e, int d) {
        indent(d);
        say("LetExp(");
        sayln("");
        prDecList(e.decs, d + 1);
        sayln(",");
        prExp(e.body, d + 1);
        say(")");
    }

    void prExp(NilExp e, int d) {
        indent(d);
        say("NilExp()");
    }

    void prExp(OpExp e, int d) {
        indent(d);
        sayln("OpExp(");
        indent(d + 1);
        switch (e.oper) {
            case OpExp.PLUS:
                say("PLUS");
                break;
            case OpExp.MINUS:
                say("MINUS");
                break;
            case OpExp.MUL:
                say("MUL");
                break;
            case OpExp.DIV:
                say("DIV");
                break;
            case OpExp.EQ:
                say("EQ");
                break;
            case OpExp.NE:
                say("NE");
                break;
            case OpExp.LT:
                say("LT");
                break;
            case OpExp.LE:
                say("LE");
                break;
            case OpExp.GT:
                say("GT");
                break;
            case OpExp.GE:
                say("GE");
                break;
            case OpExp.MOD:
                say("MOD");
                break;
            case OpExp.RSHIFT:
                say("RSHIFT");
                break;
            case OpExp.LSHIFT:
                say("LSHIFT");
                break;
            case OpExp.BITWISEAND:
                say("BITWISEAND");
                break;
            case OpExp.BITWISEOR:
                say("BITWISEOR");
                break;
            case OpExp.BITWISEXOR:
                say("BITWISEXOR");
                break;
            case OpExp.AND:
                say("AND");
                break;
            case OpExp.OR:
                say("OR");
                break;
            case OpExp.COMMA:
                say("COMMA");
                break;
            default:
                throw new Error("Print.prExp.OpExp");
        }
        sayln(",");
        prExp(e.left, d + 1);
        sayln(",");
        prExp(e.right, d + 1);
        say(")");
    }

    void prExp(PostfixExp e, int d) {
        sayln("PostfixExp(");
        prExp(e.exp1, d + 1);
        sayln(",");
        prExp(e.exp2, d + 1);
        say(")");
    }

    void prExp(PostfixExpLs e, int d) {
        indent(d);
        sayln("PostfixExpLs(");
        if (e.exp1 != null) {
            prExp(e.exp1, d + 1);
        }
        sayln(",");
        if (e.exp2 != null) {
            prExp(e.exp2, d + 1);
        }
        say(")");
    }

    void prExp(RecordExp e, int d) {
        indent(d);
        say("RecordExp(");
        say(e.typ.toString());
        sayln(",");
        prFieldExpList(e.fields, d + 1);
        say(")");
    }

    void prExp(SelectionStmt v, int d) {
        indent(d);
        sayln("SelectionStmt(");
        if (v != null) {
            prExp(v.exp, d + 1);
            sayln(",");
            if (v.stmt1 != null) {
                prStmt(v.stmt1, d + 1);
            }
            if (v.stmt2 != null) {
                sayln(",");
                prStmt(v.stmt2, d + 1);
            }
        }
        say(")");
    }

    void prExp(SeqExp e, int d) {
        indent(d);
        sayln("SeqExp(");
        prExplist(e.list, d + 1);
        say(")");
    }

    void prExp(SizeOfExp e, int d) {
        indent(d);
        say("IntExp(");
        say(e.type.toString());
        say(")");
    }

    void prExp(StmtList e, int d) {
        indent(d);
        sayln("StmtList(");
        prExp(e.stmt, d + 1);
        sayln(",");
        if(e.statements != null) {
            prExp(e.statements, d + 1);
        }
        say(")");
    }

    void prExp(StringExp e, int d) {
        indent(d);
        say("StringExp(");
        say(e.value);
        say(")");
    }

    void prExp(StructExp v, int d) {
        indent(d);
        sayln("StructExp(");
        indent(d + 1);
        say("Var:");
        prVar(v.var, d + 1);
        sayln(",");
        indent(d + 1);
        say("Index:");
        prExp(v.e, d + 1);
        say(")");
    }

    void prExp(UnaryExp v, int d) {
        indent(d);
        sayln("UnaryExp(");
        indent(d + 1);
        switch (v.oper) {
            case UnaryExp.PLUS:
                say("PLUS");
                break;
            case UnaryExp.MINUS:
                say("MINUS");
                break;
            case UnaryExp.NOT:
                say("NOT");
                break;
            case UnaryExp.TILDE:
                say("TILDE");
                break;
            case UnaryExp.INCREMENT:
                say("INCREMENT");
                break;
            case UnaryExp.DECREMENT:
                say("DECREMENT");
                break;
            default:
                throw new Error("Print.prExp.UnaryExp: Unknown operator");
        }
        sayln(",");
        prExp(v.exp, d + 1);
        say(")");
    }

    void prExp(VarExp e, int d) {
        indent(d);
        sayln("VarExp(");
        prVar(e.var, d + 1);
        say(")");
    }

    void prExp(WhileExp e, int d) {
        indent(d);
        sayln("WhileExp(");
        prExp(e.test, d + 1);
        sayln(",");
        prExp(e.body, d + 1);
        say(")");
    }

    void prExp(WhileStmt e, int d) {
        indent(d);
        sayln("WhileStmt(");
        prExp(e.exp, d + 1);
        sayln(",");
        prExp(e.stmt, d + 1);
        say(")");
    }


    // Var Prints
    void prVar(SimpleVar v, int d) {
        say("SimpleVar(");
        say(v.name.toString());
        say(")");
    }

    void prVar(SubscriptVar v, int d) {
        sayln("SubscriptVar(");
        prVar(v.var, d + 1);
        sayln(",");
        prExp(v.index, d + 1);
        say(")");
    }

    void prVar(Var v, int d) {
        indent(d);
        if (v instanceof SimpleVar) prVar((SimpleVar) v, d);
        else if (v instanceof SubscriptVar) prVar((SubscriptVar) v, d);
        else throw new Error("Print.prVar");
    }


    // Dec Prints
    void prDec(FunctionDec d, int i) {
        say("FunctionDec(");
        if (d != null) {
            sayln(d.name.toString());
            prFieldlist(d.params, i + 1);
            sayln(",");
            if (d.result != null) {
                indent(i + 1);
                sayln(d.result.name.toString());
            }
            prExp(d.body, i + 1);
        }
        say(")");
    }

    void prDec(VarDec d, int i) {
        say("VarDec(");
        say(d.name.toString());
        sayln(",");
        if (d.typ != null) {
            indent(i + 1);
            say(d.typ.name.toString());
            sayln(",");
        }
        prExp(d.init, i + 1);
        sayln(",");
        indent(i + 1);
        say(d.escape);
        say(")");
    }

    void prDec(TypeDec d, int i) {
        if (d != null) {
            say("TypeDec(");
            say(d.name.toString());
            sayln(",");
            prTy(d.ty, i + 1);
            if (d.next != null) {
                sayln(",");
                indent(i + 1);
                prDec(d.next, i + 1);
            }
            say(")");
        }
    }

    void prDec(StructList d, int i) {
        if (d != null) {
            say("TypeStruct(");
            say(d.name.toString());
            sayln(",");
            prFieldlist(d.tail, i + 1);
            if (d.tail != null) {
                sayln(",");
                indent(i + 1);
                prFieldlist(d.tail, i + 1);
            }
            say(")");
        }
    }

    void prDec(Dec d, int i) {
        indent(i);
        if (d instanceof FunctionDec) prDec((FunctionDec) d, i);
        else if (d instanceof VarDec) prDec((VarDec) d, i);
        else if (d instanceof TypeDec) prDec((TypeDec) d, i);
        else if (d instanceof StructList) prDec((StructList) d, i);
        else throw new Error("Print.prDec");
    }


    // Ty Prints
    void prTy(ArrayTy t, int i) {
        say("ArrayTy(");
        say(t.typ.toString());
        say(")");
    }

    void prTy(NameTy t, int i) {
        say("NameTy(");
        say(t.name.toString());
        say(")");
    }

    void prTy(RecordTy t, int i) {
        sayln("RecordTy(");
        prFieldlist(t.fields, i + 1);
        say(")");
    }

    void prTy(Ty t, int i) {
        if (t != null) {
            indent(i);
            if (t instanceof NameTy) prTy((NameTy) t, i);
            else if (t instanceof RecordTy) prTy((RecordTy) t, i);
            else if (t instanceof ArrayTy) prTy((ArrayTy) t, i);
            else throw new Error("Print.prTy");
        }
    }


    // Misc Prints
    void prFieldlist(FieldList f, int d) {
        indent(d);
        say("FieldList(");
        if (f != null) {
            sayln("");
            indent(d + 1);
            say(f.name.toString());
            sayln(",");
            indent(d + 1);
            if (f.typ != null) {
                say(f.typ.toString());
            } else {
                say("null");
            }
            sayln(",");
            indent(d + 1);
            say(f.escape);
            sayln(",");
            prFieldlist(f.tail, d + 1);
        }
        say(")");
    }

    void prExplist(ExpList e, int d) {
        indent(d);
        say("ExpList(");
        if (e != null) {
            sayln("");
            prExp(e.head, d + 1);
            if (e.tail != null) {
                sayln(",");
                prExplist(e.tail, d + 1);
            }
        }
        say(")");
    }

    void prDecList(DecList v, int d) {
        indent(d);
        say("DecList(");
        if (v != null) {
            sayln("");
            prDec(v.head, d + 1);
            sayln(",");
            prDecList(v.tail, d + 1);
        }
        say(")");
    }

    void prFieldExpList(FieldExpList f, int d) {
        indent(d);
        say("FieldExpList(");
        if (f != null) {
            sayln("");
            indent(d + 1);
            say(f.name.toString());
            sayln(",");
            prExp(f.init, d + 1);
            sayln(",");
            prFieldExpList(f.tail, d + 1);
        }
        say(")");
    }

    void prStmtList(StmtList v, int d) {
        indent(d);
        say("StmtList(");
        if (v != null) {
            sayln("");
            prStmt(v.stmt, d + 1);
            if (v.statements != null) {
                sayln(",");
                prStmtList(v.statements, d + 1);
            }
        }
        say(")");
    }

    void prEnumeratorList(EnumeratorList e, int d) {
        indent(d);
        sayln("EnumeratorList(");
        if (e.exp != null) {
            prExp(e.exp, d + 1);
        }
        if (e.enumls != null) {
            sayln(",");
            prEnumeratorList(e.enumls, d + 1);
        }
        say(")");
    }

    void prFieldVar(FieldVar v, int d) {
        indent(d);
        sayln("FieldVar(");
        indent(d + 1);
        say("Var: ");
        prTy(v.var, d + 1);
        sayln(",");
        indent(d + 1);
        say("Field: ");
        prVar(v.field, d + 1);
        say(")");
    }

    // todo CALL THESE TWO
}
