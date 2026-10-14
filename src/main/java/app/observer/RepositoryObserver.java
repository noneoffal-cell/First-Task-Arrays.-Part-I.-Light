package app.observer;

import app.entity.IntArray;

public interface RepositoryObserver {

    void onArrayAdded(IntArray array);

    void onArrayUpdated(IntArray array);

    void onArrayRemoved(int id);
}
