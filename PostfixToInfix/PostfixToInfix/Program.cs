using System;
using System.Collections.Generic;

namespace PostfixToInfix
{
    public class Intermediate
    {
        public string expr;
        public string oper;

        public Intermediate(string expr, string oper)
        {
            this.expr = expr;
            this.oper = oper;
        }
    }

    class MainClass
    {
        public static void Main(string[] args)
        {
            string postfix;

            Console.WriteLine("Arttaki ifade girin : ");
            postfix = Console.ReadLine();

            var postfixTokens = postfix.Split(' ');

            var stack = new Stack<Intermediate>();

            foreach (string token in postfixTokens)
            {
                if (token == "+" || token == "-")
                {

                    var rightIntermediate = stack.Pop();
                    var leftIntermediate = stack.Pop();

                    var newExpr = leftIntermediate.expr + token + rightIntermediate.expr;

                    stack.Push(new Intermediate(newExpr, token));
                }
                else if (token == "*" || token == "/")
                {
                    string leftExpr, rightExpr;

                    var rightIntermediate = stack.Pop();
                    if (rightIntermediate.oper == "+" || rightIntermediate.oper == "-")
                    {
                        rightExpr = "(" + rightIntermediate.expr + ")";
                    }
                    else
                    {
                        rightExpr = rightIntermediate.expr;
                    }

                    var leftIntermediate = stack.Pop();
                    if (leftIntermediate.oper == "+" || leftIntermediate.oper == "-")
                    {
                        leftExpr = "(" + leftIntermediate.expr + ")";
                    }
                    else
                    {
                        leftExpr = leftIntermediate.expr;
                    }

                    var newExpr = leftExpr + token + rightExpr;

                    stack.Push(new Intermediate(newExpr, token));
                }
                else
                {
                    stack.Push(new Intermediate(token, ""));
                }
            }
            Console.WriteLine(stack.Peek().expr);
        }
    }
}
