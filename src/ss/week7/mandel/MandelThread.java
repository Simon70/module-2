package ss.week7.mandel;

/**
 * Class for drawing the Mandel in parallel
 */
class MandelThread implements Runnable {
    private MandelPanel mp;

    MandelThread(MandelPanel mpArg) {
        this.mp = mpArg;
    }

    // overrides Thread.run
    // draws the fractal on the MandelPanel
    public void run() {
        mp.drawMandel();
    }
}
