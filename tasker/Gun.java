package tasker;

public class Gun extends Weapon{
    private final int maxBullet;
    private static final int BASE_AMMO = 5;

    public Gun(int ammo, int maxBullet){
        super(ammo);
        this.maxBullet = maxBullet;
    }
    public Gun(int maxBullet){
        super(maxBullet);
        this.maxBullet = maxBullet;
    }

    public int getMaxBullet() {
        return maxBullet;
    }

    public int reload(int bullets){
        if (bullets < 0) {
            throw new IllegalArgumentException("Мало патронов");
        }
        if (bullets > maxBullet){
            super.load(bullets);
        }
        return bullets - this.maxBullet;
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
            System.out.println("КЛАЦ!");
            return;
        }
        System.out.println("БАХ!!");
        getAmmo();
    }
}
