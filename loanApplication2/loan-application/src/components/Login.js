import axios from "axios";
import { useState, useEffect } from "react";
import { Route, Routes, Link, useNavigate, useParams } from "react-router-dom";
let BASE_CUSTOMER_URL = "http://localhost:8086/api/customer";


export function Login() {
  let [mail, setMail] = useState("");
  let [password, setPassword] = useState("");
  let [error, setError] = useState(""); //if profile not found set this error
  let [message, setMessage] = useState("");
  let [suc_message, setSucMessage] = useState("");
  let loginBymail = (e) => {
    e.preventDefault();
    axios
      .get(BASE_CUSTOMER_URL + "/getCustomer/" + mail)
      .then((res) => {res.data.password == password
          ? setSucMessage("Success")
          : setMessage("Invalid Password Please Check !!");
        setMail("");
        setPassword("");
      })
      .catch((e) => {
        setMail("");
        setPassword("");
        setError(e);
      });
  };
  return(<div className="w-25">
        <h2 style = {{padding: 10, margin:10}} >Login Form</h2>
        <form onSubmit={loginBymail}>
            <input style = {{padding: 10, margin:10}} type="text" autoComplete="off" className="form-control" placeholder="Enter Email"
            value = {mail} onChange={e => setMail(e.target.value)}/>
            <br/>
            <input style = {{padding: 10, margin:10}} type="password" autoComplete="off" className="form-control" placeholder="Enter password"
            value = {password} onChange={e => setPassword(e.target.value)}/>
            <br/>
            <input style = {{padding: 10, margin:10}}  type="submit" value='Login' className="btn btn-primary"></input>
            <br/>
            <div style = {{padding: 10, margin:10}} >{error != '' ? <div className="text-danger">{error}</div>: <div>Success!! Logged In</div>}</div>
        </form>
    </div>

     );
}