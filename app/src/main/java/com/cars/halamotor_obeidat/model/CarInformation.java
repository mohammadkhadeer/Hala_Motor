package com.cars.halamotor_obeidat.model;

public class CarInformation {
    CarProcess carProcess;
    ProcessContent processContent;
    boolean processStatus;

    public CarInformation(CarProcess carProcess, ProcessContent processContent, boolean processStatus) {
        this.carProcess = carProcess;
        this.processContent = processContent;
        this.processStatus = processStatus;
    }

    public CarProcess getCarProcess() {
        return carProcess;
    }

    public void setCarProcess(CarProcess carProcess) {
        this.carProcess = carProcess;
    }

    public ProcessContent getProcessContent() {
        return processContent;
    }

    public void setProcessContent(ProcessContent processContent) {
        this.processContent = processContent;
    }

    public boolean isProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(boolean processStatus) {
        this.processStatus = processStatus;
    }
}
