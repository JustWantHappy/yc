package com.java;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        int[] balls = new int[7];
        String str = "";
        while (true) {
            System.out.println("-----欢迎登录双色球系统！------");
            System.out.println("输入1进行彩票购买！");
            System.out.println("输入2查看是否中奖！");
            System.out.println("输入3退出！");
            int choice = 0;
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
            while (choice != 1 && choice != 2 && choice != 3) {
                System.out.println("输入有误，请重新输入！");
                choice = in.nextInt();
            }
            switch (choice) {
                case 1:
                    System.out.println("请输入你要购买的彩票号码，六个红色球和一个蓝色球！(红色球1-66，蓝色球1-33）");
                    for (int i = 0; i < 7; i++) {
                        if (i != 6) {
                            System.out.print("请输入第" + (i + 1) + "个红色球号码！");
                            str = in.next();
                            while (true) {
                                if (RedisLegal(str)) {
                                    balls[i] = Integer.parseInt(str);
                                    break;
                                } else {
                                    System.out.println("输入不合法，请重新输入！");
                                    System.out.print("请输入第" + (i + 1) + "个红色球号码！");
                                    str = in.next();
                                }
                            }
                        } else {
                            System.out.print("请输入蓝色球号码:");
                            str = in.next();
                            while (true) {
                                if (BlueisLegal(str)) {
                                    balls[i] = Integer.parseInt(str);
                                    break;
                                } else {
                                    System.out.println("输入不合法，请重新输入！");
                                    System.out.print("请输入蓝色球号码:");
                                    str = in.next();
                                }
                            }
                        }
                    }
                    System.out.println("输入完成，您输入的号码为：");
                    for (int num : balls) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    break;
                case 2:
                    if(balls[0] == 0){
                        System.out.println("对不起，你还未输入号码！");
                        break;
                    }
                    System.out.println("恭喜您，您中的奖为：" + level(balls));

                    break;
                case 3:
                    return;
            }
        }

    }


    //检验红球是否合法

    public static boolean RedisLegal(String str) {
        int tmp = 0;
        try {
            tmp = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return tmp > 0 && tmp < 67;
    }

    //检验蓝球是否合法
    public static boolean BlueisLegal(String str) {
        int tmp = 0;
        try {
            tmp = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return tmp > 0 && tmp < 34;
    }

    public static int level(int[] arr) {
        int level = 0;
        int[] random = new int[7];
        int RedCount = 0;
        int BlueCount = 0;
        for (int i = 0; i < 7; i++) {
            if (i != 6) {
                random[i] = (int) (Math.random() * 66) + 1;
            } else {
                random[i] = (int) (Math.random() * 33) + 1;
            }
        }
        for (int i = 0; i < 7; i++) {
            if (i != 6) {
                for (int j = 0; j < 6; j++) {
                    if (arr[j] == random[i]) {
                        RedCount++;
                    }
                }
            } else {
                BlueCount = arr[6] == random[6] ? 1 : 0;
            }
        }
        if(RedCount == 6 && BlueCount == 1){
            level = 1;
        }else if(RedCount == 5 && BlueCount == 1)
            level = 2;
        else if(RedCount == 4 && BlueCount == 1)
            level = 3;
        else level = 4;

        return level;
    }

}
