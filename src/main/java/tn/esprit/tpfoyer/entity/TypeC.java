package tn.esprit.tpfoyer.entity;

public enum TypeC {
    SIMPLE(1), DOUBLE(2), TRIPLE(3);

    private final int capaciteMax;

    TypeC(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }
}