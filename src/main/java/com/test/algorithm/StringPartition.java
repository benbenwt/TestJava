
import java.util.ArrayList;
import java.util.List;

public class StringPartition {
        //标记是否为回文串，及是否计算过。
        int[][] mark;
         //字符串长度
        int len;
        //记录多个合法的截断方式
        List<List<String>> resultList = new ArrayList<List<String>>();
        //记录当前正在搜索的 截断方式
        List<String> result = new ArrayList<String>();


    public static void main(String[] args) {
        StringPartition c1=new StringPartition();
        System.out.println(c1.partition(args[0]));

    }
        public List<List<String>> partition(String s) {
            //字符串长度
            len = s.length();
            //标记是否为回文串，及是否计算过。
            mark = new int[len][len];

            dfs(s, 0);
            return resultList;
        }

        public void dfs(String s, int i) {
            //如果已经遍历到字符串末尾了，说明该截断方式合法，将该种 截断方式 添加到result结果集中。
            if (i == len) {
                resultList.add(new ArrayList<String>(result));
                return;
            }
            //dfs(s,i)表示字符串s，从索引为i至len-1这一段中进行截断。
            //遍历i至len-1的所有截断点的情况
            for (int j = i; j < len; ++j) {
                //如果从i到截断点j是回文字符串，则这种截断点合法。才需要添加截断到ans中，并调用dfs继续深度搜素。
                if (judge(s, i, j) == 1) {
                    //记录截断方式
                    result.add(s.substring(i, j + 1));
                    //从j+1开始搜索后续截断点
                    dfs(s, j + 1);
                    //dfs回溯还原现场，恢复ans记录的值。
                    result.remove(result.size() - 1);
                }
            }
        }
    //mark[i][j] = 0 表示没有计算过是否为回文子串，1 表示计算过，且且是回文串，-1 表示计算过，且不是回文串
    //已经计算过是否为回文的，记录起来，避免递归重复计算。
    public int judge(String s, int i, int j) {
            //计算过了，直接返回
            if (mark[i][j] != 0) {
                return mark[i][j];
            }
            //i>=j，表示取了一个字符。
            if (i >= j) {
                mark[i][j] = 1;
            } else if (s.charAt(i) == s.charAt(j)) {
                //若开头和结尾字符一样，则整个字符串是否为回文，取决于i+1到j+1是否为回文串
                mark[i][j] = judge(s, i + 1, j - 1);
            } else {
                //计算过，且不是回文串
                mark[i][j] = -1;
            }
            return mark[i][j];
        }

}
