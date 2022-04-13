import { combineReducers } from "redux";
import { patientReducer } from "./patientReducer";


const reducers = combineReducers({
    loggedPatient: patientReducer,
})

export default reducers