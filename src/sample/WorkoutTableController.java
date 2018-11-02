package sample;

public class WorkoutTableController {
    String exercise1,bodyparts,notes;
    Double repetitions,setts,weights,times,experiences;

    public String getExercise1() {
        return exercise1;
    }

    public void setExercise1(String exercise1) {
        this.exercise1 = exercise1;
    }

    public String getBodyparts() {
        return bodyparts;
    }

    public void setBodyparts(String bodyparts) {
        this.bodyparts = bodyparts;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Double getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(Double repetitions) {
        this.repetitions = repetitions;
    }

    public Double getSetts() {
        return setts;
    }

    public void setSetts(Double setts) {
        this.setts = setts;
    }

    public Double getWeights() {
        return weights;
    }

    public void setWeights(Double weights) {
        this.weights = weights;
    }

    public Double getTimes() {
        return times;
    }

    public void setTimes(Double times) {
        this.times = times;
    }

    public Double getExperiences() {
        return experiences;
    }

    public void setExperiences(Double experiences) {
        this.experiences = experiences;
    }

    public WorkoutTableController(String exercise1, String bodyparts, String notes, Double repetitions, Double setts, Double weights, Double times, Double experiences) {
        this.exercise1 = exercise1;
        this.bodyparts = bodyparts;
        this.notes = notes;
        this.repetitions = repetitions;
        this.setts = setts;
        this.weights = weights;
        this.times = times;
        this.experiences = experiences;
    }
}
