#!/usr/bin/env bash
set -u
set -e
bak=$IFS                                         #定义一个变量bak保存IFS的值
if [ $# -ne 1 ];then                          #判断位置参数是否为1
   echo "Usage $0 filename"
   exit
fi
if [ ! -f $1 ];then                              #判断位置参数是否为文件
   echo "the $1 is not a file"
   exit
fi
IFS=$'\n'                                        #将环境变量IFS的值修改为换行符
for i in `cat $1`                                #逐行读取文件内容并打印到屏幕
do
#   echo $i
   array=(${i//,/ })
   for var in ${array[@]}
   do
       echo $var + $'\n'
   done

done

IFS=$bak                                       #将环境变量IFS的值改回原值