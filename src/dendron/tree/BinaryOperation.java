package dendron.tree;

import dendron.machine.Machine;
import dendron.Errors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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
        int result;
        if (this.operator.equals(ADD)) {
            result = this.leftChild.evaluate(symTab) + this.rightChild.evaluate(symTab);
        } else if (this.operator.equals(SUB)) {
            result = this.leftChild.evaluate(symTab) - this.rightChild.evaluate(symTab);
        } else if (this.operator.equals(MUL)) {
            result = this.leftChild.evaluate(symTab) * this.rightChild.evaluate(symTab);
        } else {
            int left = this.leftChild.evaluate(symTab);
            int right = this.rightChild.evaluate(symTab);
            if (right == 0) {
                Errors.report(Errors.Type.DIVIDE_BY_ZERO,left + "/" + right);
            }
            result = left / right;
        }

        return result;
    }

    /**
     * Print, on standard output, the infixDisplay of the two child nodes
     * separated by the operator and surrounded by parentheses. Blanks are
     * inserted throughout.
     */
    @Override
    public void infixDisplay() {
        System.out.print("( ");
        this.leftChild.infixDisplay();
        System.out.print(" " + this.operator + " ");
        this.rightChild.infixDisplay();
        System.out.print(" )");
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
        List<Machine.Instruction> instructions = new ArrayList<>();
        instructions.addAll(this.leftChild.emit());
        instructions.addAll(this.rightChild.emit());
        if (this.operator.equals(ADD)) {
            instructions.add(new Machine.Add());
        } else if (this.operator.equals(SUB)){
            instructions.add(new Machine.Subtract());
        } else if (this.operator.equals(MUL)){
            instructions.add(new Machine.Multiply());
        } else {
            instructions.add(new Machine.Divide());
        }
        return instructions;
    }
}
