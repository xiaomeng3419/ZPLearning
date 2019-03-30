package com.example.collection.dictionaryTree;

import lombok.Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangpan on 2019/3/30.
 */
@Data
public class Trie {
    private TrieNode root;
    Trie() // ��ʼ���ֵ���
    {
         this.root = new TrieNode();
    }

    class TrieNode // �ֵ����ڵ�
    {
        private int num;// �ж��ٵ���ͨ������ڵ�,���ɸ����ýڵ���ɵ��ַ���ģʽ���ֵĴ���
        private TrieNode[] son;// ���еĶ��ӽڵ�
        private boolean isEnd;// �ǲ������һ���ڵ�
        private char val;// �ڵ��ֵ

        TrieNode()
        {
            num = 1;
            son = new TrieNode[DictionaryUtil.DictionaryParams.SIZE.getCapacity()];
            isEnd = false;
        }
    }

    // �����ֵ���
    public void insert(String str) // ���ֵ����в���һ������
    {
        if (str == null || str.length() == 0)
        {
            return;
        }
        TrieNode node = root;
        char[] letters = str.toCharArray();//��Ŀ�굥��ת��Ϊ�ַ�����
        for (int i = 0, len = str.length(); i < len; i++)
        {
            int pos = letters[i] - 'a';
            if (node.son[pos] == null)  //�����ǰ�ڵ�Ķ��ӽڵ���û�и��ַ����򹹽�һ��TrieNode����ֵ���ַ�
            {
                node.son[pos] = new TrieNode();
                node.son[pos].val = letters[i];
            }
            else   //����Ѿ����ڣ����ɸ����ö��ӽڵ���ɵ��ַ���ģʽ���ֵĴ���+1
            {
                node.son[pos].num++;
            }
            node = node.son[pos];
        }
        node.isEnd = true;
    }



    // ���ֵ����в���һ����ȫƥ��ĵ���.
    public boolean has(String str)
    {
        if(str==null||str.length()==0)
        {
            return false;
        }
        TrieNode node=root;
        char[]letters=str.toCharArray();
        for(int i=0,len=str.length(); i<len; i++)
        {
            int pos=letters[i]-'a';
            if(node.son[pos]!=null)
            {
                node=node.son[pos];
            }
            else
            {
                return false;
            }
        }
        //�ߵ���һ��������������ȫƥ�䣬Ҳ���ܲ���ƥ�䣬������һ���ַ��ڵ�Ϊĩ�˽ڵ㣬������ȫƥ�䣬�����ǲ���ƥ��
        return node.isEnd;
    }


    // ǰ������ֵ���.
    public void preTraverse(TrieNode node)
    {
        if(node!=null)
        {
            System.out.print(node.val+"-");
            for(TrieNode child:node.son)
            {
                preTraverse(child);
            }
        }
    }

    // ���㵥��ǰ׺������
    public int countPrefix(String prefix)
    {
        if(prefix==null||prefix.length()==0)
        {
            return-1;
        }
        TrieNode node=root;
        char[]letters=prefix.toCharArray();
        for(int i=0,len=prefix.length(); i<len; i++)
        {
            int pos=letters[i]-'a';
            if(node.son[pos]==null)
            {
                return 0;
            }
            else
            {
                node=node.son[pos];
            }
        }
        return node.num;
    }

    public static void main(String[]args) throws Exception
    {
        Trie tree=new Trie();
        String[] dictionaryData= {"hello","student","computer","sorry","acm","people","experienced","who","reminds","everyday","almost"};
        //�����ֵ�
        for(String str:dictionaryData)
        {
            tree.insert(str);
        }
        String filePath="E:\\txt.txt";
        File file=new File(filePath);
        if(file.isFile() && file.exists())
        {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            Map<String,Integer> countMap=new HashMap<>();
            while((lineTxt = bufferedReader.readLine())!= null)
            {
                if(tree.has(lineTxt))
                {
                    if(countMap.containsKey(lineTxt))
                    {
                        countMap.put(lineTxt, countMap.get(lineTxt)+1);
                    }
                    else
                    {
                        countMap.put(lineTxt, 1);
                    }
                }
                else
                {
                    System.out.println(lineTxt+"�����ֵ��У�");
                }
            }
            for(String s:countMap.keySet())
            {
                System.out.println(s+"���ֵĴ���"+countMap.get(s));
            }
            read.close();
        }
    }

}
