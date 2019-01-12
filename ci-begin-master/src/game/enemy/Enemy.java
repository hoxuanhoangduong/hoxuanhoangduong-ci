package game.enemy;

import game.FrameCouter;
import game.Player;
import game.PlayerBullet;
import physics.BoxColider;
import physics.Physics;
import game.GameObject;
import game.renderer.Animation;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject implements Physics {
    BoxColider boxColider;
    FrameCouter fireCouter;

    public Enemy(){
        ArrayList<BufferedImage> images = new ArrayList<>();
        // load & add image
        images.add(SpriteUtils.loadImage("E:\\Code Intensive\\ci-begin-master\\assets\\images\\enemies\\level0\\blue\\0.png"));
        images.add(SpriteUtils.loadImage("E:\\Code Intensive\\ci-begin-master\\assets\\images\\enemies\\level0\\blue\\1.png"));
        images.add(SpriteUtils.loadImage("E:\\Code Intensive\\ci-begin-master\\assets\\images\\enemies\\level0\\blue\\2.png"));
        images.add(SpriteUtils.loadImage("E:\\Code Intensive\\ci-begin-master\\assets\\images\\enemies\\level0\\blue\\3.png"));
        this.renderer = new Animation(images);
        this.position.set(200, 400);
        this.velocity.set(1, 0);
        this.boxColider = new BoxColider(this.position, 30, 30);
        this.fireCouter = new FrameCouter(20);
    }

    private void limitPosition() {
        if (this.position.x > 384 - 32) {
            this.velocity.set(-5, 0);
        }
        if (this.position.x < 0) {
            this.velocity.set(5, 0);
        }
    }

    public void run() {
        super.run();
        limitPosition();
        this.fire();
    }

//    int count; //TODO: continue editing

    private void fire() {
//        this.count++;
        if (fireCouter.run()) {
            EnemyBullet bullet = new EnemyBullet();
            bullet.position.set(this.position);
            this.fireCouter.reset();
        }
    }

    public void takeDamage (){
        PlayerBullet playerBullet = GameObject.findIntersected(PlayerBullet.class, this.boxColider);
        if (playerBullet != null){
            playerBullet.deActive();
            this.deActive();
        }
    }

    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }
}
