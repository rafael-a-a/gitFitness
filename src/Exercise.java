public class Exercise {
    public String name, difficulty, description, targetMuscle;
    public int reps, sets, exID;

    public Exercise(String name, String difficulty, String description, String targetMuscle, int reps, int sets, int exID) {
        this.name = name;
        this.difficulty = difficulty;
        this.description = description;
        this.targetMuscle = targetMuscle;
        this.reps = reps;
        this.sets = sets;
        this.exID = exID;
    }
}
