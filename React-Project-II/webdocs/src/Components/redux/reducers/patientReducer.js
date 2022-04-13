import { ActionTypes } from "../constants/action-types";

const initialState = {
    patient: {

    }
};
export const patientReducer = (state = initialState, { type, payload }) => {
    switch (type) {
        case ActionTypes.SET_PATIENT:

            return { ...state, patient: payload };

        default:
            return state;
    }
}