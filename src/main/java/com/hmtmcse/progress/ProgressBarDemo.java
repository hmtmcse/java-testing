package com.hmtmcse.progress;

public class ProgressBarDemo {

    public static void main(String[] args) {
        ProgressBar bar = new ProgressBar();

        System.out.println("Process Starts Now!");

        bar.update(0, 1000);
        for(int i=0;i<1000;i++) {
            for(int j=0;j<10000000;j++)
                for(int p=0;p<10000000;p++);
            bar.update(i, 1000);
        }
        System.out.println("Process Completed!");
    }
}
