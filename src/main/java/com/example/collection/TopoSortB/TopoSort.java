package com.example.collection.TopoSortB;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


/**
 * Created by zhangpan on 2019/3/30.
 */
public class TopoSort {
    /**
     * ��������ڵ���
     */
    private static class Node {
        public Object val;
        public int pathIn = 0; // ����·����
        public Node(Object val) {
            this.val = val;
        }
    }

    /**
     * ����ͼ��
     */
    private static class Graph {
        // ͼ�нڵ�ļ���
        public Set<Node> vertexSet = new HashSet<Node>();
        // ���ڵĽڵ㣬��¼��
        public Map<Node, Set<Node>> adjaNode = new HashMap<Node, Set<Node>>();

        // ���ڵ����ͼ��
        public boolean addNode(Node start, Node end) {
            if (!vertexSet.contains(start)) {
                vertexSet.add(start);
            }
            if (!vertexSet.contains(end)) {
                vertexSet.add(end);
            }
            if (adjaNode.containsKey(start)
                    && adjaNode.get(start).contains(end)) {
                return false;
            }
            if (adjaNode.containsKey(start)) {
                adjaNode.get(start).add(end);
            } else {
                Set<Node> temp = new HashSet<Node>();
                temp.add(end);
                adjaNode.put(start, temp);
            }
            end.pathIn++;
            return true;
        }
    }

    //Kahn�㷨
    private static class KahnTopo {
        private List<Node> result; // �����洢�����
        private Queue<Node> setOfZeroIndegree; // �����洢���Ϊ0�Ķ���
        private Graph graph;

        //���캯������ʼ��
        public KahnTopo(Graph di) {
            this.graph = di;
            this.result = new ArrayList<Node>();
            this.setOfZeroIndegree = new LinkedList<Node>();
            // �����Ϊ0�ļ��Ͻ��г�ʼ��
            for(Node iterator : this.graph.vertexSet){
                if(iterator.pathIn == 0){
                    this.setOfZeroIndegree.add(iterator);
                }
            }
        }

        //�������������
        private void process() {
            while (!setOfZeroIndegree.isEmpty()) {
                Node v = setOfZeroIndegree.poll();

                // ����ǰ������ӵ��������
                result.add(v);

                if(this.graph.adjaNode.keySet().isEmpty()){
                    return;
                }

                // ������v���������б�
                for (Node w : this.graph.adjaNode.get(v) ) {
                    // ���ñߴ�ͼ���Ƴ���ͨ�����ٱߵ���������ʾ
                    w.pathIn--;
                    if (0 == w.pathIn) // ������Ϊ0����ô�������Ϊ0�ļ���
                    {
                        setOfZeroIndegree.add(w);
                    }
                }
                this.graph.vertexSet.remove(v);
                this.graph.adjaNode.remove(v);
            }

            // �����ʱͼ�л����ڱߣ���ô˵��ͼ�к��л�·
            if (!this.graph.vertexSet.isEmpty()) {
                throw new IllegalArgumentException("Has Cycle !");
            }
        }

        //�����
        public Iterable<Node> getResult() {
            return result;
        }
    }

    //����
    public static void main(String[] args) {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");

        Graph graph = new Graph();
        graph.addNode(A, B);
        graph.addNode(B, C);
        graph.addNode(B, D);
        graph.addNode(D, C);
        graph.addNode(E, C);
        graph.addNode(C, F);

        KahnTopo topo = new KahnTopo(graph);
        topo.process();
        for(Node temp : topo.getResult()){
            System.out.print(temp.val.toString() + "-->");
        }
    }


}
