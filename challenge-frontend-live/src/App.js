
import axios from 'axios';
import './App.css';
import ChallengeList from './components/ChallengeList';
import { useEffect, useState } from 'react';
import AddChallenge from './components/AddChallenge';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {




  const[challenges,setChallenges]=useState([
]);

  useEffect(()=>{
     fetchChallenges();

  },[])


  const fetchChallenges=async()=>{

    try {
      const response=await axios.get("http://localhost:8080/challenges")
      console.log(response)
      setChallenges(response.data)

      
    } catch (error) {
      console.error("Error Happened",error)
      
    }
  };

  const handleChallengeAdded=()=>{
    fetchChallenges();
  }

  return (
    <div className="container mt-5">
      <h1 className='text-center mb-4'>Monthly Challenges</h1>
      <AddChallenge onChallengeAdded={handleChallengeAdded}/>
      <ChallengeList challenges={challenges} />
      
    </div>
  );
}

export default App;
