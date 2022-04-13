
import '../src/UI/assets/css/style.css';
import '../src/UI/assets/css/bootstrap.min.css';
import '../src/UI/assets/css/bootstrap-datetimepicker.min.css';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from './Components/Home';
import PatientLogin from './Components/login/PatientLogin';
import PatientHome from './Components/PatientHome';




function App() {
  return (
    <BrowserRouter>
      <div>
        <Routes>
          <Route path="/" element={<Home></Home>}></Route>
          <Route path="/patientlogin" element={<PatientLogin></PatientLogin>}>

          </Route>
          <Route path='/patienthome' element={<PatientHome />}></Route>
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
