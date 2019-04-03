package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caoyixiong
 * @Date: 2018/12/19
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 * <p>
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 示例
 * 输入: "25525511135
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class 复原IP地址 {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        ipAddress(s, 0, "", list);
        return list;
    }

    public void ipAddress(String in, int n, String out, List<String> list) {
        if (n == 4) {
            if (in.isEmpty()) {
                list.add(out);
            }
            return;
        }

        for (int i = 1; i < 4; i++) {
            if (in.length() < i) {
                break;
            }
            int val = Integer.parseInt(in.substring(0, i));
            if (val > 255 || i != String.valueOf(val).length()) {
                continue;
            }
            ipAddress(in.substring(i), n + 1, out + in.substring(0, i) + ((n == 3) ? "" : "."), list);
        }
    }
}
