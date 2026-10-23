package tasker;

public class MachineGun extends Gun{
    private final int rateOfFire;

    public MachineGun(int maxBullet, int rateOfFire){
        super(maxBullet, maxBullet);
        this.rateOfFire = rateOfFire;
    }

    public MachineGun(int maxBullet) {
        this(maxBullet, maxBullet/2);
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
