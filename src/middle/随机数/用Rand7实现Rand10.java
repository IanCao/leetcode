package middle.随机数;

/**
 * @author caoyixiong
 * @Date: 2019/4/2
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 *
 * 题目：现在有一个随机函数 能够随机出 1-7的随机值，根据此函数创建一个1-10的随机数
 *   首先 rand7()-1得到一个离散整数集合{0，1，2，3，4，5，6}, 其中每个整数的出现概率都是1/7。
 *   那么(rand7()-1)*7得到一个离散整数集合A={0，7，14，21，28，35，42}，其中每个整数的出现概率也都是1/7。
 *   而rand7()得到的集合B={1，2，3，4，5，6，7}
 *
 *   故(rand7()-1)*7 + rand7() 会产生1- 49的随机数，剔除41 - 49的数值之后，剩余的数字的概率也都是相同的
 */
public class 用Rand7实现Rand10 {
    public int rand10() {
        int x = 0;
        do {
            x = (rand7() - 1) * 7 + rand7();
        } while (x > 40);
        return x % 10 + 1;
    }

    private int rand7() {
        return 0;
    }
}
