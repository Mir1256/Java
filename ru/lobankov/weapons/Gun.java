package ru.lobankov.weapons;

public class Gun extends Weapon{
    private final int maxBullet;
    private static final int BASE_AMMO = 5;

    public Gun(int ammo, int maxBullet){
        if (maxBullet < 1) {
            throw new IllegalArgumentException("Max count of bullets must be positive");
        }
        if (ammo < 0) {
            throw new IllegalArgumentException("Ammo can not be negative");
        }
        if (ammo > maxBullet){
            throw new IllegalArgumentException("Ammo must not be greater than max count of bullets");
        }
        super(ammo);
        this.maxBullet = maxBullet;
    }
    public Gun(int maxBullet){
        if (maxBullet < 1){
            throw new IllegalArgumentException("Max count of bullets must be positive");
        }
        super(0);
        this.maxBullet = maxBullet;
    }

    public Gun(){
        super(BASE_AMMO);
        this.maxBullet = BASE_AMMO;
    }

    public int getMaxBullet() {
        return maxBullet;
    }

    public int reload(int bullets){
        if (bullets < 0) {
            throw new IllegalArgumentException("Count of bullets can not be negative");
        }

        int res = super.ammo() + bullets;

        if (res < this.maxBullet){
            super.load(res);
            return 0;
        }
        super.load(this.maxBullet);
        return res - this.maxBullet;
    }

    public int discharge(){
        int resBullet = Math.max(super.ammo(), 0);
        super.load(0);
        return resBullet;
    }

    public boolean isLoaded(){
        return ammo() > 0;
    }

    @Override
    public void shoot(){
        if (ammo() < 1){
            System.out.println("Клац!");
            return;
        }
        System.out.println("Бах!");
        getAmmo();
    }
}
