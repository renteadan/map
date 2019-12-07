package Observer;

public interface Observer {
  void addObservable(Observable observable);
  void notifyObservables();
}
