import java.util.*;

class Node{
    int data;
    Node left,right;
    public Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class PrintOrderTraversal {
    int maxHeight = 0;
    public static void main(String [] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left= new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.left.right.left.left = new Node(9);
        root.left.right.left.right = new Node(10);
        root.right.left =new Node(6);
        root.right.right =new Node(7);
        //printInorder(root);
        //int height = findHeight(root);
        findNodeDistance(root,root.left.right,3);
        //System.out.println("The height of the tree  is " + height);
        
        //prinLevelOrder(root);

        //printLeftViewOfTree(root,1);

        //printTopOrderTraversal(root);

    }

    private static void findNodeDistance(Node root, Node target, int k) {
        Map<Integer,Node> parentMapForNode = new HashMap<>();
        parentMapForNode = findParents(root);
//        for (int key:
//             parentMapForNode.keySet()) {
//            System.out.println("The key for the  " + key + "   the parent node data is " + parentMapForNode.get(key).data);
//        }
        printDownwardWithDistanceK(target,k);
        printUpwardWithDistanceK(target,k,parentMapForNode);
    }

    private static void printUpwardWithDistanceK(Node target, int k, Map<Integer,Node> parentMap) {
        Queue<Node> queue = new LinkedList<>();
        Map<Integer,Boolean> visitedMap = new HashMap<>();
        visitedMap.put(target.data,true);
        queue.add(target);
        while (!queue.isEmpty()){
            Node  node = queue.poll();
            if (k >0){
                if(parentMap.get(node.data) != null){
                    Node parentNode = parentMap.get(node.data);
                    queue.add(parentNode);
                    printDownwardWithDistanceK(parentNode,target,k-1,visitedMap);
                    visitedMap.put(parentNode.data,true);
                    k--;
                }
            }


        }
    }
    private static void printDownwardWithDistanceK(Node target, int k) {
        if(target == null){
            return ;
        }


        if( k == 0){
            System.out.println("The node which os at the distance k is " + target.data);
        }
        if( k < 0){
            return ;
        }
        else{
            printDownwardWithDistanceK(target.left,k-1);
            printDownwardWithDistanceK(target.right,k-1);

        }
    }
    private static void printDownwardWithDistanceK(Node target,Node finalDest, int k,Map<Integer,Boolean> visitedMap) {
        if(target == null || k < 0 || (target == finalDest) ){
            return ;
        }
        if(visitedMap.containsKey(target.data)){
            if(visitedMap.get(target.data)){
                return;
            }
        }

        if( k == 0){
            System.out.println("The node which os at the distance k is " + target.data);
        }

        else{
            printDownwardWithDistanceK(target.left,finalDest,k-1,visitedMap);
            printDownwardWithDistanceK(target.right,finalDest,k-1,visitedMap);

        }
    }

    private static Map<Integer,Node> findParents(Node root) {
        Map<Integer,Node> parentMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        parentMap.put(root.data,null);
        queue.add(root);
        while (!queue.isEmpty()){
            Node item = queue.poll();
            if(item.left != null){
                queue.add(item.left);
                parentMap.put(item.left.data,item);
            }
            if(item.right != null){
                queue.add(item.right);
                parentMap.put(item.right.data,item);
            }
        }
        return parentMap;
    }

    private static <forEach> void printTopOrderTraversal(Node root) {
        class QueueObject {
            int hd;
            Node node;
            QueueObject(Node node , int hd){
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<QueueObject> queueObjectList = new LinkedList<>();
        Map<Integer,Node> countMapOfHd = new HashMap<>();
        queueObjectList.add(new QueueObject(root,0));

        while(!queueObjectList.isEmpty()){
            QueueObject retreiveQueueObject = queueObjectList.poll();
            int currHd = retreiveQueueObject.hd;
            //System.out.println("the current hfd value is  "  + currHd);
            //System.out.println("the size of queue "  + queueObjectList.size());
            if(!countMapOfHd.containsKey(retreiveQueueObject.hd)){
                countMapOfHd.put(currHd,retreiveQueueObject.node);
            }
            if(retreiveQueueObject.node.left != null){
                queueObjectList.add(new QueueObject(retreiveQueueObject.node.left,currHd-1));
            }
            if(retreiveQueueObject.node.right != null){
                queueObjectList.add(new QueueObject(retreiveQueueObject.node.right,currHd+1));
            }


        }
        Object[] sortedList = countMapOfHd.keySet().toArray();
        Arrays.sort(sortedList);
        System.out.println("Top view of bst ");
        System.out.println("****************");
        System.out.println("****************");

        for (Object sam:
             sortedList) {
            Node retrieved = countMapOfHd.get(sam);
            System.out.print(retrieved.data);

        }


    }

    static int maxlevel = 0;
    private static void printLeftViewOfTree(Node root, int level) {
        if(root == null){
            return ;
        }else{
            if(level > maxlevel){
                maxlevel = level;
                System.out.println("Print the element "  + root.data);
            }
            printLeftViewOfTree(root.left,level+1);
            //printLeftViewOfTree(root.right,level+1);
        }
    }

    private static void prinLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.println("the level order entry  " + temp.data);

            //System.out.println(queue.toString());
            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }

        }

    }

    private static int findHeight(Node root) {
        if(root == null){
            return 0;
        }else{
            int lheight = findHeight(root.left);
            int rheight = findHeight(root.right);
            if(lheight>rheight){
                return lheight+1;
            }else{
                return rheight+1;
            }
        }

    }

    private static void printInorder(Node root) {
        if(root == null){
            return;
        }
        printInorder(root.left);
        System.out.println(root.data);
        printInorder(root.right);
    }
}
