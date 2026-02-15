import java.util.List;

class AssassinManager implements GameManager {
    AssassinNode head;
    AssassinNode graveYardHead;
    int size = 0;
    AssassinManager(List<String> gameList) {
        AssassinNode temp = null;
        size = gameList.size();
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
        String next;
        while(temp != null) {
            if (temp.next == null) {
                next = head.name;
            }
            else {
                next = temp.next.name;
            }
            System.out.println(temp.name +" is tagging "+next);
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

    private boolean findFromHead(AssassinNode startingNode, String nameToFind) {
        AssassinNode temp = startingNode;
        while(temp != null) {
            if(temp.name.equals(nameToFind)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public boolean killRingContains(String name) {
        return findFromHead(head, name);
    }

    @Override
    public boolean graveyardContains(String name) {
        return findFromHead(graveYardHead, name);
    }

    @Override
    public boolean gameOver() {
        return size == 1;
    }

    @Override
    public String winner() {
        if(size == 1) return head.name;
        return null;
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
            size--;
            return;
        }

        while (curr.next != null) {
            if(curr.next.name.equals(name)) {
                temp = curr.next;
                curr.next = curr.next.next;
                temp.next = graveYardHead;
                graveYardHead = temp;
                size--;
                return;
            }
            curr = curr.next;
        }
    }
}