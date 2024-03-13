package com.java;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String details = "";
        String incomeDetails = "";
        String outcomeDetails = "";
        int outcome = 0;
        int money = 0;
        int total = 0;
       while(true){
           System.out.println("------欢迎使用小鲨鱼记账系统-------");
           System.out.println("1.收支明细");
           System.out.println("2.登记收入");
           System.out.println("3.登记支出");
           System.out.println("4.退出");
           System.out.print("请输入你要选择的功能：");
           Scanner sc = new Scanner(System.in);
           int choice = sc.nextInt();
           while(choice!=1&&choice!=2&&choice!=3&&choice!=4){
               System.out.println("请重新录入！");
               choice = sc.nextInt();
           }
           switch (choice) {
               case 1:
                   System.out.println("记账系统 》》收支明细：");
                   System.out.println(details);
                   break;
               case 2:
                   System.out.println("记账系统 》》登记收入");
                   System.out.print("请录入收入金额：");
                   money = sc.nextInt();
                   total += money;
                   System.out.print("请录入收入来源：");
                   incomeDetails = sc.next();
                   details += details + "收入：" + money + "  " + "收入来源：" + incomeDetails +"\n";
                   break;
               case 3:
                   System.out.println("记账系统 》》登记支出");
                   System.out.print("请输入支出金额：");
                   outcome = sc.nextInt();
                   total -=  outcome;
                   System.out.print("请输入支出明细：");
                   outcomeDetails = sc.next();
                   details += details + "支出：" + outcome + "支出明细：" + outcomeDetails + "\n";
                   break;
               case 4:
                   System.out.println("记账系统 》》退出");
                   System.out.println("当前余额为：" + total);
                   return;
           }
       }
    }
}
