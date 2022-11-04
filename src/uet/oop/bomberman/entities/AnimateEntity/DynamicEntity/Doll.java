package uet.oop.bomberman.entities.AnimateEntity.DynamicEntity;

import static uet.oop.bomberman.BombermanGame.menu;

import uet.oop.bomberman.graphics.Sprite;

public class Doll extends DynamicEntity {

    public Doll(int x, int y) {
        super(x, y, Sprite.doll_left1.getFxImage());
        direction = random.nextInt(4);
    }

    public void speedUp() {
        if (animate < 20) {
            speed = 3;
        } else {
            speed = 1;
        }
    }

    @Override
    public void update() {
        if (menu.getGameState() == menu.getPlayState()) {
            animateSprite();
            animate++;
            if (animate > 20) {
                animate = 0;
            }
            move();
            if (isDead) {
                time++;
                if (time == 60) {
                    isOff = true;
                }
            }
        }
    }

    @Override
    public void animateSprite() {
        if (!isDead) {
            if (direction == 0 || direction == 2) {
                img = Sprite.movingSprite(Sprite.doll_right1, Sprite.doll_right2,
                        Sprite.doll_right3,
                        animate, 18).getFxImage();
            } else if (direction == 1 || direction == 3) {
                img = Sprite.movingSprite(Sprite.doll_left1, Sprite.doll_left2,
                        Sprite.doll_left3,
                        animate, 18).getFxImage();
            }
        } else {
            img = Sprite.movingSprite(Sprite.doll_dead, Sprite.mob_dead2, Sprite.mob_dead3, animate, 18)
                    .getFxImage();
        }
    }

    @Override
    public void move() {
        int y1, x1;
        switch (direction) {
            case 0:
                y1 = y - speed;
                if (!checkStaticObject(x, y1)) {
                    y = y1;
                } else {
                    speedUp();
                    int[] nums = { 1, 2, 3 };
                    direction = nums[random.nextInt(nums.length)];
                }
                break;
            case 1:
                y1 = y + speed;
                if (!checkStaticObject(x, y1)) {
                    y = y1;
                } else {
                    speedUp();
                    int[] nums = { 0, 2, 3 };
                    direction = nums[random.nextInt(nums.length)];
                }
                break;
            case 2:
                x1 = x - speed;
                if (!checkStaticObject(x1, y)) {
                    x = x1;
                } else {
                    speedUp();
                    int[] nums = { 0, 1, 3 };
                    direction = nums[random.nextInt(nums.length)];
                }
                break;
            case 3:
                x1 = x + speed;
                if (!checkStaticObject(x1, y)) {
                    x = x1;
                } else {
                    speedUp();
                    int[] nums = { 0, 1, 2 };
                    direction = nums[random.nextInt(nums.length)];
                }
                break;
        }
    }

    public String getName() {
        return "Doll";
    }

}
