package com.example.project.entity;

public class EventsAthletes {
    private long idEvent;
    private long idAthlete;

    public EventsAthletes() { }

    public EventsAthletes(long idEvent, long idAthlete) {
        this.idEvent = idEvent;
        this.idAthlete = idAthlete;
    }

    public long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(long idEvent) {
        this.idEvent = idEvent;
    }

    public long getIdAthlete() {
        return idAthlete;
    }

    public void setIdAthlete(long idAthlete) {
        this.idAthlete = idAthlete;
    }
}
