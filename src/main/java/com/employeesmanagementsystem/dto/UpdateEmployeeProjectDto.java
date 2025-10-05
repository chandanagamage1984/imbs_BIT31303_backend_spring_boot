package com.employeesmanagementsystem.dto;

public class UpdateEmployeeProjectDto {
    private int oldEmployeeId;
    private int oldProjectId;
    private int newEmployeeId;
    private int newProjectId;

    // Constructors
    public UpdateEmployeeProjectDto() {
    }

    public UpdateEmployeeProjectDto(int oldEmployeeId, int oldProjectId, int newEmployeeId, int newProjectId) {
        this.oldEmployeeId = oldEmployeeId;
        this.oldProjectId = oldProjectId;
        this.newEmployeeId = newEmployeeId;
        this.newProjectId = newProjectId;
    }

    // Getters and Setters
    public int getOldEmployeeId() {
        return oldEmployeeId;
    }

    public void setOldEmployeeId(int oldEmployeeId) {
        this.oldEmployeeId = oldEmployeeId;
    }

    public int getOldProjectId() {
        return oldProjectId;
    }

    public void setOldProjectId(int oldProjectId) {
        this.oldProjectId = oldProjectId;
    }

    public int getNewEmployeeId() {
        return newEmployeeId;
    }

    public void setNewEmployeeId(int newEmployeeId) {
        this.newEmployeeId = newEmployeeId;
    }

    public int getNewProjectId() {
        return newProjectId;
    }

    public void setNewProjectId(int newProjectId) {
        this.newProjectId = newProjectId;
    }
}