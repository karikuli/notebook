package notebook;

import asg.cliche.Shell;
import asg.cliche.ShellFactory;

import java.io.IOException;

/**
 * Created by karikuli on 09.05.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Notebook commands = new Notebook();

        Shell shell = ShellFactory.createConsoleShell(
                "cmd",
                "My Notebook",
                commands);
        shell.commandLoop();
        System.out.println("CHAU!");
    }
}
