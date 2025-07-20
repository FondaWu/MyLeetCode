package stack;

import java.util.Stack;

/**
 * 71. 简化路径（中等）
 * 【描述】
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为 更加简洁的规范路径。
 * 在 Unix 风格的文件系统中规则如下：
 * 一个点 '.' 表示当前目录本身。
 * 此外，两个点 '..' 表示将目录切换到上一级（指向父目录）。
 * 任意多个连续的斜杠（即，'//' 或 '///'）都被视为单个斜杠 '/'。
 * 任何其他格式的点（例如，'...' 或 '....'）均被视为有效的文件/目录名称。
 * 返回的 简化路径 必须遵循下述格式：
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 返回简化后得到的 规范路径 。
 * <p>
 * 【示例】
 * 示例 1：
 * 输入：path = "/home/"
 * 输出："/home"
 * 解释：
 * 应删除尾随斜杠。
 * 示例 2：
 * 输入：path = "/home//foo/"
 * 输出："/home/foo"
 * 解释：
 * 多个连续的斜杠被单个斜杠替换。
 * 示例 3：
 * 输入：path = "/home/user/Documents/../Pictures"
 * 输出："/home/user/Pictures"
 * 解释：
 * 两个点 ".." 表示上一级目录（父目录）。
 * 示例 4：
 * 输入：path = "/../"
 * 输出："/"
 * 解释：
 * 不可能从根目录上升一级目录。
 * <p>
 * 示例 5：
 * 输入：path = "/.../a/../b/c/../d/./"
 * 输出："/.../b/d"
 * 解释：
 * "..." 在这个问题中是一个合法的目录名。
 * 【提示】
 * 1 <= path.length <= 3000
 * path 由英文字母，数字，'.'，'/' 或 '_' 组成。
 * path 是一个有效的 Unix 风格绝对路径。
 */
public class SimplifyPath {

    public static void main(String[] args) {
        //String path = "/home//foo/";
        String path = "/home/user/Documents/../Pictures";
        //String path = "/a//b////c/d//././/..";
        String result = new SimplifyPath().simplifyPath(path);
        System.out.println("计算结果：" + result);
    }

    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        String split = "/";
        String[] strs = path.split(split);
        int skip = 0;
        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i].compareToIgnoreCase("..") == 0) {
                skip++;
            } else {
                if (strs[i].compareToIgnoreCase("") != 0 && strs[i].compareToIgnoreCase(".") != 0) {
                    if (skip == 0) {
                        sb.insert(0, split + strs[i]);
                    } else skip--;
                }
            }
        }
        String result = sb.toString();
        return result.isEmpty() ? "/" : result;
    }

    public String simplifyPath2(String path) {
        StringBuilder sb = new StringBuilder();
        char ch = '/';
        int fromIndex = path.length();
        int inx = path.lastIndexOf(ch, fromIndex);
        int skip = 0;
        while (inx >= 0) {
            String str = path.substring(inx, fromIndex);
            if (str.compareToIgnoreCase("/..") == 0) {
                skip++;
            } else {
                if (str.compareToIgnoreCase("/") != 0 && str.compareToIgnoreCase("/.") != 0) {
                    if (skip == 0) sb.insert(0, str);
                    else skip--;
                }
            }
            fromIndex = inx;
            inx = path.lastIndexOf(ch, fromIndex - 1);
        }
        String result = sb.toString();
        return result.isEmpty() ? "/" : result;
    }

    public String simplifyPath1(String path) {
        Stack<String> stk = new Stack<>();
        char ch = '/';
        int fromIndex = path.length();
        int inx = path.lastIndexOf(ch, fromIndex);
        int skip = 0;
        while (inx >= 0) {
            String str = path.substring(inx, fromIndex);
            if (str.compareToIgnoreCase("/..") == 0) {
                skip++;
            } else {
                if (str.compareToIgnoreCase("/") != 0 && str.compareToIgnoreCase("/.") != 0) {
                    if (skip == 0) stk.push(str);
                    else skip--;
                }
            }
            fromIndex = inx;
            inx = path.lastIndexOf(ch, fromIndex - 1);
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.empty()) {
            sb.append(stk.pop());
        }
        String result = sb.toString();
        return result.isEmpty() ? "/" : result;
    }
}
