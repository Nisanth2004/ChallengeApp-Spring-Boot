import axios from "axios";
import { useEffect, useState } from "react";

function AddChallenge({onChallengeAdded})
{

    const[month,setMonth]=useState('')
    const[description,setDescription]=useState('')



    const handleSubmit=async(e)=>{
        e.preventDefault();

        try {

            await axios.post("http://localhost:8080/challenges",{month,description})
            setMonth('')
            setDescription('')
            onChallengeAdded()
            
        } catch (error) {
            console.error("Error Adding Challenge",error);
            
        }
    }
    return(
        <div className="card my-5">
            <div className="card-header">
              Add New  Challenges
            </div>

            <div className="card-body">
            <form onSubmit={handleSubmit}>
      <div className="mb-3">
            <label htmlFor="month" className="form-label">Month</label>
     <input type="text" value={month} className="form-control" placeholder="e.g,. January"
            onChange={(e)=>setMonth(e.target.value)}
            required 
        ></input>
        </div>


        <div className="mb-3">
            <label htmlFor="description" className="form-label">Description</label>
     <textarea id="description" value={description} className="form-control" placeholder="Describe the Challenge"
            onChange={(e)=>setDescription(e.target.value)}
            required 
        ></textarea>
        </div>



<button type="submit" className="btn btn-success">Submit</button>
</form> 
</div>

        </div>
    )
}

export default AddChallenge;