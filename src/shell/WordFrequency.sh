#!/usr/bin/env bash

awk '{for(i=1;i<=NF;i++)a[$i]++}END{for(i in a) print i"="a[i]}' test.txt |sort -nr -k 2

#
#分析：
#    复习一下awk的语法。
#    awk 是逐行检索文本。分为3部分。
#    BEGIN{#这里进行一些检索文本前的初始化操作}
#    {#这里是对应每一行的操作}。例如这里 for(i=1;i<=NF;++i){++m[$i]}就是将每一行分隔的字段，进行词频统计。
#    NF是分隔的字段数。
#    $0表示整行字符串
#    $1到$NF表示从分隔的第一个字符串到最后一个字符串
#    awk中的数组可以用作hashtable做来词频统计。
#    END{#在检索文本后的操作}
#    for(k in m) k表示的就是m的key。
#sort语法复习
#sort -n 将字符串转数字
#sort -r 指定顺序为从大到小
#sort -k 2 指定第二个字段作为排序判断标准
#    cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -rn | awk '{print $2, $1}'
#
#    tr -s ' ' '\n' 是将所有连续的空格 空行删除并保证每一行只有一个字符串
#    sort | uniq -c 通常一起用来统计重复出现的次数。
