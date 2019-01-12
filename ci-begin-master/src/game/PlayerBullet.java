package game;

import game.enemy.Enemy;
import physics.BoxColider;
import game.renderer.Animation;
import physics.Physics;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject implements Physics {
    BoxColider boxColider;

    public PlayerBullet() {
        super(); // this.position = new Vector2D()
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("E:\\Code Intensive\\ci-begin-master\\assets\\images\\player-bullets\\a\\0.png"));
        images.add(SpriteUtils.loadImage("E:\\Code Intensive\\ci-begin-master\\assets\\images\\player-bullets\\a\\1.png"));
        images.add(SpriteUtils.loadImage("E:\\Code Intensive\\ci-begin-master\\assets\\images\\player-bullets\\a\\2.png"));
        images.add(SpriteUtils.loadImage("E:\\Code Intensive\\ci-begin-master\\assets\\images\\player-bullets\\a\\3.png"));
        this.renderer =new Animation(images, 1);
//        BufferedImage image = SpriteUtils.loadImage("assets/images/player-bullets/a/0.png");
//        this.renderer = new SingleImageRenderer(image);
        this.velocity.set(0, -7);
        this.boxColider = new BoxColider(this.position, 30, 30);
    }

    @Override
    public void run() {
        super.run();
//        this.position.add(0, -7);
        Enemy enemy = GameObject.findIntersected(Enemy.class, this.boxColider);
        if (enemy != null) {
            enemy.deActive();
        }
    }


    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }
}
