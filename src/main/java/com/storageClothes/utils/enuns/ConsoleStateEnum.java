package com.storageClothes.utils.enuns;

import com.storageClothes.utils.enuns.models.*;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

public enum ConsoleStateEnum {
    LOGIN(new LoginState()),
    WELCOME(new WelcomeState()),
    MENU(new MenuState()),
    CADASTER(new CadasterState()),
    REMOVE(new RemoveState()),
    UPDATE(new UpdateState()),
    CADASTER_CLOTHE(new CadasterClothe()),
    CADASTER_BRAND(new CadasterBrand()),
    CADASTER_CLOTHE_TYPE(new CadasterClotheType()),
    REMOVE_CLOTHE(new RemoveClothe()),
    REMOVE_BRAND(new RemoveBrand()),
    REMOVE_CLOTHE_TYPE(new RemoveClotheType());

    private final StateConsoleMachine stateConsoleMachine;

    ConsoleStateEnum(StateConsoleMachine stateConsoleMachine) {
        this.stateConsoleMachine = stateConsoleMachine;
    }

    public StateConsoleMachine getStateConsoleMachine() {
        return this.stateConsoleMachine;
    }
}
