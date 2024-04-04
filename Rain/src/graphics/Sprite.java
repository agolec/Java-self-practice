package graphics;

public class Sprite {
    public final int SIZE;
    private int x,y;
    public int[] pixels;
    private SpriteSheet sheet;
    public static Sprite grass = new Sprite(16,0,0,SpriteSheet.tiles);
    public Sprite(int size,int x, int y, SpriteSheet sheet){
        this.SIZE = size;
        this.pixels = new int[SIZE * SIZE];
        this.x = x * size;
        this.y = y * size;
        this.sheet = sheet;
        load();
    }
    private void load() {
        for(int verticalPixelPositionInSprite = 0; verticalPixelPositionInSprite < SIZE;verticalPixelPositionInSprite++){
            for(int horizontalPixelPositionInSprite = 0; horizontalPixelPositionInSprite < SIZE; horizontalPixelPositionInSprite++){
                pixels[horizontalPixelPositionInSprite+verticalPixelPositionInSprite*SIZE] = sheet.pixels[(horizontalPixelPositionInSprite+this.x) + (verticalPixelPositionInSprite + this.y) * sheet.SIZE];
            }
        }
    }
}
