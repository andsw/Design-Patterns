package ProxyPattern;

/**
 * @author hsw
 * @create 2018-10-24  20:08
 */

interface AbstractPermission {
    void modifyUserInfo();
    void viewNote();
    void publishNote();
    void modifyNote();
    void setLevel(int level);
}

class RealPermission implements AbstractPermission {

    private int level;

    @Override
    public void modifyUserInfo() {
        System.out.println("RealPermission is modifying user's information...");
    }

    @Override
    public void viewNote() {
        System.out.println("RealPermission is viewing note...");
    }

    @Override
    public void publishNote() {
        System.out.println("RealPermission is publishing note...");
    }

    @Override
    public void modifyNote() {
        System.out.println("RealPermission is modifying note...");
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }
}

class ProxyPermission implements AbstractPermission {

    RealPermission permission = new RealPermission();
    int level;

    @Override
    public void modifyUserInfo() {
        System.out.println("modifying user's information...");
        permission.modifyUserInfo();
    }

    @Override
    public void viewNote() {
        System.out.println("viewing note...");
        permission.viewNote();
    }

    @Override
    public void publishNote() {
        System.out.println("publishing note...");
        permission.publishNote();
    }

    @Override
    public void modifyNote() {
        System.out.println("modifying note...");
        permission.modifyNote();
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
        permission.setLevel(level);
    }
}

public class ForumPermissionManagement {
    public static void main(String[] args) {
        AbstractPermission permission = new ProxyPermission();
        permission.modifyNote();
        permission.publishNote();
        permission.setLevel(1);
        permission.viewNote();
    }
}
