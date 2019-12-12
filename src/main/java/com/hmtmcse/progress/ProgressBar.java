package com.hmtmcse.progress;

public class ProgressBar {
    private StringBuilder progress;


    public ProgressBar() {
        init();
    }


    public void update(int done, int total) {
        char[] workchars = {'|', '/', '-', '\\'};
        String format = "\r%3d%% %s %c";

        int percent = (++done * 100) / total;
        int extrachars = (percent / 2) - this.progress.length();

        while (extrachars-- > 0) {
            progress.append('#');
        }
//        System.out.println("-------------------------");

        System.out.printf(format, percent, progress,
                workchars[done % workchars.length]);
        System.out.flush();
        if (done == total) {
            System.out.flush();
            System.out.println();
            init();
        }
    }

    private void init() {
        this.progress = new StringBuilder(60);
    }
}
