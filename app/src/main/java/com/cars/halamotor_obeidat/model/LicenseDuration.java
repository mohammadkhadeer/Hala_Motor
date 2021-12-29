package com.cars.halamotor_obeidat.model;

public class LicenseDuration {
    String duration,durationS;

    public LicenseDuration(String duration, String durationS) {
        this.duration = duration;
        this.durationS = durationS;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDurationS() {
        return durationS;
    }

    public void setDurationS(String durationS) {
        this.durationS = durationS;
    }
}
