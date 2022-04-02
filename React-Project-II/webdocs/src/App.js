
import '../src/UI/assets/css/style.css';
import '../src/UI/assets/css/bootstrap.min.css';
import '../src/UI/assets/css/bootstrap-datetimepicker.min.css';
import { BrowserRouter,Route, Routes } from "react-router-dom";
import '../src/UI/assets/font-awesome/css/font-awesome.css';
import '../src/UI/assets/font-awesome/css/font-awesome.min.css';
import Home from './Components/Home';
import PatientRegister from './Components/PatientRegister';
import DoctorRegister from './Components/DoctorRegister';
import Login from './Components/Login';
import DoctorLogin from './Components/DoctorLogin';
import PatientHome from './Components/PatientHome';
import DoctorList from './Components/DoctorList';



function App() {
  return (
    <BrowserRouter>
    <div>
      <Routes>
        <Route path="/" element={<Home></Home>}></Route>
        <Route path='/patient' element={<PatientRegister></PatientRegister>}></Route>
        <Route path='/patient/doctor' element={<DoctorRegister></DoctorRegister>}></Route>
        <Route path='/doctor/patient' element={<PatientRegister></PatientRegister>}></Route>
        
        <Route path='/doctor' element={<DoctorRegister></DoctorRegister>}></Route>
        <Route path='/doctorlogin' element={<DoctorLogin></DoctorLogin>}></Route>
        <Route path='/patientlogin' element={<Login></Login>}></Route>
        <Route path='/patienthome' element={<PatientHome></PatientHome>}></Route>
        <Route path='/doctorlist' element={<DoctorList></DoctorList>}></Route>
        
      </Routes>
    </div>
    </BrowserRouter>
  );
}

export default App;
