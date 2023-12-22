import logo from './logo.svg';
import './App.css';
import { Route, Routes } from 'react-router-dom';
import { CustomerRegistration } from './components/Customer';
import { Login } from './components/Login';

function App() {
  return (
    <div className='container-fluid'>
      <h2 className='alert alert-primary text-center' style = {{padding: 10, margin:10}}  >Loan Management App</h2>
      
      <div className='row'>
        <div className='col'>
          <Routes>
            <Route path='' element = {<CustomerRegistration/>}></Route>
            <Route path='/login' element = {<Login/>}></Route>
          </Routes>
        </div>
      </div>
    </div>
  );
}

export default App;
