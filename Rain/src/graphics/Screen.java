package graphics;

import java.util.Random;

public class Screen {
    private int width,height;
    public int[] pixels;
    public final int MAP_SIZE = 64;
    public final int MAP_SIZE_MASK = MAP_SIZE - 1;

    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
    private Random random = new Random();

    public Screen(int width,int height){
        this.width = width;
        this.height = height;
        pixels = new int[width * height];

        for(int i = 0; i < tiles.length; i++){
            tiles[i] = random.nextInt(0xffffff);
        }

    }
    public void clear(){
        for(int i = 0; i < pixels.length; i++){ //50,400 pixels.
            pixels[i] = 0;
        }
    }
    public void render(int xOffset, int yOffset){
        for(int y = 0; y < height; y++){
            int yy = y + yOffset;
            for(int x = 0; x < width; x++){
                int xx = x + xOffset;
                final int TILE_FACTOR = 4;
                //how big our tiles should be by pixel area.
                int tileIndex = ((xx >> TILE_FACTOR) & MAP_SIZE_MASK) + ((yy >> TILE_FACTOR) & MAP_SIZE_MASK) * MAP_SIZE;
                pixels[x + y * width] = Sprite.grass.pixels[((x&15) + (y&15) * Sprite.grass.SIZE)];
            }
        }
    }
}

