package com.storageClothes.utils.enuns;

import com.storageClothes.utils.enuns.models.*;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

public enum ConsoleStateEnum {
    LOGIN(new LoginState()),
    WELCOME(new WelcomeState()),
    MENU(new MenuState()),
    CADASTER(new CadasterState()),
    CADASTER_CLOTHE(new CadasterClothe()),
    CADASTER_BRAND(new CadasterBrand());

    private final StateConsoleMachine stateConsoleMachine;

    ConsoleStateEnum(StateConsoleMachine stateConsoleMachine) {
        this.stateConsoleMachine = stateConsoleMachine;
    }

    public StateConsoleMachine getStateConsoleMachine() {
        return this.stateConsoleMachine;
    }
}
