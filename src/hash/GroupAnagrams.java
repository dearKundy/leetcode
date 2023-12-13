package hash;

import java.util.*;

/**
 * 哈希-字母异位词分组
 *
 * @author kundy
 * @date 2023/11/6 22:03
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            // 含有的字母全部相同的即为一个字母异位词，所以排序后拼接成一个字符串（规范化）
            Arrays.sort(charArray);
            String key = new String(charArray);

            // 含有字母相同的放在同一个集合中
            List<String> orDefault = res.getOrDefault(key, new ArrayList<>());
            orDefault.add(str);

            res.put(key, orDefault);

        }

        return new ArrayList<>(res.values());

    }

    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new GroupAnagrams().groupAnagrams(strings);

        lists.forEach(System.out::println);
    }


}
