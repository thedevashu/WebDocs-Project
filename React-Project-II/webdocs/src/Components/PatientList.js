import React from "react"
import Navbar from "./Navbar"

export default class PatientList extends React.Component{

    state  = {patient_Id:0 , patient_DOB : new Date() , patient_Name : '', patient_Email:'', patient_Gender:'', patient_Mobile_number:'', patient_Username:'', patient_Password:'' , patients:[]}
   
    componentDidMount()
    {
        console.log("here")
         fetch("http://localhost:8080/patient/getAll", {
                       "method": "GET",
                     }).then(response => {
                    //   console.log(response.json()) 
                      
                         return response.json()      
                    }).then(jsondataarr => {
                       this.setState({
                         patients: jsondataarr        
                       } )})
                     
    }
    // getData=()=>
    // {
    //     var promise = fetch("http://localhost:8080/patient/getAll",{
    //         "method" : "GET"
    //     })

    //     var anotherpromise = promise.then(response =>{
    //         console.log(response.json())
    //             return response.json()
    //     })

    //     anotherpromise.then(arrofprod =>{       
    //         this.setState({
    //             patients : arrofprod
            
    //         })           
    //     })
        

    //     promise.catch(err => { console.log(err); 
    //     });
    // }

    

    render(){

        return(
            <div>
                <Navbar></Navbar>
            
                <div className="content">
				 <div className="container-fluid">

					<div className="section-header text-center">
						<div >
						
							{/* <!-- Profile Widget --> */}
							<div className="card widget-profile pat-widget-profile">
								<div className="card-body">
									<div className="pro-widget-content">
										{ <div className="profile-info-widget">
											
                                            {this.state.patients.map((e)=>{
                                             return (
                                                 <div>
                        
                                              <div className="profile-det-info">
												<h3>{e.patient_Name}</h3>
												
												<div className="patient-details">
													<h5><b>Patient ID :</b>{e.patient_Id}</h5>
                                                    <p>Phone :<span>{e.patient_Mobile_number}</span></p>
                                                    <p>Date of Birth : <span>{e.patient_DOB}</span></p>
                                                    <p>Gender : <span>{e.patient_Gender}</span></p>
                                                </div>
                                           </div>
                                           </div>
                                        )})}
                                        
										</div> }
                                        
									</div>
								</div>
							</div>
							{/* <!-- /Profile Widget --> */}
                            </div>         
            </div>
            </div>
            </div>
            </div>
        )
    }
    
}