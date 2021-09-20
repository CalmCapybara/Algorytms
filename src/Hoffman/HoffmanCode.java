package Hoffman;

import java.util.*;

class HoffmanCode {
    public static void main(String[] args) {
        new HoffmanCode().run2();
    }

    void run() {
        List<Node> nodeList = new ArrayList<>();
        String[] split = new Scanner(System.in).nextLine().split("");
        Arrays.stream(split).forEachOrdered(s -> {
            Node temp = new Node(s);
            int i = nodeList.indexOf(temp);
            if (i >= 0) {
                nodeList.get(i).plusFreaquance();
            } else nodeList.add(new Node(s));
        });
        int length = nodeList.size();
        System.out.print(length + " ");
        PriorityQueue<Node> queue = new PriorityQueue(nodeList);
        Tree tree = new Tree(queue);
        Map<String, String> mapTree = tree.getBinaryPresentation();

        for (int i = 0; i < split.length; i++) {
            split[i] = mapTree.get(split[i]);
        }
        String result = String.join("", split);

        System.out.println(result.length());
        for (Map.Entry<String, String> stringStringEntry : mapTree.entrySet()) {
            System.out.println(stringStringEntry.getKey() + ": " + stringStringEntry.getValue());
        }

        System.out.println(result);


    }

    void run2() {
        Scanner scanner = new Scanner(System.in);
        List<Node> nodeList = new ArrayList<>();
        int lenght = Integer.parseInt(scanner.nextLine().split(" ")[0]);
        while (lenght > 0) {
            String[] s = scanner.nextLine().split(": ");
            nodeList.add(new Node(s[0], s[1]));
            lenght--;
        }
        Tree tree = new Tree(nodeList);
        System.out.println(tree.decode(scanner.nextLine()));


    }

    private class Tree {
        private Node root = new Node();
        private final Map<String, String> binaryPresentation = new HashMap<>();
        private List<Node> nodeList = new ArrayList<>();
        private String stroka ="";

        public Tree(PriorityQueue<Node> queue) {
            Node tempRoot;
            while (true) {
                Node node_1 = queue.poll();
                Node node_2 = queue.poll();
                tempRoot = new Node();
                if (node_2 == null) {
                    root = node_1;
                    break;
                }
                tempRoot.setLeftNode(node_1);
                tempRoot.setRightNode(node_2);
                tempRoot.setFrequance(node_1.frequance + node_2.frequance);
                queue.add(tempRoot);
            }
        }

        public Tree(List<Node> list) {
            this.nodeList = list;
            for (Node node : nodeList) {
                code(0, root, node.binData, node.data);
            }
//            System.out.println("Кодирование завершено");
        }

        public void code(int index, Node root, String binData, String data) {

//            if(binData.length() == 1) {
//                root.data = data;
//                root.binData = binData;
//                return;
//            }
            if (index == binData.length()) {
                root.data = data;
                return;
            }
            if (binData.charAt(index) == '0') {
                if(root.leftNode == null) root.leftNode = new Node();
                code(++index, root.leftNode, binData, data);
            } else {
                if(root.rightNode == null) root.rightNode = new Node();
                code(++index, root.rightNode, binData, data);
            }


        }

        public String decode(String codirovka) {
            Node root = this.root;
            for (int i = 0; i < codirovka.length(); i++) {
                if (root.data != null) {
                    stroka += root.data;
                    root = this.root;
                }

                if (codirovka.charAt(i) == '0') {
//                    System.out.println("0");
                    root = root.leftNode;
                } else {
//                    System.out.println("1");
                    root = root.rightNode;
                }

            }
            if (root.data != null) {
                stroka += root.data;
                root = this.root;
            }
            return this.stroka;
        }


        private void binaryPresentation(Node root, String value) {
            if (root.leftNode != null) {
                binaryPresentation(root.leftNode, value + "0");
            }

            if (root.rightNode != null) {
                binaryPresentation(root.rightNode, value + "1");
            }

            if (root.data != null) {
                binaryPresentation.put(root.data, (value.equals("") ? "0" : value));
            }

        }

        public Map<String, String> getBinaryPresentation() {
            binaryPresentation(root, "");
            return binaryPresentation;
        }
    }

    private class Node implements Comparable {
        private int frequance = 1;
        private String data;
        private String binData;
        private Node leftNode;
        private Node rightNode;

        public Node() {
        }

        public Node(String data, String binData) {
            this.data = data;
            this.binData = binData;
        }

        public Node(String data) {
            this.data = data;
        }

        public int getFrequance() {
            return frequance;
        }

        public String getData() {
            return data;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setFrequance(int frequance) {
            this.frequance = frequance;
        }

        public void plusFreaquance() {
            this.frequance++;
        }

        public void setData(String data) {
            this.data = data;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(data, node.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public java.lang.String toString() {
            String string1 = "";
            String string2 = "";
            if (leftNode != null) string1 = leftNode.data;
            if (rightNode != null) string2 = rightNode.data;
            return "{" +
                    frequance + ":" +
                    data + "(" + string1 + "," + string2 + ")" +
                    '}';
        }

        @Override
        public int compareTo(Object o) {
            int i = this.frequance - ((Node) o).frequance;
            if (i == 0 && this.data != null && ((Node) o).data != null) return this.data.compareTo(((Node) o).data);
            return i;
        }
    }
}
