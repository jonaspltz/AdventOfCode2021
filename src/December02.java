import java.util.ArrayList;
import java.util.List;

public class December02 {

    private int horizontal;
    private int depth;
    private int aim;
    private final List<String> action = new ArrayList<>();
    private final List<Integer> value = new ArrayList<>();


    public December02() {
        this.horizontal = 0;
        this.depth = 0;
        this.aim = 0;
    }

    public void executeCommands() {
        for (int i = 0; i < this.action.size(); i++) {
            String action = this.action.get(i);
            switch (action) {
                case "forward":
                    this.forward(this.value.get(i));
                    break;
                case "down":
                    this.down(this.value.get(i));
                    break;
                case "up":
                    this.up(this.value.get(i));
                    break;
            }
        }
    }

    public void splitList(List<String> data) {
        for (String value : data) {
            String command = value.replaceAll(" ", "");
            this.action.add(command.substring(0, command.length() - 1));
            this.value.add(Integer.valueOf(command.substring(command.length() - 1)));
        }
    }

    public void forward(int x) {
        this.horizontal = this.horizontal + x;
        this.depth = this.depth + (this.aim * x);
    }

    public void up(int x) {
        this.aim = this.aim - x;
    }

    public void down(int x) {
        this.aim = this.aim + x;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public int getDepth() {
        return depth;
    }
}
