package uet.oop.bomberman.Algorithm;

public class Node {
    private int xCoordinate;
    private int yCoordinate;

    protected Node parent;
    // Distance from the current node to the start node.
    private int startCost;
    // Distance from the current node to the goal Node.
    private int goalCost;
    // The sum of the startCost and the goalCost
    private int totalCost;

    private boolean solid;
    private boolean open;
    private boolean checked;

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public int getstartCost() {
        return startCost;
    }

    public void setstartCost(int startCost) {
        this.startCost = startCost;
    }

    public int getgoalCost() {
        return goalCost;
    }

    public void setgoalCost(int goalCost) {
        this.goalCost = goalCost;
    }

    public int gettotalCost() {
        return totalCost;
    }

    public void settotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isSolid() {
        return solid;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Node(int x, int y) {
        xCoordinate = x;
        yCoordinate = y;
    }

}
