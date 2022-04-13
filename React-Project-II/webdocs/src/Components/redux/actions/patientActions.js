import { ActionTypes } from "../constants/action-types"
export const setPatient = (patient) => {
    return {
        type: ActionTypes.SET_PATIENT,
        payload: patient,
    }
}
export const selectedPatient = (patient) => {
    return {
        type: ActionTypes.SELECTED_PATIENT,
        payload: patient,
    }
}