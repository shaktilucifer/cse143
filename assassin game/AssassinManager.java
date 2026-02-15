import java.util.List;

class AssassinManager implements GameManager {
    AssassinNode head;
    AssassinManager(List<String> gameList) {
        AssassinNode temp = null;
        for(int i = 0; i < gameList.size(); i++) {
            String name = gameList.get(i);
            if (i == 0) {
                head = new AssassinNode(name, null);
                temp = head;
            } else {
                temp.next = new AssassinNode(name);
                temp = temp.next;
            }
        }
    }

    @Override
    public void printKillRing() {
        AssassinNode temp = head;
        while(temp != null) {
            System.out.println(temp.name);
            temp = temp.next;
        }
    }

    @Override
    public void printGraveyard() {

    }

    @Override
    public boolean killRingContains(String name) {
        return false;
    }

    @Override
    public boolean graveyardContains(String name) {
        return false;
    }

    @Override
    public boolean gameOver() {
        return false;
    }

    @Override
    public String winner() {
        return "";
    }

    @Override
    public void kill(String name) {

    }
}