package com.cars.halamotor_obeidat.model;

public class DriverInformation {
    DriverProcess driverProcess;
    ProcessContent processContent;
    boolean processStatus;

    public DriverInformation(DriverProcess driverProcess, ProcessContent processContent, boolean processStatus) {
        this.driverProcess = driverProcess;
        this.processContent = processContent;
        this.processStatus = processStatus;
    }

    public DriverProcess getDriverProcess() {
        return driverProcess;
    }

    public void setDriverProcess(DriverProcess driverProcess) {
        this.driverProcess = driverProcess;
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
