package dendron.tree;

import dendron.machine.Machine;

import java.util.List;
import java.util.Map;

/**
 * An ActionNode used to represent a sequence of other ActionNodes. The main
 * use of this node type is to be the root of the entire program tree.
 *
 * @author Jesse Burdick-Pless jb4411@g.rit.edu
 */
public class Program implements ActionNode, DendronNode {
    /**
     * Initialize this instance as an empty sequence of ActionNode children.
     */
    public Program() {

    }

    /**
     * Add a child of this Program node.
     *
     * @param newNode the node representing the action that will execute last
     */
    public void addAction(ActionNode newNode) {

    }

    /**
     * Execute each ActionNode in this object, from first-added to last-added.
     *
     * @param symTab the table of variable values
     */
    public void execute(Map<String,Integer> symTab) {

    }

    /**
     * Show the infix displays of all children on standard output. The order is
     * first-added to last-added.
     */
    @Override
    public void infixDisplay() {

    }

    /**
     * Create a list of instructions emitted by each child, from the
     * first-added child to the last-added.
     *
     * @return the concatenated instructions lists from all children
     */
    @Override
    public List<Machine.Instruction> emit() {
        return null;
    }
}
