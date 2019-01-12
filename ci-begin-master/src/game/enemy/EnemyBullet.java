package game.enemy;

import game.GameObject;
import game.Player;
import game.renderer.Animation;
import physics.BoxColider;
import physics.Physics;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyBullet extends GameObject implements Physics {
    BoxColider boxColider;

    public EnemyBullet() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("E:\\Code Intensive\\ci-begin-master\\assets\\images\\enemies\\bullets\\blue.png"));
        this.renderer = new Animation( images, 2);
        this.velocity.set(0 , 7);
        this.boxColider = new BoxColider(this.position, 30, 30);
    }

    @Override
    public void run() {
        super.run();
        Player player = GameObject.findIntersected(Player.class, this.boxColider);
        if (player != null) {
            player.deActive();
        }
    }

    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }
}
