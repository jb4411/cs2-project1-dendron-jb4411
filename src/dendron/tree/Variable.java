package dendron.tree;

import dendron.machine.Machine;
import dendron.Errors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The ExpressionNode for a simple variable
 *
 * @author Jesse Burdick-Pless jb4411@g.rit.edu
 */
public class Variable implements ExpressionNode {
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    /**
     * Evaluate a variable by fetching its value
     *
     * @param symTab the table containing all variables' values
     * @return this variable's current value in the symbol table
     */
    @Override
    public int evaluate(Map<String, Integer> symTab) {
        if (!symTab.containsKey(this.name)) {
            Errors.report(Errors.Type.UNINITIALIZED,this.name);
        }
        return symTab.get(this.name);
    }

    /**
     * Print on standard output the Variable's name.
     */
    @Override
    public void infixDisplay() {
        System.out.print(this.name);
    }

    /**
     * Emit a LOAD instruction that pushes the Variable's value onto the stack.
     *
     * @return a list containing a single LOAD instruction
     */
    @Override
    public List<Machine.Instruction> emit() {
        List<Machine.Instruction> instructions = new ArrayList<>();
        instructions.add(new Machine.Load(this.name));
        return instructions;
    }
}
