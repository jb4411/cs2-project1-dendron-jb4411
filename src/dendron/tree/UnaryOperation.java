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

    private String operator;
    private ExpressionNode expr;

    /**
     * Create a new UnaryOperation node.
     *
     * @param operator the string rep. of the operation
     * @param expr the operand
     * @rit.pre OPERATORS.contains( operator ), expr != null
     */
    public UnaryOperation(String operator, ExpressionNode expr) {
        this.operator = operator;
        this.expr = expr;
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
        int result;
        if (this.operator.equals(NEG)) {
            result = -1*this.expr.evaluate(symTab);
        } else {
            result = (int) Math.sqrt((double) this.expr.evaluate(symTab));
        }
        return result;
    }

    /**
     * Print, on standard output, the infixDisplay of the child nodes preceded
     * by the operator and without an intervening blank.
     */
    @Override
    public void infixDisplay() {
        System.out.print(operator);
        this.expr.infixDisplay();
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
