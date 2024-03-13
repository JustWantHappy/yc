package com.java;

public class ThreadBlock {
    private void loop(){
        String s = "";
        synchronized (""){
            System.out.println("线程被阻塞，10分钟后结束！");
            try{
                Thread.sleep(600000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return;
        }
    }
    public void block(String str){
        Thread t1 = new Thread(() -> this.loop());
        Thread t2 = new Thread(() -> this.loop());
        t1.start();
        t2.start();
    }

    public void high(){
        new Thread(() -> {
            long i = 0;
            while(true){
                ++i;
            }
        }).start();
    }

    public static void main(String[] args) {
        ThreadBlock th = new ThreadBlock();
      //  th.block("sss");
        th.high();


    }

}
