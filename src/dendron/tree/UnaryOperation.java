package dendron.tree;

import dendron.machine.Machine;

import java.util.*;

/**
 * A calculation represented by a unary operator and its operand.
 *
 * @author Jesse Burdick-Pless jb4411@g.rit.edu
 */
public class UnaryOperation implements ExpressionNode {
    /** arithmetic negation operator */
    public static final String NEG = "_";
    /** square root operator */
    public static final String SQRT = "#";
    /** Container of all legal unary operators, for use by parsers */
    public static final Collection<String> OPERATORS = new ArrayList<>(Arrays.asList(NEG,SQRT));

    /**
     * Create a new UnaryOperation node.
     *
     * @param operator the string rep. of the operation
     * @param expr the operand
     * @rit.pre OPERATORS.contains( operator ), expr != null
     */
    public UnaryOperation(String operator, ExpressionNode expr) {

    }

    /**
     * Compute the result of evaluating the expression and applying the
     * operator to it.
     *
     * @param symTab symbol table, needed to evaluate the child tree
     * @return the result of the computation
     */
    @Override
    public int evaluate(Map<String, Integer> symTab) {
        return 0;
    }

    /**
     * Print, on standard output, the infixDisplay of the child nodes preceded
     * by the operator and without an intervening blank.
     */
    @Override
    public void infixDisplay() {

    }

    /**
     * Emit the Machine instructions necessary to perform the computation of
     * this UnaryOperation. The operator itself is realized by an instruction
     * that pops a value off the stack, applies the operator, and pushes the
     * answer.
     *
     * @return a list containing instructions for the expression and the instruction to perform the operation
     */
    @Override
    public List<Machine.Instruction> emit() {
        return null;
    }
}
