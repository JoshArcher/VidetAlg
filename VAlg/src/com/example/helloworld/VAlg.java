package com.example.helloworld;
import java.lang.*;
import java.util.*;

class Term{
    String term;
    boolean isVariable = false;

    public Term(String s)
    {
        if(Character.isUpperCase(s.charAt(0)))
        {
            isVariable = true;
        }
        term = s;
    }

    public String printTerm()
    {
        return term;
    }
}

class Atom {

    String label;
    List<Term> terms;

    public Atom(String label)
    {
        this.label = label;
        terms = Collections.emptyList();
        //terms = new List<Term>();
    }

    public Atom(String label, List<Term> terms)
    {
        this.label = label;
        this.terms = terms;
    }

    public Atom(String label, Term term)
    {
        this.label = label;
        terms = Collections.singletonList(term);
    }

    @Override
    public String toString() {
        String retval = label + "(";
        if(terms.size() == 0)
        {
            return retval + ")";
        }
        for (int i = 0; i < terms.size(); i++)
        {
            if(i == terms.size()-1)
            {
                retval += terms.get(i).printTerm()+")";
            }
            else
            {
                retval += terms.get(i).printTerm()+",";
            }
        }
        return retval;
    }

}

class Literal{
    Atom atom;
    boolean strongNegation;

    //Constructors
    public Literal(String label)
    {
        atom = new Atom(label);
        strongNegation = false;
    }
    public Literal(String label, boolean strongNeg)
    {
        atom = new Atom(label);
        strongNegation = strongNeg;
    }
    public Literal(String label, List<String> terms)
    {
        List<Term> termList = null;
        for(int i = 0; i < terms.size(); i++)
        {
            termList.add(new Term(terms.get(i)));
        }
        atom = new Atom(label, termList);
        strongNegation = false;
    }
    public Literal(String label, List<String> terms, boolean strongNeg)
    {
        List<Term> termList = null;
        for(int i = 0; i < terms.size(); i++)
        {
            termList.add(new Term(terms.get(i)));
        }
        atom = new Atom(label, termList);
        strongNegation = strongNeg;
    }

    //Printing/debug
    public void print(boolean NaF)
    {
        if(NaF)
        {
            System.out.print("not ");
        }
        if(strongNegation)
        {
            System.out.print("-");
        }
        System.out.print(atom.toString()+System.lineSeparator());
    }

}

class Sort
{

}

class HFunction
{

}

class DFunction
{

}

class Predicate
{

}

///Note: When "keeping track" if rule has been fired in the tree it's in
//  do this recursively per branch, rather than per tree
//  Possibly throw out instances that have been grounded
class Rule
{
    List<Literal> head;
    List<Literal> posBody;
    List<Literal> negBody;
}

class SSignature
{
    Set<String> SortNames = new HashSet<String>();
    Set<String> ObjectNames = new HashSet<String>();
    Set<String> VarNames = new HashSet<String>();
    Set<String> FunctionSymbols = new HashSet<String>();
    Set<String> PredSymbols = new HashSet<String>();
}

class Program
{
    List<Rule> rules;
}

public class VAlg {
    public static void main(String[] args) {
        Literal test = new Literal("a", true);
        test.print(false);
    }

}


