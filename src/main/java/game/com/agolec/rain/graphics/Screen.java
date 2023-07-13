package game.com.agolec.rain.graphics;

import java.util.Random;

public class Screen {
    private int width,height;
    public int[] pixels;
    int count = 0;

    public Screen(int width,int height){
        this.width = width;
        this.height = height;

        pixels = new int[width * height];
    }
    public void clear(){
        for(int i = 0; i < pixels.length; i++){ //50,400 pixels.
            pixels[i] = 0;
        }
    }
    public void render(){
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                pixels[x + y * width] = 0xFF00FF;
            }
        }
    }
}
