package rain;

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

import graphics.Screen;
import input.Keyboard;

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
    public static String title = "Rain";
    private Thread thread;
    private JFrame frame;
    private Keyboard key;
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
        key = new Keyboard();

        addKeyListener(key);
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

    /**
     * The run method calculates the time it takes between line 'long firstTick = System.nanoTime()
     * and line 'long secondTick = System.nanoTime()' and divides it by 1/60th of a nanosecond
     *
     */
    public void run(){
        final double NANOSECOND = 1000000000.0 / 60.0;
        long firstTick = System.nanoTime();
        long timer = System.currentTimeMillis();

        double delta = 0;
        int frames = 0;
        int updates = 0;

        while(running){
            long secondTick = System.nanoTime();
            delta += (secondTick - firstTick) / NANOSECOND;
            firstTick = secondTick;

            while(delta >= 1) {
                update();
                updates++;
                delta--;
            }

            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                frame.setTitle(title + " | " + updates + " updates, " + frames + " fps");
                updates = 0;
                frames = 0;
            }

        }

        stop();
    }
    int x = 0, y = 0;
    public void update(){

        key.update();

        if(key.up) y--;
        if(key.down) y++;
        if(key.right) x++;
        if(key.left) x--;

    }
    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(4);
            return;
        }
        screen.clear();
        screen.render(x,y);



        for(int i = 0; i < pixels.length;i++){
            pixels[i] = screen.pixels[i];
        }
        Graphics g = bs.getDrawGraphics();
        g.fillRect(0,0,getWidth(),getHeight());
        g.drawImage(image,0,0,getWidth(),getHeight(),null);
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
