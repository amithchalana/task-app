package lk.ijse.dep9.app.util;

import lombok.Builder;

import javax.validation.groups.Default;

public interface ValidationGroups {    // this can be a method
    interface Create extends Default {

    }
    interface Update extends Default{

    }
    interface Delete extends Default{

    }
}
