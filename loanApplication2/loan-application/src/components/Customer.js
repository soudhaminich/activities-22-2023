// this file talks to the real backend api's, since we already have the Profile component we will create 
// UserProfile as a prefix to work with all the backend

import axios from "axios";
import { useEffect, useState } from "react";
import { Link, useNavigate, useParams, Route, Routes } from "react-router-dom";

let BASE_CUSTOMER_URL = 'http://localhost:8086/api/customer';
let BASE_LOAN_URL = 'http://localhost:8086/api/loan';

// export function UserProfileLogin(){
//     let [id, setId] = useState('');
//     let [error, setError] = useState(''); // if profile not found set this error
//     let navigate = useNavigate();
//     //callback to login
//     let loginById = (e) => {
//         e.preventDefault();
//         axios.get(BASE_URL+'/'+id)
//         .then( (res) => navigate('/success/'+id) )
//         .catch(e => {
//             console.log(e);
//             setId('');
//             setError(e.response.data.error);
//         });
//     };
//     return (<div className="w-25">
//         <h2>Login Form</h2>
//         <form onSubmit={loginById}>
//             <input type="number" autoComplete="off" className="form-control"
//             value = {id} onChange={e => setId(e.target.value)}/>
//             <input type="submit" value='Login' className="btn btn-primary"></input>
//             <div>{error != '' ? <div className="text-danger">{error}</div>: <div></div>}</div>
//             <div>
//                 <Link to = '/register'>Create Profile</Link>
//             </div>
//         </form>
//     </div>)

// }

// Storing the profile by calling the backend api
export function CustomerRegistration(){
    // states for name, phone, birthday,  password
    let [firstname, setFirstName] = useState('');
    let [lastname, setLastName] = useState('');
    let [email_id, setEmailId] = useState('');
    let [password, setPassword] = useState('');
    let [phone, setPhone] = useState('');
    let [pan, setPan] = useState('');
    let [customer_id, setCustomerId] = useState('');
    let [message, setMessage] = useState(''); // to show success message

    let valueReset = (e) =>{
        setFirstName('');
        setLastName('');
        setPassword('');
        setPhone('');
        setEmailId('');
        setPan('');
    }

    //handler to store the form data
    let store = (e) =>{
        e.preventDefault();
        axios.post(BASE_CUSTOMER_URL, {"firstname": firstname, "lastname": lastname, "email": email_id, "password": password, "phone": phone, "pan": pan})
        .then( r => {setCustomerId(r.data.customer_id); console.log(r.data);
                     setMessage(`Profile stored with id: ${r.data.customer_id}`);
                        setFirstName('');
                        setLastName('');
                        setPassword('');
                        setPhone('');
                        setEmailId('');
                        setPan('');
        })
        .catch(err => {console.log(err);setMessage("Oops Error Occured");
                        setFirstName('');
                        setLastName('');
                        setPassword('');
                        setPhone('');
                        setEmailId('');
                        setPan('');
                })
    }
    return (<div className="w-25" style={{margin: 10, padding: 10}}>
        <h2 style={{margin: 5, padding: 5}}>Register Here</h2>
        <hr/>
        <form onSubmit={store}>
            <div>
                <input style={{margin: 5, padding: 10}} type="text" placeholder="Enter First Name" autoComplete="off" value={firstname}
                className="form-control" onChange={ e => setFirstName(e.target.value)}/>
            </div>
            <div>
                <input style={{margin: 5, padding: 10}} type="text" placeholder="Enter Last Name" autoComplete="off" value={lastname}
                className="form-control" onChange={ e => setLastName(e.target.value)}/>
            </div>
            <div>
                <input style={{margin: 5, padding: 10}} type="text" placeholder="Enter Mail Id" autoComplete="off" value={email_id}
                className="form-control" onChange={ e => setEmailId(e.target.value)}/>
            </div>
            <div>
                <input style={{margin: 5, padding: 10}} type="password" placeholder="Enter Password" value={password}
                className="form-control" onChange={ e => setPassword(e.target.value)}/>
            </div>
            <div>
                <input style={{margin: 5, padding: 10}} type="number" placeholder="Enter Mobile Number"  value={phone}
                className="form-control" onChange={ e => setPhone(e.target.value)}/>
            </div>
            <div>
                <input style={{margin: 5, padding: 10}} type="text" placeholder="Enter Pan"  value={pan}
                className="form-control" onChange={ e => setPan(e.target.value)}/>
            </div>
           
            <div>
                <input style={{margin: 5, padding: 10}} type="submit"  value='Register' className="btn btn-primary"/>
                <input style={{margin: 5, padding: 10}} type="reset"  value='Reset' onClick={valueReset} className="btn btn-secondary"/>
            </div>
            <div>
                {message != '' ? <div className="text-success"><b>{message}</b></div>:<div></div>}
            </div>
        </form>
        <hr/>

    </div>)



}

// export function UserProfileList(){
//     // state to store the profiles
//     let [profiles, setProfiles] = useState([]);
//     // handler that sends the request to the backend
//     let loadProfiles = (e) => {
//         axios.get(BASE_URL)
//             .then(response => setProfiles(response.data))
//             .catch(error => console.log(error));
//     };
//     return (<div>
//         <h2>List of Profiles</h2><hr/>
//         <button onClick= {loadProfiles} className="btn btn-secondary">Load All Profiles</button><hr/>
//         <div className="row">
//             {
//                 profiles.map((item, index) => 
//                 <p key = {index}>
//                     <b>Id: </b> {item.id}, <b>Name: </b> {item.name}, <b>Birthday: </b> {item.birthday}, 
//                     <b> No.Of Contacts: </b> {item.contacts.length}
//                 </p>)
//             }
//         </div>
//         <h3>Displaying the same output using card, with dummy images</h3>
//         <div className = 'row'>
//             {
//                 profiles.map((item, index) => <div key = {index} className = 'col-4'>
//                     <div className="card" style={{width: '18rem'}}>
//                         <img src= 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRMhuYcyWOfOrmXs7ItuvY2wnvJdNdid_euww&usqp=CAU' 
//                             className="card-img-top" style={{height:'30vh'}} />
//                         <div className="card-body">
//                             <h5 className="card-title">Name: {item.name}</h5>
//                             <p>Id: {item.id}</p>
//                             <p>Phone: {item.phone}</p>
//                             <p>Birthday: {item.birthday}</p>
//                             <p>No. of contacts: {item.contacts.length}</p>
//                         </div>
//                     </div>
//                 </div>)
//             }
//         </div>
//     </div>)
// }