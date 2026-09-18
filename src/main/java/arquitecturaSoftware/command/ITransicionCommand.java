package arquitecturaSoftware.command;

public interface ITransicionCommand {
    public void ejecutar();
    public void deshacer();
}
