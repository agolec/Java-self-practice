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

import game.com.agolec.rain.graphics.Screen;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

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
    private Screen screen;
    /**
     * Rasters are rectangle arrays of pixels.
     *
     * Need to retrieve a writable raster.
     */
    private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)
            image.getRaster().getDataBuffer()
            ).getData();

    public Game(){
        Dimension size = new Dimension((WIDTH * SCALE_MULTIPLIER), (HEIGHT * SCALE_MULTIPLIER));
        setPreferredSize(size);
        screen = new Screen(WIDTH,HEIGHT);
        frame = new JFrame();
    }

    /**
     * We're writing synchronized so that we can prevent thread interferences and memory consistency errors.
     */
    public synchronized void start(){
        running = true;
        thread = new Thread(this, "Display");
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
            update();
            render();
        }
    }
    public void update(){

    }
    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(new Color(30,255,30));
        g.fillRect(0,0,getWidth(),getHeight());
        g.dispose();
        bs.show();


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
