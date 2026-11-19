class Solution {
    Map<Node,Node> map= new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }

        if(map.containsKey(node)){
            return map.get(node);
        }

        Node clone= new Node(node.val);
        map.put(node,clone);

        for(Node neighbors: node.neighbors){
            clone.neighbors.add(cloneGraph(neighbors));
        }

        return clone;

    }
}