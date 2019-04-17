package work;

import java.util.*;

/**
 * @author caoyixiong
 * @Date: 2019/1/30
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public class 权限树 {
    public static void main(String[] args) {

        Set<String> auths = new TreeSet<String>() {{
//            add("0");
//            add("11");
            add("112");
//            add("13");
//            add("131");
            add("1311");
            add("132");
            add("13222222");
        }};

        final AuthNode root = new AuthNode("0", "0");

        final AuthNode node11 = new AuthNode("11", "11");
        final AuthNode node111 = new AuthNode("111", "111");
        final AuthNode node112 = new AuthNode("112", "112");

        final AuthNode node12 = new AuthNode("12", "12");

        final AuthNode node13 = new AuthNode("13", "13");
        final AuthNode node131 = new AuthNode("131", "131");
        final AuthNode node1311 = new AuthNode("1311", "1311");
        final AuthNode node1312 = new AuthNode("1312", "1312");

        final AuthNode node132 = new AuthNode("132", "132");


        root.setAuthNodes(new ArrayList<AuthNode>() {{
            add(node11);
            add(node12);
            add(node13);
        }});

        node11.setAuthNodes(new ArrayList<AuthNode>() {{
            add(node111);
            add(node112);
        }});

        node13.setAuthNodes(new ArrayList<AuthNode>() {{
            add(node131);
            add(node132);
        }});

        node131.setAuthNodes(new ArrayList<AuthNode>() {{
            add(node1311);
            add(node1312);
        }});

        List<AuthNode> authNodes = new ArrayList<AuthNode>() {{
            add(root);
        }};
        printfAuthNode(authNodes);
        getValidAuthNode(authNodes, auths);
        System.out.println("============");
        printfAuthNode(authNodes);

    }

    private static void getValidAuthNode(List<AuthNode> authNodeList, Set<String> auths) {
        if (authNodeList == null || authNodeList.isEmpty()) {
            return;
        }
        for (Iterator<AuthNode> iterator = authNodeList.iterator(); iterator.hasNext(); ) {
            AuthNode node = iterator.next();
            List<AuthNode> authNodes = node.getAuthNodes();
            boolean hasNode = authNodes != null && !authNodes.isEmpty();
            getValidAuthNode(authNodes, auths);
            if (!auths.contains(node.getKey()) && (!hasNode || (node.getAuthNodes() == null || node.getAuthNodes().isEmpty()))) {
                iterator.remove();
            }
        }
    }


    private static void printfAuthNode(List<AuthNode> authNodeList) {
        if (authNodeList == null || authNodeList.isEmpty()) {
            System.out.println("no items");
            return;
        }

        LinkedList<AuthNode> linkedList = new LinkedList<AuthNode>();
        linkedList.addAll(authNodeList);

        while (!linkedList.isEmpty()) {
            AuthNode node = linkedList.poll();
            System.out.println(node.getKey());

            List<AuthNode> authNodes = node.getAuthNodes();

            if (authNodes == null || authNodes.isEmpty()) {
                continue;
            }
            linkedList.addAll(authNodes);
        }
    }
}

class AuthNode {
    private String key;
    private String url;
    private List<AuthNode> authNodes;

    public AuthNode(String key, String url) {
        this.key = key;
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<AuthNode> getAuthNodes() {
        return authNodes;
    }

    public void setAuthNodes(List<AuthNode> authNodes) {
        this.authNodes = authNodes;
    }
}
