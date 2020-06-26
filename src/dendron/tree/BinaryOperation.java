package dendron.tree;

import dendron.machine.Machine;

import java.util.*;

/**
 * A calculation represented by a binary operator and its two operands.
 *
 * @author Jesse Burdick-Pless jb4411@g.rit.edu
 */
public class BinaryOperation implements ExpressionNode {
    /** The operator symbol used for addition */
    public static final String ADD = "+";
    /** The operator symbol used for subtraction */
    public static final String SUB = "-";
    /** The operator symbol used for multiplication */
    public static final String MUL = "*";
    /** The operator symbol used for division */
    public static final String DIV = "/";
    /** Container of all legal binary operators, for use by parsers */
    public static final Collection<String> OPERATORS = new ArrayList<>(Arrays.asList(ADD,SUB,MUL,DIV));

    private String operator;
    private ExpressionNode leftChild;
    private ExpressionNode rightChild;

    /**
     * Create a new BinaryOperation node.
     *
     * @param operator the string rep. of the operation
     * @param leftChild the left operand
     * @param rightChild the right operand
     * @rit.pre OPERATORS.contains( operator ), leftChild != null, rightChild != null
     */
    public BinaryOperation(String operator, ExpressionNode leftChild, ExpressionNode rightChild) {
        this.operator = operator;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    /**
     * Compute the result of evaluating both operands and applying the operator
     * to them.
     *
     * @param symTab symbol table, needed to evaluate the child trees
     * @return the result of the computation
     */
    @Override
    public int evaluate(Map<String, Integer> symTab) {
        return 0;
    }

    /**
     * Print, on standard output, the infixDisplay of the two child nodes
     * separated by the operator and surrounded by parentheses. Blanks are
     * inserted throughout.
     */
    @Override
    public void infixDisplay() {

    }

    /**
     * Emit the Machine instructions necessary to perform the computation of
     * this BinaryOperation. The operator itself is realized by an instruction
     * that pops two values off the stack, applies the operator, and pushes the
     * answer.
     *
     * @return a list containing instructions for the left operand,
     * instructions for the right operand, and the instruction to perform the
     * operation
     */
    @Override
    public List<Machine.Instruction> emit() {
        return null;
    }
}
