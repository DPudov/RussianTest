package tasks;

/**
 * Created by ${DPudov} on 03.04.2016.
 */
public interface ITaskManager {
    Task loadFromURL(String url);
    Task loadFromMicrosoftAccessDataBase(String directory);
}
