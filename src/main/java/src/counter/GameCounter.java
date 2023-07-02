package src.counter;

public class GameCounter {

    private int generation;
    private int population;

    public void GenerationCounter() {
        generation = 0;
        population = 0;
    }

    public void updateGeneration() {
        generation++;
    }

    public void updatePopulation(int count) {
        population = count;
    }

    public int getGeneration() {
        return generation;
    }

    public int getPopulation() {
        return population;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void reset() {
        generation = 0;
        population = 0;
    }
}
