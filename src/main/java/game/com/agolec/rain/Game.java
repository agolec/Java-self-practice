package game.com.agolec.rain;

/**
 * From playlist off Youtube: https://www.youtube.com/watch?v=S_CIHzdpgE8&list=PLlrATfBNZ98eOOCk2fOFg7Qg5yoQfFAdf&index=4
 *
 * Author: Agolec
 *
 * Date Began: 7/10/2023
 *
 * Youtuber: The Cherno.
 *
 * Youtube video recorded: 2013
 */

import javax.swing.JFrame;
import java.awt.*;

public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;
    public final static int WIDTH = 300;
    public final static int RATIO_UPPER_TERM = 16;
    public final static int RATIO_LOWER_TERM = 9;
    public final static int HEIGHT = WIDTH / RATIO_UPPER_TERM * RATIO_LOWER_TERM;
    public final static int SCALE_MULTIPLIER = 3;
    private Thread thread;
    private JFrame frame;
    private boolean running = false;

    public Game(){
        Dimension size = new Dimension(
                (WIDTH * SCALE_MULTIPLIER),
                (HEIGHT * SCALE_MULTIPLIER)
        );
        setPreferredSize(size);
        frame = new JFrame();
    }

    /**
     * We're writing synchronized so that we can prevent thread interferences and memory consistency errors.
     */
    public synchronized void start(){
        running = true;
        thread = new Thread(this, "Display".toUpperCase());
        thread.start();
    }

    /**
     * Stop Thread.
     */
    public synchronized void stop(){
        //set running to false outside the try catch so that it is always set no matter what.
        running = false;
        try{
            thread.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void run(){
        while(running){
            System.out.println("Running...");
        }
    }
    public static void main(String[] args){
        Game game = new Game();
        game.frame.setResizable(false);
        game.frame.setTitle("Rain");
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);

        game.start();
    }

}
