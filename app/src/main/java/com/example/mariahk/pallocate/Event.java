package com.example.mariahk.pallocate;

/**
 * Created by mariahk on 4/30/16.
 */
public class Event {
        public String nameEvent;
        public String locationEvent;
        public String timeEvent;
        public String namePerson;

        public Event(String namePerson, String locationEvent, String timeEvent, String nameEvent) {
            this.nameEvent = nameEvent;
            this.locationEvent = locationEvent;
            this.timeEvent = timeEvent;
            this.namePerson = namePerson;
        }
    /*
        public Event(Event event) {
            this.nameEvent = event.nameEvent;
            this.locationEvent = event.locationEvent;
            this.timeEvent = event.timeEvent;
            this.namePerson = event.namePerson;
        }

        // Get Name of the event
        public String getNameEvent() {
            return nameEvent;
        }


        // Get location of the event
        public String getLocationEvent() {
            return locationEvent;
        }

        // Get time of the event
        public String getTimeEvent() {
            return timeEvent;
        }

        // Get name of the the person
        public String getNamePerson() {
            return namePerson;
        }*/
}
