package gym.rest;

import java.util.List;

public class StateRest<T> {
    private List<T> state;
    private double reward;
    private boolean terminal;

    public List<T> getState() {
        return state;
    }

    public void setState(List<T> state) {
        