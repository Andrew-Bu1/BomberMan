package uet.oop.bomberman.Algorithm;

import static uet.oop.bomberman.tileManager.HEIGHT;
import static uet.oop.bomberman.tileManager.WIDTH;
import static uet.oop.bomberman.tileManager.mapInGame;

import java.util.ArrayList;
import java.util.List;

public class Astar {
    private Node[][] mapNode = new Node[WIDTH][HEIGHT];
    private Node startNode, goalNode, currentNode;
    private List<Node> openList = new ArrayList<>();
    public List<Node> trackPath = new ArrayList<>();

    private int stepsMax;

    private int steps = 0;

    public void setStepsMax(int stepsMax) {
        this.stepsMax = stepsMax;
    }

    boolean goalReached = false;

    public boolean isGoalReached() {
        return goalReached;
    }

    public Astar() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT - 1; j++) {
                mapNode[i][j] = new Node(i, j);
            }
        }
    }

    private void setSolidNode(int x, int y) {
        mapNode[x][y].setSolid(true);
    }

    public void getCost(Node node) {
        // get G cost
        int xDistance = Math.abs(node.getxCoordinate() - startNode.getxCoordinate());
        int yDistance = Math.abs(node.getyCoordinate() - startNode.getyCoordinate());
        node.setstartCost(xDistance + yDistance);

        // Get H cost
        xDistance = Math.abs(node.getxCoordinate() - goalNode.getxCoordinate());
        yDistance = Math.abs(node.getyCoordinate() - goalNode.getyCoordinate());
        node.setgoalCost(xDistance + yDistance);

        // Get F cost
        node.settotalCost(node.getstartCost() + node.getgoalCost());
    }

    public void setNodes(int startX, int startY, int goalX, int goalY) {
        reset();
        startNode = mapNode[startX][startY];
        goalNode = mapNode[goalX][goalY];
        currentNode = startNode;
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT - 1; j++) {
                if (mapInGame[i][j] == '#' || mapInGame[i][j] == '*' || mapInGame[i][j] == 'z') {
                    setSolidNode(i, j);
                }
                getCost(mapNode[i][j]);
            }
        }
    }

    public void reset() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT - 1; j++) {
                mapNode[i][j].setOpen(false);
                mapNode[i][j].setChecked(false);
                mapNode[i][j].setSolid(false);
            }
        }
        goalReached = false;
        openList.clear();
        trackPath.clear();
        steps = 0;
    }

    public void abolishSolid() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT - 1; j++) {
                if (mapNode[i][j].isSolid())
                    mapNode[i][j].setSolid(false);
            }
        }
    }

    public boolean autoSearch() {
        while (goalReached == false && steps < stepsMax) {
            currentNode.setChecked(true);
            openList.remove(currentNode);
            int x = currentNode.getxCoordinate();
            int y = currentNode.getyCoordinate();

            // Open the up node
            if (y - 1 > 0) {
                openNode(mapNode[x][y - 1]);
            }
            // Open the Left Node
            if (x - 1 > 0) {
                openNode(mapNode[x - 1][y]);
            }
            // Open the Down node
            if (y + 1 < HEIGHT - 1) {
                openNode(mapNode[x][y + 1]);
            }
            // Open the right node
            if (x + 1 < WIDTH) {
                openNode(mapNode[x + 1][y]);
            }

            int bestNodeIndex = 0;
            int bestNodetotalCost = Integer.MAX_VALUE;
            for (int i = 0; i < openList.size(); i++) {
                if (openList.get(i).gettotalCost() < bestNodetotalCost) {
                    bestNodeIndex = i;
                    bestNodetotalCost = openList.get(i).gettotalCost();
                } else if (openList.get(i).gettotalCost() == bestNodetotalCost) {
                    if (openList.get(i).getstartCost() < openList.get(bestNodeIndex).getstartCost()) {
                        bestNodeIndex = i;
                    }
                }
            }
            if (openList.size() == 0) {
                break;
            }
            currentNode = openList.get(bestNodeIndex);
            if (currentNode == goalNode) {
                goalReached = true;
                trackPath();
                break;
            }
            steps++;
        }
        return goalReached;
    }

    public void openNode(Node node) {
        if (!node.isOpen() && !node.isChecked() && !node.isSolid()) {
            node.setOpen(true);
            node.parent = currentNode;
            openList.add(node);
        }
    }

    private void trackPath() {
        Node current = goalNode;
        while (current != startNode) {
            trackPath.add(0, current);
            current = current.parent;
        }
    }

}
