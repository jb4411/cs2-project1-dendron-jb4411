package dendron.tree;

import dendron.machine.Machine;

import java.util.List;
import java.util.Map;

public class Print implements ActionNode {
    /**
     * Set up a Print node.
     *
     * @param printee the expression to be evaluated and printed.
     */
    public Print(ExpressionNode printee) {

    }

    /**
     * Evaluate the expression and display the result on the console. Precede
     * it with three equal signs so it stands out a little.
     *
     * @param symTab the table where variable values are stored
     */
    @Override
    public void execute(Map<String, Integer> symTab) {

    }

    /**
     * Show this statement on standard output as the word "Print" followed by
     * the infix form of the expression.
     */
    @Override
    public void infixDisplay() {

    }

    /**
     * This method returns the code emitted by the printee node that pushes the
     * value of the printee expression onto the stack, followed by a PRINT instruction
     *
     * @return a list of instructions ending in the ones that compute the value
     * to be printed, and print it.
     */
    @Override
    public List<Machine.Instruction> emit() {
        return null;
    }
}