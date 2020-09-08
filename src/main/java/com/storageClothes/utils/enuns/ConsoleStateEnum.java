package com.storageClothes.utils.enuns;

import com.storageClothes.utils.enuns.models.CadasterState;
import com.storageClothes.utils.enuns.models.LoginState;
import com.storageClothes.utils.enuns.models.MenuState;
import com.storageClothes.utils.enuns.models.WelcomeState;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

public enum ConsoleStateEnum {
    LOGIN(new LoginState()),
    WELCOME(new WelcomeState()),
    MENU(new MenuState()),
    CADASTER_CLOTHE(new CadasterState());

    private final StateConsoleMachine stateConsoleMachine;

    ConsoleStateEnum(StateConsoleMachine stateConsoleMachine) {
        this.stateConsoleMachine = stateConsoleMachine;
    }

    public StateConsoleMachine getStateConsoleMachine() {
        return this.stateConsoleMachine;
    }
}
