package dendron.tree;

import dendron.machine.Machine;

import java.util.List;
import java.util.Map;

/**
 * An ActionNode that represents the assignment of the value of an expression
 * to a variable.
 *
 * @author Jesse Burdick-Pless jb4411@g.rit.edu
 */
public class Assignment implements ActionNode {
    private String ident;
    private ExpressionNode rhs;
    /**
     * Set up an Assignment node. Note that the identifier is not turned into a
     * Variable node. The reason is that the variable's value is not needed;
     * instead it is a destination for a computation. This use is not
     * compatible with Variable's mission.
     *
     * @param ident the name of the variable that is getting a new value
     * @param rhs the expression on the "right-hand side" (RHS) of the
     * assignment statement
     */
    public Assignment(String ident, ExpressionNode rhs) {
        this.ident = ident;
        this.rhs = rhs;
    }

    /**
     * Evaluate the RHS expression and assign the result value to the variable.
     *
     * @param symTab the table where variable values are stored
     */
    @Override
    public void execute(Map<String, Integer> symTab) {

    }

    /**
     * Show this assignment on standard output as a variable followed by an
     * assignment arrow (":=") followed by the infix form of the RHS expression.
     */
    @Override
    public void infixDisplay() {
    }

    /**
     * This method returns a STORE instruction for the variable in question
     * preceded by the code emitted by the RHS node that eventually pushes the
     * value of the expression onto the stack.
     *
     * @return a list of instructions ending in one that stores the top value
     * on the stack to this node's variable
     */
    @Override
    public List<Machine.Instruction> emit() {
        return null;
    }
}
