import { useState } from "react";
import "./App.css";

function App() {
  const [value1, setValu1] = useState("");
  const [value2, setValu2] = useState("");
  const [value3, setValu3] = useState("");
  const [value4, setValu4] = useState("");
  const [value5, setValu5] = useState("");

  async function PostData(){
    const result = await fetch("http://localhost:8080/addQuestion","POST",{
      "Question":value1,
      "Option1":value2,
      "Option2":value3,
      "Option3":value4,
      "Option4":value5
    });
    console.log(result);
  }

  return (
    <>
      <div>
        <input
          onChange={(e) => {
            setValu1(e.target.value);
          }}
          type="text"
        />
      </div>
      <div>
        <input
          onChange={(e) => {
            setValu2(e.target.value);
          }}
          type="text"
        />
      </div>
      <div>
        <input
          onChange={(e) => {
            setValu3(e.target.value);
          }}
          type="text"
        />
      </div>
      <div>
        <input
          onChange={(e) => {
            setValu4(e.target.value);
          }}
          type="text"
        />
      </div>
      <div>
        <input
          onChange={(e) => {
            setValu5(e.target.value);
          }}
          type="text"
        />
      </div>
      <button onClick={()=>{PostData()}}>Submit</button>
    </>
  );
}

export default App;
