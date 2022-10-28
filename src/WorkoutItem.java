public class WorkoutItem extends Workout{
    public int woID;
    public String date, time, realDuration;

    public WorkoutItem(double expDuration, int kcal, Exercise[] woPlan, String difficulty, User[] user, int woID, String date, String time, String realDuration) {
        super(expDuration, kcal, woPlan, difficulty, user);
        this.woID = woID;
        this.date = date;
        this.time = time;
        this.realDuration = realDuration;
    }
}
