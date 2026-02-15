import java.util.List;

class AssassinManager implements GameManager {
    AssassinNode head;
    AssassinNode graveYardHead;
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
        printFromHead(graveYardHead);
    }

    private void printFromHead(AssassinNode startingNode) {
        AssassinNode temp = startingNode;
        while(temp != null) {
            System.out.println(temp.name);
            temp = temp.next;
        }
    }

    @Override
    public boolean killRingContains(String name) {
        AssassinNode temp = head;
        while(temp != null) {
            if(name.equals(temp.name)) {
                return true;
            }
            temp = temp.next;
        }
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
        AssassinNode curr = head;
        AssassinNode temp;
        if(curr.name.equals(name)) {
            temp = curr;
            head = curr.next;
            temp.next = graveYardHead;
            graveYardHead = temp;
            return;
        }

        while (curr.next != null) {
            if(curr.next.name.equals(name)) {
                temp = curr.next;
                curr.next = curr.next.next;
                temp.next = graveYardHead;
                graveYardHead = temp;
                return;
            }
            curr = curr.next;
        }
    }
}