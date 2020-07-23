package bearmaps;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Xuannan Dong
 */
public class KDTree {

    public class Node{
        private Point point;
        private int level;
        private Node leftchild;
        private Node rightchild;

        public Node(){

        }

        public void setPoint(Point p){
            this.point = p;
        }

        public void setLevel(int level){
            this.level = level;
        }

        public Point getPoint(){
            return this.point;
        }

        public int getLevel(){
            return this.level;
        }

        public Node getleft(){
            return leftchild;
        }

        public Node getright(){
            return rightchild;
        }
    }

    private Node root;

    public KDTree(List<Point> points){
        for(Point p:points) insert(p);
    }

    public void insert(Point p){
        Node new_Node = new Node();
        if(root == null) {
            new_Node.setLevel(0);
            new_Node.setPoint(p);
            root = new_Node;
            return;
        }

        Node index = root;
        while(true){
            if(index.getLevel()%2==0){//如果比较节点的层数为偶数，则对其x坐标进行比较
                if(index.getPoint().getX()>p.getX()){//如果新插入的点x坐标比比较节点大，则index移向右节点
                    if(index.rightchild==null){ //如果右节点为空，则直接插入，否则继续向下访问
                        new_Node.setLevel(index.getLevel()+1);
                        new_Node.setPoint(p);
                        index.rightchild = new_Node;
                        break;
                    }
                    else index = index.rightchild;
                }
                else {
                    if(index.leftchild==null){ //如果左节点为空，则直接插入，否则继续向下访问
                        new_Node.setLevel(index.getLevel()+1);
                        new_Node.setPoint(p);
                        index.leftchild = new_Node;
                        break;
                    }
                    else index = index.leftchild;
                }
            }
            else {
                if(index.getPoint().getY()>p.getY()){//如果新插入的点x坐标比比较节点大，则index移向右节点
                    if(index.rightchild==null){ //如果右节点为空，则直接插入，否则继续向下访问
                        new_Node.setLevel(index.getLevel()+1);
                        new_Node.setPoint(p);
                        index.rightchild = new_Node;
                        break;
                    }
                    else index = index.rightchild;
                }
                else {
                    if(index.leftchild==null){ //如果左节点为空，则直接插入，否则继续向下访问
                        new_Node.setLevel(index.getLevel()+1);
                        new_Node.setPoint(p);
                        index.leftchild = new_Node;
                        break;
                    }
                    else index = index.leftchild;
                }
            }
        }

    }

    public Point nearest(double x, double y){
        Point target = new Point(x,y);
        return help(root,target,root.getPoint());
    }

    public Point help(Node root, Point target, Point best){
        if (root == null) {
            return best;
        }
        double cur_dist = distance(root.getPoint(),target);
        double best_dist = distance(best,target);
        if(cur_dist<best_dist) best = root.getPoint();

        Node goodside;
        Node badside;
        if(root.getLevel()%2==0){
            //表示当前层数为偶数层，通过比较x坐标来断定goodside和badside
            if(target.getX()<root.getPoint().getX()){
                goodside = root.getleft();
                badside = root.getright();
            }
            else {
                goodside = root.getright();
                badside = root.getleft();
            }
        }
        else {
            //表示当前层数为奇数层，通过比较x坐标来断定goodside和badside
            if(target.getY()<root.getPoint().getY()){
                goodside = root.getleft();
                badside = root.getright();
            }
            else {
                goodside = root.getright();
                badside = root.getleft();
            }
        }

        best = help(root.getleft(), target,best);
        best = help(root.getright(),target,best);
        return best;
    }


    public double distance(Point a, Point b){
        return Math.pow(a.getX()-b.getX(),2)+Math.pow(a.getY() - b.getY(),2);
    }
    public static void main(String[] args) {
        Point A = new Point(2, 3); // constructs a Point with x = 1.1, y = 2.2
        Point B = new Point(4, 2);
        Point C = new Point(4, 5);
        Point D = new Point(3, 3); // constructs a Point with x = 1.1, y = 2.2
        Point E = new Point(1, 5);
        Point F = new Point(4, 4);
        KDTree kdt = new KDTree(Arrays.asList(A, B, C, D, E, F));
        Point ret = kdt.nearest(1.0, 5.1); // returns p2
        ret.getX();
        ret.getY();
        System.out.println(ret.getX());
        System.out.println(ret.getY());
    }
}
