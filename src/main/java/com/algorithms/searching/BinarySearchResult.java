package main.java.com.algorithms.searching;

public class BinarySearchResult {
    private boolean exists;
    private int position = -1;

    public BinarySearchResult(boolean exists, int position) {
        this.exists = exists;
        this.position = position;
    }

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}