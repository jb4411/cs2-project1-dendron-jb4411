package dendron.tree;

import dendron.machine.Machine;

import java.util.List;
import java.util.Map;

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

    @Override
    public void infixDisplay() {
    }

    @Override
    public List<Machine.Instruction> emit() {
        return null;
    }
}
