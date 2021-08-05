package com.solvd.airport.enums;

public enum PilotRol {
    PILOT(){
        @Override
        public void emergencyProcedure(){

        }
    },
    COPILOT(){
        @Override
        public void emergencyProcedure(){

        }
    };

    abstract void emergencyProcedure();
}
