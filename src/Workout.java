public class Workout {
    public double expDuration;
    public int kcal;
    public Exercise[] woPlan;
    public String difficulty;
    public User[] user;

    public Workout(double expDuration, int kcal, Exercise[] woPlan, String difficulty, User[] user) {
        this.expDuration = expDuration;
        this.kcal = kcal;
        this.woPlan = woPlan;
        this.difficulty = difficulty;
        this.user = user;
    }
}
