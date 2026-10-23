package ru.lobankov.weapons;

public class MachineGun extends Gun{
    private final int rateOfFire;

    public MachineGun(int maxBullet, int rateOfFire){
        if (rateOfFire < 1){
            throw new IllegalArgumentException("Rate of fire must be positive");
        }
        super(maxBullet, maxBullet);
        this.rateOfFire = rateOfFire;
    }

    public MachineGun(int maxBullet) {
        this(maxBullet, Math.max(maxBullet/2,1));
    }
    public MachineGun(){
        this(30,30);
    }

    public int getRateOfFire() {
        return rateOfFire;
    }

    @Override
    public void shoot() {
        shoot(1);
    }

    public void shoot(int second) {
        for (int i = 0; i < second * this.rateOfFire; i++) {
            super.shoot();
        }
    }
}
