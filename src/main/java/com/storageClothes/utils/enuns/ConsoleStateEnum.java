package com.storageClothes.utils.enuns;

import com.storageClothes.utils.enuns.models.*;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

public enum ConsoleStateEnum {
    LOGIN(new LoginState()),
    MENU(new MenuState()),
    CADASTER(new CadasterState()),
    REMOVE(new RemoveState()),
    UPDATE(new UpdateState()),
    SHOW(new ShowState()),
    CADASTER_CLOTHE(new CadasterClothe()),
    CADASTER_BRAND(new CadasterBrand()),
    CADASTER_CLOTHE_TYPE(new CadasterClotheType()),
    REMOVE_CLOTHE(new RemoveClothe()),
    REMOVE_BRAND(new RemoveBrand()),
    REMOVE_CLOTHE_TYPE(new RemoveClotheType()),
    SHOW_CLOTHES(new ShowClothes()),
    SHOW_CLOTHE_TYPE(new ShowClotheType()),
    SHOW_BRANDS(new ShowBrands()),
    UPDATE_CLOTHE_TYPE(new UpdateClotheType()),
    UPDATE_CLOTHE(new UpdateClothe()),
    UPDATE_BRAND(new UpdateBrand());

    private final StateConsoleMachine stateConsoleMachine;

    ConsoleStateEnum(StateConsoleMachine stateConsoleMachine) {
        this.stateConsoleMachine = stateConsoleMachine;
    }

    public StateConsoleMachine getStateConsoleMachine() {
        return this.stateConsoleMachine;
    }
}
