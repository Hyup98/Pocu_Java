package academy.pocu.comp2500.assignment4;

public interface ICommand {
    abstract boolean execute();
    abstract boolean undo();
    abstract boolean redo();
}
