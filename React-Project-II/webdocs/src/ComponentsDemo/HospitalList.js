import React from "react"
import Navbar from "./Navbar"

export default class HospitalList extends React.Component{

    state  = {hospital_Id:0 , hospital_Name : '',hospital_Address : '', hospitals:[]}
   
    componentDidMount()
    {
        console.log("here")
         fetch("http://localhost:8080/hospital/getAll", {
                       "method": "GET",
                     }).then(response => {
                    //   console.log(response.json()) 
                      
                         return response.json()      
                    }).then(jsondataarr => {
                       this.setState({
                        hospitals: jsondataarr        
                       } )})
                     
    }
  

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
											
                                            {this.state.hospitals.map((e)=>{
                                             return (
                                                 <div>
                        
                                              <div className="profile-det-info">
                                              <div className="patient-details">
												<h3><b>Hospital Name : </b>{e.hospital_Name}</h3>
												<h3><b>Hospital Address : </b>{e.hospital_Address}</h3>
                                                <hr></hr>
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