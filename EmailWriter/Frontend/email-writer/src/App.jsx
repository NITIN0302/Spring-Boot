import "./App.css";
import { useState, useEffect } from "react";

function App() {
  const [message] = useState("Generate Your Email Reply...");
  const [replyMessage, setReplyMessage] = useState("");
  const [emailContent,setEmailContent] = useState("");
  const [tone,setTone] = useState("");

  async function getData() {
    const response = await fetch("http://localhost:8080/api/email/generate", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        "emailContent": emailContent,
        "tone": tone
      }),
    });
    const result = await response.json(); 
    setReplyMessage(result);
  }

  return (
    <div className="text-white h-screen w-full flex flex-wrap justify-around bg-gray-700 p-2">
      <div className="h-full w-[35%] md:w-[55%] flex justify-center items-center">
        <h1 className="text-5xl font-bold text-center text-white">{message}</h1>
      </div>
      <div className="h-full w-[60%] md:w-[40%] rounded-md flex flex-wrap opacity-70 bg-black justify-center border py-8 px-4 border-blue-700">
        <div className="h-[35%] w-full flex flex-wrap justify-center">
          <textarea
            id="emailData"
            className="w-full border rounded-md border-blue-500 outline-none bg-gray-700 p-2"
            placeholder="Place Your Email..."
            onChange={(e)=>{setEmailContent(e.target.value)}}
          />
        </div>
        <div className="h-[10%] w-full flex flex-wrap justify-center rounded-md py-1">
          <select
            name=""
            id="tone"
            className="w-full border outline-none border-blue-400 px-2 rounded-md bg-gray-700"
            onChange={(e)=>{setTone(e.target.value)}}
          >
            <option value="" disabled selected>
              Select you tone
            </option>
            <option value="Funny">Funny</option>
            <option value="Casual">Casual</option>
            <option value="Formal">Formal</option>
          </select>
        </div>
        <div className="h-[40%] w-full flex flex-wrap justify-center">
          <textarea
            id="replyData"
            value={replyMessage}
            className="w-full border rounded-md border-blue-500 outline-none bg-gray-700 p-2"
            placeholder="Your Resulted Reply..."
            type="text"
          />
        </div>
        <div className="h-[10%] py-4 w-full flex flex-wrap justify-end">
          <button
            onClick={getData}
            className="rounded-md py-1 border-2 border-blue-400 hover:bg-black hover:border-2 hover:border-blue-400 px-2 bg-blue-400"
          >
            Get Email
          </button>
        </div>
      </div>
    </div>
  );
}

export default App;
