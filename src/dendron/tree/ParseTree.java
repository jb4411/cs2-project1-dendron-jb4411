/*
 * file: ParseTree.java
 */

package dendron.tree;

import dendron.machine.Machine;
import dendron.tree.ActionNode;
import dendron.tree.ExpressionNode;
import dendron.tree.UnaryOperation;
import dendron.tree.BinaryOperation;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Operations that are done on a Dendron code parse tree.
 *
 * THIS CLASS IS UNIMPLEMENTED. All methods are stubbed out.
 *
 * @author Jesse Burdick-Pless jb4411@g.rit.edu
 */
public class ParseTree {
    private DendronNode root;
    /**
     * Parse the entire list of program tokens. The program is a
     * sequence of actions (statements), each of which modifies something
     * in the program's set of variables. The resulting parse tree is
     * stored internally.
     * @param program the token list (Strings)
     */
    public ParseTree( List< String > program ) {
        this.root = parseAction(program);
    }

    /**
     * Parse the next action (statement) in the list.
     * (This method is not required, just suggested.)
     * @param program the list of tokens
     * @return a parse tree for the action
     */
    private ActionNode parseAction( List< String > program ) {
        ActionNode result;
        String currentToken = program.remove(0);
        if (currentToken.equals(":=")) {
            result = new Assignment(currentToken,parseExpr(program));
        } else {
            result = new Print(parseExpr(program));
        }
        return result;
    }

    /**
     * Parse the next expression in the list.
     * (This method is not required, just suggested.)
     * @param program the list of tokens
     * @return a parse tree for this expression
     */
    private ExpressionNode parseExpr( List< String > program ) {
        ExpressionNode result;
        String currentToken = program.remove(0);
        if (UnaryOperation.OPERATORS.contains(currentToken)) {
            result = new UnaryOperation(currentToken, parseExpr(program));
        } else if (BinaryOperation.OPERATORS.contains(currentToken)) {
            ExpressionNode left = parseExpr(program);
            ExpressionNode right = parseExpr(program);
            result = new BinaryOperation(currentToken, left, right);
        } else if (currentToken.matches( "^[a-zA-Z].*" )){
            result = new Variable(currentToken);
        } else {
            int cons = Integer.parseInt(currentToken);
            result = new Constant(cons);
        }
        return result;
    }

    /**
     * Print the program the tree represents in a more typical
     * infix style, and with one statement per line.
     * @see ActionNode#infixDisplay()
     */
    public void displayProgram() {
    }

    /**
     * Run the program represented by the tree directly
     * @see ActionNode#execute(Map)
     */
    public void interpret() {
    }

    /**
     * Build the list of machine instructions for
     * the program represented by the tree.
     * @return the Machine.Instruction list
     * @see Machine.Instruction#execute()
     */
    public List< Machine.Instruction > compile() {
        return null;
    }

}
